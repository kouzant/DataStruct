package business;

import java.util.Scanner;
import java.util.Date;
import java.util.GregorianCalendar;

import entities.Flight;
import entities.Passenger;
import structures.DoublyLinkedList;
import structures.FifoQueue;
import structures.SimplyLinkedList;

/**
 * Κλάση με μεθόδους για την διαχείριση των πτήσεων
 * και ότι έχει σχέση με αυτές.
 */
public class FlightsBusiness {
	private DoublyLinkedList<Flight> flights;
	/**
	 * Ορίζει τη λίστα με τις διαθέσιμες πτήσεις για την
	 * κλάση αυτή.
	 * 
	 * @param flights Η λίστα με τις διαθέσιμες κλάσεις.
	 */
	public void setFlightsList(DoublyLinkedList<Flight> flights){
		this.flights=flights;
	}
	/**
	 * Παίρνουμε τη λίστα με τις διαθέσιμες πτήσεις.
	 * 
	 * @return Τη λίστα με τις διαθέσιμες πτήσεις.
	 */
	public DoublyLinkedList<Flight> getFlightsList(){
		return flights;
	}
	/**
	 * Μέθοδος για την φόρτωση στο σύστημα μερικών πτήσεων.
	 * Κάνει χρήση των GregorianCalendar και Date της Java
	 * για την αναπαράσταση των ημερομηνιών.
	 * @see DoublyLinkedList#addTail(Object)
	 * @see Flight#Flight(String, String, String, Date, Date, double, String,
	 *  int, int)
	 */
	public void loadFlights(){
		Date departureDate=new GregorianCalendar(2011,04,15,18,15).getTime();
		Date arrivalDate=new GregorianCalendar(2011,04,15,20,30).getTime();
		//Δημιουργείται ένα νέο instance της κλάσης Flight για την
		//αποθήκευση μιας νέας πτήσης
		Flight flight=new Flight("EZY8567", "Athens", "London", departureDate,
				arrivalDate, 180.50, "Airbus 320", 100, 5);
		//Προσθήκη της παραπάνω πτήσης στη λίστα με
		//τις διαθέσιμες πτήσεις
		flights.addTail(flight);
		
		departureDate=new GregorianCalendar(2011, 04, 16, 15, 00).getTime();
		arrivalDate=new GregorianCalendar(2011, 04, 16, 17, 30).getTime();
		flight=new Flight("ABC1234", "London", "Dublin", departureDate,
				arrivalDate, 100, "Airbus123", 50, 10);
		flights.addTail(flight);
		
		departureDate=new GregorianCalendar(2011, 04, 16, 20, 10).getTime();
		arrivalDate=new GregorianCalendar(2011, 05, 1, 13, 40).getTime();
		flight=new Flight("DEF5678", "Dublin", "Alexandria", departureDate,
				arrivalDate, 200.20, "Airbus 450", 200, 8);
		flights.addTail(flight);
		
		departureDate=new GregorianCalendar(2011, 06, 1, 8, 2).getTime();
		arrivalDate=new GregorianCalendar(2011, 06, 1, 13, 40).getTime();
		flight=new Flight("ERT1234", "Athens", "Rome", departureDate,
				arrivalDate, 200.20, "Airbus 450", 100, 20);
		flights.addTail(flight);
	}
	/**
	 * Τυπώνει όλες τις διαθέσιμες πτήσεις.
	 * @see Flight#toString()
	 * @see DoublyLinkedList#toString()
	 */
	public void listFlights(){
		//Χρησιμοποιεί τις μεθόδους toString για να τυπώσει
		//τις πτήσεις
		System.out.println(flights);
	}
	/**
	 * Παίρνει όλα τα απαραίτητα στοιχεία από τον
	 * χρήστη και προσθέτει μία νέα πτήση στην εφαρμογή.
	 * @see Flight#Flight(String, String, String, Date, Date, double, String,
	 *  int, int)
	 * @see DoublyLinkedList#addTail(Object)
	 */
	public void addFlight(){
		Scanner in=new Scanner(System.in);
		//Μαζεύει τα απαραίτητα στοιχεία από
		//τον χρήστη
		System.out.println("Flight Code:");
		String flightCode=in.nextLine();
		System.out.println("Starting Point:");
		String startingPoint=in.nextLine();
		System.out.println("Destination:");
		String destination=in.nextLine();
		System.out.println("Departure Time (yyyy:mm:dd:hh:mm)");
		String depTime=in.nextLine();
		System.out.println("Arrival Time (yyyy:mm:dd:hh:mm)");
		String arTime=in.nextLine();
		System.out.println("Plane Type:");
		String planeType=in.nextLine();
		System.out.println("Total Seats:");
		int totalSeats=in.nextInt();
		System.out.println("Available Seats:");
		int availableSeats=in.nextInt();
		System.out.println("Ticket Price:");
		double ticketPrice= in.nextDouble();
		//Χωρίζει το έτος,μήνα,ημέρα,ώρα και λεπτά
		//με διαχωριστικό το ':'
		String[] tmpDTime=depTime.split("[:]");
		String[] tmpATime=arTime.split("[:]");
		Date departureTime=new GregorianCalendar(Integer.parseInt(tmpDTime[0]),
				Integer.parseInt(tmpDTime[1])-1, Integer.parseInt(tmpDTime[2]),
				Integer.parseInt(tmpDTime[3]), Integer.parseInt(tmpDTime[4]))
		.getTime();
		Date arrivalTime=new GregorianCalendar(Integer.parseInt(tmpATime[0]),
				Integer.parseInt(tmpATime[1])-1, Integer.parseInt(tmpATime[2]),
				Integer.parseInt(tmpATime[3]), Integer.parseInt(tmpATime[4]))
		.getTime();
		//Μετατρέπει τον κωδικό πτήσης σε κεφαλαία
		//για διευκόλυνση του χρήστη
		flightCode=flightCode.toUpperCase();
		//Δημιουργείται ένα νέο instance της κλάσης Flight για την
		//αποθήκευση της πτήσης
		Flight newFlight=new Flight(flightCode, startingPoint, destination,
				departureTime, arrivalTime, ticketPrice, planeType, totalSeats,
				availableSeats);
		//Προσθήκη της πτήσης στην υπάρχουσα λίστα με
		//με τις διαθέσιμες πτήσεις
		flights.addTail(newFlight);
	}
	/**
	 * Παίρνει από τον χρήστη τον κωδικό πτήσης
	 * και διαγράφει τη συγκεκριμένη πτήση.
	 * @see FlightsBusiness#searchForFlightCode(String)
	 * @see DoublyLinkedList#removeNode(int)
	 */
	public void removeFlight(){
		System.out.println("Give flight code:");
		Scanner in=new Scanner(System.in);
		//Διαβάζει τον κωδικό πτήσης από τον χρήστη
		String flightCode=in.nextLine();
		//Μετατρέπει τον κωδικό πτήσης σε κεφαλαία
		//για την διευκόλυνση του χρήστη
		flightCode=flightCode.toUpperCase();
		//Ψάχνει στη λίστα με τις διαθέσιμες πτήσεις
		//σε ποια θέση είναι η πτήση με τον συγκεκριμένο
		//κωδικό πτήσης
		int index=searchForFlightCode(flightCode);
		//Διαγράφει την παραπάνω πτήση
		flights.removeNode(index);
	}
	/**
	 * Δημιουργία μιας νέας κράτησης. Μία κράτηση μπορεί να μπει
	 * σε κάποια λίστα επιβίβασης ή σε κάποια ουρά ανάμονης
	 * αναλόγως το κλειδί available.
	 * 
	 * @param bookingCode Ο μοναδικός κωδικός κράτησης.
	 * @param flightCode Ο κωδικός πτήσης.
	 * @param available Διαθεσιμότητα πτήσης. Αν είναι true η
	 * κράτηση γίνεται σε κάποια λίστα επιβίβασης. Αν είναι false,
	 * η κράτηση γίνεται σε κάποια ουρά αναμονής.
	 * @return 1 αν η κράτηση έγινε σε κάποια λίστα επιβίβαση και
	 * 0 αν η κράτηση έγινε σε κάποια ουρά αναμονής.
	 * @see FlightsBusiness#searchForFlightCode(String)
	 * @see DoublyLinkedList#getNodeValue(int)
	 * @see Flight#getAvailableSeats()
	 * @see Flight#getBoardedPass()
	 * @see Flight#setAvailableSeats(int)
	 * @see Flight#getWaitingPass()
	 * @see FifoQueue#enqueue(Object)
	 * @see SimplyLinkedList#addTail(Object)
	 */
	public int bookFlight(String bookingCode, String flightCode,
			boolean available){
		//Ψάχνει στη λίστα με τις διαθέσιμες πτήσεις
		//σε ποια θέση είναι η πτήση με τον συγκεκριμένο
		//κωδικό πτήσης
		int index=searchForFlightCode(flightCode);
		//Παίρνει από τη λίστα τον συγκεκριμένο κόμβο
		Flight flight=flights.getNodeValue(index);
		//Οι διαθέσιμες θέσεις της συγκεκριμένης πτήσης
		int availableSeats=flight.getAvailableSeats();
		if(available){
			//Αν το available είναι true
			//Από τη συγκεκριμένη πτήση, παίρνουμε τη λίστα
			//επιβίβασης και προσθέτουμε τον κωδικό της κράτησης
			flight.getBoardedPass().addTail(bookingCode);
			//Μειώνουμε κατά ένα τις διαθέσιμες θέσεις της
			//συγκεκριμένης πτήσης
			flight.setAvailableSeats(--availableSeats);
			return 1;
		}else{
			//Αν το available είναι false
			//Παίρνουμε την ουρά αναμονής της συγκεκριμένης
			//πτήσης και προσθέτουμε τον κωδικό της κράτησης
			flight.getWaitingPass().enqueue(bookingCode);
			return 0;
		}
	}
	/**
	 * Ελέγχει αν υπάρχουν διαθέσιμες θέσεις σε μία πτήση.
	 * 
	 * @param flightCode Ο κωδικός πτήσης.
	 * @return true αν υπάρχουν διαθέσιμες θέσεις, false
	 * αν δεν υπάρχουν.
	 * @see FlightsBusiness#searchForFlightCode(String)
	 * @see DoublyLinkedList#getNodeValue(int)
	 * @see Flight#getAvailableSeats()
	 */
	public boolean checkAvailability(String flightCode){
		//Ψάχνει στη λίστα με τις διαθέσιμες πτήσεις
		//σε ποια θέση είναι η πτήση με τον συγκεκριμένο
		//κωδικό πτήσης
		int index=searchForFlightCode(flightCode);
		//Παίρνει από τη λίστα τον συγκεκριμένο κόμβο
		Flight flight=flights.getNodeValue(index);
		//Παίρνει τις διαθέσιμες θέσεις της συγκεκριμένης πτήσης
		int availableSeats=flight.getAvailableSeats();
		boolean available;
		if(availableSeats>=1){
			//Αν οι διαθέσιμες θέσεις είναι
			//μεγαλύτερες από μηδέν
			available=true;
		}else{
			//Αν είναι ίσες με μηδέν
			//Προφανώς δεν γίνονται μικρότερες από μηδέν
			available=false;
		}
		
		return available;
	}
	/**
	 * Ελέγχει ότι οι κωδικοί που έδωσε ο χρήστης συμβαδίζουν.
	 * Αν ο χρήστης δώσει πάνω από ένα κωδικό πτήσης (πτήση με ενδιάμεση
	 * στάση) θα πρέπει η ώρα αναχώρισης της δεύτερης να είναι πιο μετά από
	 * την ώρα άφιξης της πρώτης και ο προορισμός της πρώτης να είναι ίδιος
	 * με το σημείο αναχώρισης της δεύτερης.
	 * 
	 * @param codeFlights Οι κωδικοί πτήσεων που έδωσε ο χρήστης.
	 * @return true αν οι διαδοχικές πτήσεις συμβαδίζουν, false αν όχι.
	 * @see FlightsBusiness#searchForFlightCode(String)
	 * @see DoublyLinkedList#getNodeValue(int)
	 * @see Flight#getArrivalTime()
	 * @see Flight#getDestination()
	 * @see Flight#getDepartureTime()
	 * @see Flight#getStartingPoint()
	 */
	public boolean validateFlights(String[] codeFlights){
		boolean valid=true;
		if(codeFlights.length==1){
			//Αν δώσει μόνο ένα κωδικό τότε προφανώς είναι σωστός
			valid=true;
		}else{
			for(int i=0;i<codeFlights.length-1;i++){
				//Για κάθε μία πτήση
				//Βρίσκει σε ποια θέση στη λίστα με τις
				//διαθέσιμες πτήσεις ανήκει, καθώς και η
				//επόμενή της
				int fIndex=searchForFlightCode(codeFlights[i]);
				int nIndex=searchForFlightCode(codeFlights[i+1]);
				//Παίρνει τους κόμβους από τη λίστα
				Flight fFlight=flights.getNodeValue(fIndex);
				Flight nFlight=flights.getNodeValue(nIndex);
				//Ημ/νια άφιξης της πρώτης
				Date fArrTime=fFlight.getArrivalTime();
				//Προορισμός της πρώτης
				String fDest=fFlight.getDestination();
				//Ημ/νια αναχώρισης της δεύτερης
				Date nDepTime=nFlight.getDepartureTime();
				//Σημείο αναχώρισης της δεύτερης
				String nStart=nFlight.getStartingPoint();
				//Οι ημερομηνίες είναι σε millisecond από EPOCH
				long timeDiff=nDepTime.getTime()-fArrTime.getTime();
				if((timeDiff>0) && (fDest.equals(nStart))){
					//Αν ημ. αναχώρισης της δεύτερης είναι
					//μεγαλύτερη της ημ. άφιξης της δεύτερης
					//και προορισμός της πρώτης είναι ίδιος
					//με σημείο αναχώρισης της δεύτερης
					valid=true;
				}else{
					valid=false;
				}
			}
		}
		return valid;
	}
	/**
	 * Διαγράφει μία κράτηση από την ουρά αναμονής μιας πτήσης.
	 * 
	 * @param bookingID Το αναγνωριστικό της κράτησης.
	 * @param flightCode Ο κωδικός πτήσης.
	 * @see FlightsBusiness#searchForFlightCode(String)
	 * @see DoublyLinkedList#getNodeValue(int)
	 * @see Flight#getWaitingPass()
	 * @see FifoQueue#getLength()
	 * @see FifoQueue#removeNode(int)
	 * @see Flight#setWaitingPass(FifoQueue)
	 */
	public void delPendingCode(String bookingID, String flightCode){
		//Ψάχνει στη λίστα με τις διαθέσιμες πτήσεις
		//σε ποια θέση είναι η πτήση με τον συγκεκριμένο
		//κωδικό πτήσης
		int index=searchForFlightCode(flightCode);
		//Παίρνει από τη λίστα τον συγκεκριμένο κόμβο
		Flight curFlight=flights.getNodeValue(index);
		//Παίρνει την ουρά αναμονής της συγκεκριμένης πτήσης
		FifoQueue<String> waitingQueue=curFlight.getWaitingPass();
		int queueLength=waitingQueue.getLength();
		for(int i=0;i<queueLength;i++){
			//Για κάθε ένα αναγνωριστικό στην ουρά,
			//αν είναι ίσο με αυτό που έδωσε ο χρήστης,
			//το διαγράφει από την ουρά
			if(waitingQueue.getNodeValue(i).equals(bookingID)){
				waitingQueue.removeNode(i);
			}
		}
		//Ορίζει την νέα ουρά αναμονής για την συγκεκριμένη πτήση
		curFlight.setWaitingPass(waitingQueue);
	}
	/**
	 * Διαγράφει τον χρήστη από τις λίστες επιβίβασης των κωδικών
	 * πτήσεων που έχει δώσει. Στη συνέχεια φτιάχνει μία λίστα με
	 * τους κωδικούς κρατήσεων που είναι στην ουρά αναμονής της πρώτης
	 * πτήσης του επιβάτη που διαγράφηκε.
	 * 
	 * @param bookingID Το αναγνωριστικό του επιβάτη-κράτησης.
	 * @param bookedFlights Οι κωδικοί πτήσεων που αντιστοιχούν
	 * στις κατοχυρομένες πτήσεις του επιβάτη.
	 * @return Μία λίστα με τα αναγνωριστικά των κρατήσεων που βρίσκονται
	 * στην ουρά αναμονής της πρώτης πτήσης του χρήστη.
	 * @see FlightsBusiness#searchForFlightCode(String)
	 * @see DoublyLinkedList#getNodeValue(int)
	 * @see Flight#getBoardedPass()
	 * @see SimplyLinkedList#getNodeValue(int)
	 * @see SimplyLinkedList#removeNode(int)
	 * @see Flight#getAvailableSeats()
	 * @see Flight#setAvailableSeats(int)
	 * @see Flight#getWaitingPass()
	 * @see SimplyLinkedList#SimplyLinkedList()
	 * @see FifoQueue#getNodeValue(int)
	 * @see SimplyLinkedList#addTail(Object)
	 */
	public SimplyLinkedList<String> delBoardedCodePre(String bookingID,
			SimplyLinkedList<String> bookedFlights){
		for(int i=0;i<bookedFlights.getLength();i++){
			//Για κάθε ένα κωδικό πτήσης
			//Ψάχνει στη λίστα με τις διαθέσιμες πτήσεις
			//σε ποια θέση είναι η πτήση με τον συγκεκριμένο
			//κωδικό πτήσης
			int index=searchForFlightCode(bookedFlights.getNodeValue(i));
			//Παίρνει από τη λίστα τον συγκεκριμένο κόμβο
			Flight curFlight=flights.getNodeValue(index);
			//Παίρνουμε τη λίστα επιβίβασης της συγκεκριμένης πτήσης
			SimplyLinkedList<String> boardingList=curFlight.getBoardedPass();
			for(int j=0;j<boardingList.getLength();j++){
				//Για κάθε ένα κωδικό κράτησης
				//Αν είναι ίδιος με τον κωδικό κράτησης
				//του χρήστη
				if(boardingList.getNodeValue(j).equals(bookingID)){
					//Τον διαγράφουμε από τη λίστα
					boardingList.removeNode(j);
					//Παίρνουμε τις διαθέσιμες θέσεις της συγκεκριμένης πτήσης
					int availableSeats=curFlight.getAvailableSeats();
					//Αυξάνουμε κατά ένα ορίζουμε τις νέες διαθέσιμες θέσεις
					availableSeats++;
					curFlight.setAvailableSeats(availableSeats);
					break;
				}
			}
		}
		//Ψάχνει στη λίστα με τις διαθέσιμες πτήσεις
		//σε ποια θέση είναι η πρώτη πτήση από τη λίστα
		//με τις κατοχυρομένες πτήσεις του επιβάτη προς διαγραφή
		int index=searchForFlightCode(bookedFlights.getNodeValue(0));
		//Παίρνει από τη λίστα το συγκεκριμένο κόμβο
		Flight curFlight=flights.getNodeValue(index);
		//Παίρνει την ουρά αναμονής της συγκεκριμένης πτήσης
		FifoQueue<String> waitingQueue=curFlight.getWaitingPass();
		//Δημιουργεί μία νέα μονά συνδεδεμένη λίστα και
		//αποθηκεύει τα δεδομένα της waitingQueue σε αυτή
		SimplyLinkedList<String> queueCodes=new SimplyLinkedList<String>();
		if(waitingQueue.getLength()>0){
			for(int i=0;i<waitingQueue.getLength();i++){
				queueCodes.addTail(waitingQueue.getNodeValue(i));
			}
		}
		
		return queueCodes;
	}
	/**
	 * Βρίσκει έναν επιβάτη από μια λίστα του οποίου όλες οι πτήσεις
	 * έχουν διαθέσιμες θέσεις, αν υπάρχει και κάνει νέα κράτηση σε 
	 * κάθε μία από αυτές αφού τον διαγράψει από τις λίστες αναμονής που ήταν.
	 * 
	 * @param queuePassengers Λίστα με επιβάτες από την μέθοδο 
	 * delBoardedCodePre
	 * @return Τον κωδικό κράτησης του επιβάτη που έχει διαθέσιμες θέσεις
	 * σε όλες τις πτήσεις του από την παραπάνω λίστα αν υπάρχει, αλλιώς null
	 * @see SimplyLinkedList#getNodeValue(int)
	 * @see Passenger#getBookedFlights()
	 * @see FlightsBusiness#searchForFlightCode(String)
	 * @see DoublyLinkedList#getNodeValue(int)
	 * @see Flight#getAvailableSeats()
	 * @see SimplyLinkedList#getLength()
	 * @see Passenger#getUid()
	 * @see Flight#getWaitingPass()
	 * @see FifoQueue#getNodeValue(int)
	 * @see FifoQueue#removeNode(int)
	 * @see FlightsBusiness#bookFlight(String, String, boolean)
	 */
	public String delBoardedCodePost(SimplyLinkedList<Passenger> 
	queuePassengers){
		int availableSeats;
		//Μετρητής που μετράει σε πόσες από τις πτήσεις
		//του εκάστοτε χρήστη υπάρχουν διαθέσιμες θέσεις
		int availableFlag=0;
		//Κωδικός κράτησης του επιβάτη που από την ουρά αναμονής
		//των πτήσεών του θα πάει στις λίστες επιβίβασης των 
		//αντίστοιχων πτήσεων
		String luckyBookingCode=null;
		for(int i=0;i<queuePassengers.getLength();i++){
			//Για κάθε χρήστη στη λίστα queuePassengers
			//Παίρνει τη λίστα με τους κωδικούς πτήσεων
			//που έχει κάνει κράτηση
			SimplyLinkedList<String> passBookedFlights=queuePassengers
			.getNodeValue(i).getBookedFlights();
			for(int j=0;j<passBookedFlights.getLength();j++){
				//Για κάθε μία από τις παραπάνω πτήσεις
				//Ψάχνει στη λίστα με τις διαθέσιμες πτήσεις
				//σε ποια θέση είναι η πτήση με τον συγκεκριμένο
				//κωδικό πτήσης
				int index=searchForFlightCode(passBookedFlights
						.getNodeValue(j));
				//Παίρνει από τη λίστα το συγκεκριμένο κόμβο
				Flight curFlight=flights.getNodeValue(index);
				//Παίρνει τις διαθέσιμες θέσεις της συγκεκριμένης πτήσης
				availableSeats=curFlight.getAvailableSeats();
				if(availableSeats>0)
					//Αν υπάρχουν διαθέσιμες θέσεις
					//αυξάνει το μετρητή κατά ένα
					availableFlag++;
			}
			if(availableFlag==passBookedFlights.getLength()){
				//Αν ο μετρητής availableFlag είναι ίσος με
				//το πλήθος των πτήσεων που έχει κάνει κράτηση
				//ο συγκεκριμένος χρήστης.
				//Αυτό σημαίνει ότι σε όλες τις πτήσεις υπάρχουν
				//διαθέσιμες θέσεις, άρα μπορεί να μεταβεί στις
				//λίστες επιβίβασης των πτήσεών του.
				//Παίρνουμε τον κωδικό κράτησης αυτού του επιβάτη
				luckyBookingCode=queuePassengers.getNodeValue(i).getUid();

				for(int j=0;j<passBookedFlights.getLength();j++){
					//Για κάθε μία pending κράτηση του επιβάτη
					//Παίρνει το κωδικό πτήσης
					String flightCode=passBookedFlights.getNodeValue(j);
					//Για κάθε μία από τις παραπάνω πτήσεις
					//Ψάχνει στη λίστα με τις διαθέσιμες πτήσεις
					//σε ποια θέση είναι η πτήση με τον συγκεκριμένο
					//κωδικό πτήσης
					int index=searchForFlightCode(flightCode);
					//Παίρνει από τη λίστα το συγκεκριμένο κόμβο
					Flight curFlight=flights.getNodeValue(index);
					//Παίρνει την ουρά αναμονής της πτήσης
					FifoQueue<String> pendingList=curFlight.getWaitingPass();
					for(int k=0;k<pendingList.getLength();k++){
						//Για κάθε καταχώρηση στην ουρά αυτή
						if(pendingList.getNodeValue(k).equals(luckyBookingCode))
							//Αν το αναγνωριστικό κράτησης είναι ίδιο
							//με το αναγνωριστικό του συγκεκριμένου επιβάτη
							//το αφαιρεί από την ουρά
							pendingList.removeNode(k);
					}
					//Κάνει νέα κράτηση στην πτήση με τον κωδικό κράτησης
					//του επιβάτη και με το flag available να είναι true
					//δηλαδή ότι πρόκειτε για κράτηση στη λίστα επιβίβασης
					bookFlight(luckyBookingCode, flightCode, true);
				}
				break;
			}
		}
		
		return luckyBookingCode;
	}
	/**
	 * Ψάχνει στη λίστα με τις διαθέσιμες πτήσεις για την πτήση με 
	 * συγκεκριμένο κωδικό πτήσης και επιστρέφει τη θέση της στη λίστα.
	 * 
	 * @param flightCode Ο κωδικός πτήσης που μας ενδιαφέρει.
	 * @return Τη θέση της πτήσης που μας ενδιαφέρει από τη λίστα
	 * με τις διαθέσιμες πτήσεις. Αν δεν βρεθεί επιστρέφει -1.
	 * @see DoublyLinkedList#getLength()
	 * @see DoublyLinkedList#getNodeValue(int)
	 * @see Flight#getFlightCode()
	 */
	public int searchForFlightCode(String flightCode){
		Flight searchFlight;
		int index;
		boolean found=false;
		int listLength=flights.getLength();
		
		for(index=1;index<=listLength;index++){
			//Για κάθε ένα κόμβο στη λίστα
			//Παίρνει την τιμή του κόμβου
			searchFlight=flights.getNodeValue(index);
			if(searchFlight.getFlightCode().equals(flightCode)){
				//Αν ο κωδικός πτήσης είναι ίδιος με τον
				//κωδικό πτήσης που μας ενδιαφέρει
				found=true;
				break;
			}
		}
		if(found==false)
			//Αν δεν βρεθεί επιστρέφει -1
			index=-1;
		
		return index;
	}
}
