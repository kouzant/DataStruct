package business;

import java.util.Scanner;

import entities.*;
import structures.*;

/**
 * Κεντρική κλάση της εφαρμογής, όπου τυπώνει το μενού
 * και ανάλογα την επιλογή καλεί τις κατάλληλες μεθόδους.
 */
public class Main {
	/**
	 * Αρχικοποιεί την εφαρμογή, τυπώνει το μενού και καλεί
	 * τις κατάλληλες μεθόδους.
	 * @param args
	 */
	public static void main(String[] args) {
		//Δημιουργία μιας διπλά συνδεδεμένης λίστας για την
		//αποθήκευση των διαθέσιμων πτήσεων
		DoublyLinkedList<Flight> flights=new DoublyLinkedList<Flight>();
		//Δημιουργία αντικειμένου της κλάσης FlightBusiness που είναι
		//υπεύθυνη για τη διαχείριση των πτήσεων.
		FlightsBusiness flightB=new FlightsBusiness();
		flightB.setFlightsList(flights);
		//Φορτώνει κάποιες πτήσεις στο σύστημα
		flightB.loadFlights();
		//Δημιουργία μιας διπλά δυνδεδεμένης λίστας για την
		//αποθήκευση των επιβατών-κρατήσεων
		DoublyLinkedList<Passenger> passengers=new DoublyLinkedList<Passenger>();
		//Δημιουργία αντικειμένου της κλάσης PassengerBusiness που είναι
		//υπεύθυνη για τη διαχείριση των επιβατών
		PassengerBusiness passB=new PassengerBusiness();
		passB.setPassengersList(passengers);
		
		Scanner inM=new Scanner(System.in);
		//Κλειδί για την επαναλαμβανόμενη εκτύπωση του κεντρικού μενού
		boolean running=true;
		System.out.println("Welcome to the airline booking system");
		System.out.println("");
		while(running){
			System.out.println("Please make your choice");
			System.out.println("<--------------------->");
			System.out.println("1 -- View available flights");
			System.out.println("2 -- Add Flight");
			System.out.println("3 -- Delete Flight");
			System.out.println("4 -- Add Passenger");
			System.out.println("5 -- List Passengers");
			System.out.println("6 -- Delete Passenger");
			System.out.println("0 -- Exit");
			int choice=inM.nextInt();

			switch (choice) {
			case 1:
				//Προβολή διαθέσιμων πτήσεων
				flightB.listFlights();
				break;
			case 2:
				//Προσθήκη νέας πτήσης
				flightB.addFlight();
				break;
			case 3:
				//Διαγραφή μιας πτήσης
				flightB.removeFlight();
				break;
			case 4:
				//Προσθήκη μιας νέας κράτησης
				//Συμπληρώνει ο χρήστης τα απαραίτητα στοιχεία
				//και επιστρέφεται σαν String array οι κωδικοί
				//πτήσεων που έχει δώσει
				String[] codeFlights=passB.askAddPassenger();
				//Σύμφωνα με τους κωδικούς πτήσων ελέγχεται αν η
				//κράτηση είναι έγγυρη. Σχετικά με την εγγυρότητα
				//δείτε την παρακάτω μέθοδο. Αν είναι έγγυρη επιστρέφει
				//true αλλιώς false
				boolean valid=flightB.validateFlights(codeFlights);
				if(valid){
					//Αν είναι έγγυρη
					//Προσθέτει τον χρήστη στη λίστα με τους επιβάτες,
					//επιστρέφει το μοναδικό αναγνωριστικό κράτησης
					String bookingID=passB.addPassenger(codeFlights);
					//Βρίσκει ποιός κόμβος στην λίστα είναι ο συγκεκριμένος
					//επιβάτης
					int index=passB.searchForCode(bookingID);
					Passenger newPassenger=passengers.getNodeValue(index);
					int listLength=newPassenger.getBookedFlights().getLength();
					boolean available=true;
					for(int i=0;i<listLength;i++){
						//Ελεγχεί για κάθε κωδικό πτήσης αν υπάρχουν διαθέσιμες
						//θέσεις. Αν έστω και μία πτήση δεν έχει διαθέσιμες
						//θέσεις, τότε ο επιβάτης μπαίνει στις λίστες αναμονής
						//για κάθε μία πτήση. Για λεπτομέρειες δείτε την παρακάτω
						//μέθοδο
						available=flightB.checkAvailability(newPassenger.getBookedFlights().getNodeValue(i));
						if(available==false)
							break;
					}
					for(int i=0;i<listLength;i++){
						//Από τη λίστα με τους κωδικούς πτήσεων του επιβάτη, πέρνει
						//ένα-ένα τον κωδικό
						String flightID=newPassenger.getBookedFlights().getNodeValue(i);
						//Και κάνει μία κράτηση. Αν το available είναι true,
						//τους βάζει στη λίστα επιβίβασης αλλιώς τους βάζει
						//στη λίστα αναμονής
						flightB.bookFlight(bookingID, flightID, available);
					}
					//Τυπώνεται αντίστοιχο μήνυμα και θέτει την κατάσταση
					//κράτησης του χρήστη σε true ή false.
					if(available){
						newPassenger.setStatus(true);
						System.out.println("Your booking was successful");
					}else{
						newPassenger.setStatus(false);
						System.out.println("There were no available seats. You've been " +
						"placed to the waiting queue");
					}
					//Τυπώνει το μοναδικό αναγνωριστικό χρήστη για
					//πιθανή διαγραφή της κράτησης
					System.out.println("Your booking code is: "+bookingID);
					System.out.println("");
				}else{
					//Αν οι κωδικοί πτήσεις δεν συμβαδίζουν τότε τυπώνεται
					//κατάλληλο μήνυμα
					System.out.println("The flights' details were incorrect");
					System.out.println("");
				}
				break;
			case 5:
				//Προβολή όλων των επιβατών
				//Για λεπτομέρειες δείτε την παρακάτων μέθοδο
				passB.listPassengers();
				break;
			case 6:
				//Διαγραφή επιβάτη
				//Ο επιβάτης συμπληρώνει το μοναδικό
				//αναγνωριστικό του
				String bookingID=passB.askRemovePassenger();
				//Βρίσκει ποιος κόμβος από τη λίστα με τους επιβάτες
				//είναι ο συγκεκριμένος.
				int index=passB.searchForCode(bookingID);
				Passenger delPassenger=passengers.getNodeValue(index);
				//Παίρνει τη λίστα με τους κωδικούς πτήσεων που έχει κάνει
				//κράτηση ο χρήστης.
				SimplyLinkedList<String> bookedFlights=delPassenger.getBookedFlights();
				int listLength=delPassenger.getBookedFlights().getLength();
				//Η κατάσταση της κράτησης του χρήστη
				boolean status=delPassenger.getStatus();
					if(status==false){
						//Αν ο χρήστης ήταν στις ουρές αναμονής των πτήσεων
						//και όχι στις λίστες επιβίβασης
						for(int i=0;i<listLength;i++){
							//Για κάθε ένα κωδικό πτήσης που έχει κάνει κράτηση
							String flightCode=delPassenger.getBookedFlights().getNodeValue(i);
							//Διαγράφει τον επιβάτη. Για λεπτομέρειες δείτε την
							//παρακάτω μέθοδο
							flightB.delPendingCode(bookingID, flightCode);
						}
						//Διαγράφει τον επιβάτη από τη λίστα με τους επιβάτες
						passB.removePassenger(bookingID);
					}else{
						//Αν ο χρήστης ήταν στις λίστες επιβίβασης.
						//Διαγράφουμε τον χρήστη από τη boarding list κάθε πτήσης
						//και πέρνουμε την ουρά αναμονής της πρώτης πτήσης σε σείρα.
						//Λεπτομερώς στην υλοποίηση της παρακάτω μεθόδου
						SimplyLinkedList<String> queueCodes=flightB.delBoardedCodePre(bookingID, bookedFlights);
						//Μία λίστα που θα έχει αντικείμενα τύπου Passenger.
						//Θα κρατάει τους επιβάτες που είναι στην ουρά αναμονής
						//της παραπάνω πτήσης
						SimplyLinkedList<Passenger> queuePassengers=new SimplyLinkedList<Passenger>();
						//Αντιστοιχίζει τους κωδικούς επιβατών από τη λίστα queueCodes
						//σε αντικείμενα τύπου Passenger στη λίστα queuePassengers
						for(int j=0;j<queueCodes.getLength();j++){
							index=passB.searchForCode(queueCodes.getNodeValue(j));
							queuePassengers.addTail(passengers.getNodeValue(index));
						}
						if(queuePassengers!=null){
							//Αν υπάρχουν επιβάτες στην ουρά αναμονής
							//Ψάχνει για επιβάτες στην ουρά αναμονής που θα 
							//πληρούσαν τα κριτήρια για να μπουν στις boarding
							//lists των δικών τους πτήσεων. Αν βρεθεί, επιστρέφεται
							//ο κωδικός του επιβάτη-κράτησης
							String luckyBookingCode=flightB.delBoardedCodePost(queuePassengers);
							if(luckyBookingCode!=null){
								//Στον παραπάνω επιβάτη ορίζουμε το status σε true
								//Δηλαδή είναι σε στις λίστες επιβίβασης και όχι
								//στις λίστες αναμονής
								int indexb=passB.searchForCode(luckyBookingCode);
								passengers.getNodeValue(indexb).setStatus(true);
							}
							//Τέλος αφαιρούμε τον επιβάτη από
							//τη λίστα με τους επιβάτες
							passB.removePassenger(bookingID);
						}
					}
				break;
			case 0:
				//Έξοδος από την εφαρμογή
				//Το running είναι false οπότε σταματάει
				//να εκτελείται η επανάληψη
				running=false;
				System.out.println("");
				System.out.println("Arrivederci");
				break;
			default:
				//Σε περίπτωση που δοθεί επιλογή που δεν αντιστοιχεί
				//σε κάποιο από τα παραπάνω τυπώνει κατάλληλο μήνυμα
				//λάθους
				System.out.println("No available choice!");
				break;
			}
		}
	}
}
