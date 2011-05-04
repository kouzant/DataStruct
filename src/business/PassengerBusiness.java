package business;

import java.math.BigInteger;
import java.util.Scanner;

import entities.Passenger;
import structures.DoublyLinkedList;

/**
 * Κλάση για τη διαχείριση των επιβατών και ότι
 * έχει σχέση με αυτούς.
 */
public class PassengerBusiness {
	private DoublyLinkedList<Passenger> passengers;
	private String surname;
	private String name;
	private String idNumber;
	private String nationality;
	private String address;
	private BigInteger phone;
	
	/**
	 * Ορίζει τη λίστα με τους επιβάτες για την κλάση αυτή.
	 * 
	 * @param passengers Η κλάση με τους επιβάτες.
	 */
	public void setPassengersList(DoublyLinkedList<Passenger> passengers){
		this.passengers=passengers;
	}
	/**
	 * Τυπώνει όλους τους καταχωρημένους επιβάτες στην εφαρμογή.
	 * 
	 * @see Passenger#toString()
	 * @see DoublyLinkedList#toString()
	 */
	public void listPassengers(){
		//Χρησιμοποιεί τις μεθόδους toString για να
		//τυπώσει όλους τους επιβάτες
		System.out.println(passengers);
	}
	/**
	 * Παίρνει όλα τα απαραίτητα στοιχεία από τον
	 * χρήστη για τη δημιουργία μιας νέας κράτησης.
	 * 
	 * @return Τους κωδικούς πτήσεων που έδωσε ο χρήστης.
	 */
	public String[] askAddPassenger(){
		Scanner in=new Scanner(System.in);
		System.out.println("Surname:");
		String surname=in.nextLine();
		this.surname=surname;
		System.out.println("Name:");
		String name=in.nextLine();
		this.name=name;
		System.out.println("ID Number:");
		String idNumber=in.nextLine();
		this.idNumber=idNumber;
		System.out.println("Nationality:");
		String nationality=in.nextLine();
		this.nationality=nationality;
		System.out.println("Address:");
		String address=in.nextLine();
		this.address=address;
		System.out.println("Flight code (comma separated):");
		String codeFlight=in.nextLine();
		System.out.println("Phone number:");
		BigInteger phone=in.nextBigInteger();
		this.phone=phone;
		//Μετατρέπει τους κωδικούς πτήσεων σε κεφαλαία για
		//διευκόλυνση του χρήστη
		codeFlight=codeFlight.toUpperCase();
		//Χωρίζει τους κωδικούς πτήσεων με διαχωριστικό το ','
		String[] codeFlights=codeFlight.split("[,]");
		
		return codeFlights;
	}
	/**
	 * Προσθέτει ένα νέο επιβάτη-κράτηση στη λίστα με
	 * τους επιβάτες.
	 * 
	 * @param codeFlights Οι κωδικοί πτήσεων που έδωσε ο επιβάτης.
	 * @return Το μοναδικό αναγνωριστικό της κράτησης.
	 * @see Utilities#Utilities()
	 * @see Utilities#MD5(String)
	 * @see Passenger#Passenger(String, String, String, String, String,
	 *  BigInteger, String)
	 * @see Passenger#setBookedFlights(String)
	 * @see DoublyLinkedList#addTail(Object)
	 */
	public String addPassenger(String[] codeFlights){
		String uid;
		String stringUid="";
		Utilities util=new Utilities();
		for(int i=0;i<codeFlights.length;i++)
			//Για κάθε κωδικό πτήσης
			//Φτιάχνει ένα String με όλους τους κωδικούς πτήσεων
			stringUid=stringUid.concat(codeFlights[i]);
		//Στο παραπάνω String προσθέτει τον αριθμό
		//ταυτότητας του χρήστη
		stringUid=stringUid.concat(idNumber);
		//Χρησιμοποιώντας τη συνάρτηση κατακερματισμού
		//md5 στο παραπάνω String, παράγεται το αναγνωριστικό
		//της κράτησης
		uid=util.MD5(stringUid);
		//Από το παραπάνω αναγνωριστικό τελικά χρησιμοποιούμε
		//μόνο τα πέντε πρώτα ψηφία
		uid=uid.substring(0, 5);
		//Δημιουργείται ένα νέο instance της κλάσης Passenger για την
		//αποθήκευση του νέο επιβάτη
		Passenger newPassenger=new Passenger(surname,name,idNumber,nationality,
				address,phone,uid);
		//Προσθέτει κάθε κωδικό πτήσης που έδωσε ο χρήστης στη λίστα
		//με τους κωδικούς πτήσεων που έχει κάνει κράτηση
		for(int i=0;i<codeFlights.length;i++){
			newPassenger.setBookedFlights(codeFlights[i]);
		}
		//Προσθέτει στη λίστα με τους επιβάτες το νέο επιβάτη
		passengers.addTail(newPassenger);

		return uid;
	}
	/**
	 * Παίρνει από τον χρήστη το μοναδικό αναγνωριστικό
	 * κράτησης προς διαγραφή.
	 * 
	 * @return Τον κωδικό κράτησης που έδωσε ο χρήστης.
	 */
	public String askRemovePassenger(){
		System.out.println("Give your booking code:");
		Scanner in=new Scanner(System.in);
		String bookingCode=in.nextLine();
		
		return bookingCode;
	}
	
	/**
	 * Διαγράφει έναν επιβάτη από τη λίστα με τους επιβάτες.
	 * 
	 * @param bookingCode Το αναγνωριστικό κράτησης προς διαγραφή.
	 * @see PassengerBusiness#searchForCode(String)
	 * @see DoublyLinkedList#removeNode(int)
	 */
	public void removePassenger(String bookingCode){
		//Ψάχνει στη λίστα με τους επιβάτες
		//τον επιβάτη με το συγκεκριμένο
		//κωδικό κράτησης
		int index=searchForCode(bookingCode);
		passengers.removeNode(index);
	}
	
	/**
	 * Ψάχνει στη λίστα με τους επιβάτες για τον επιβάτη με το
	 * συγκεκριμένο κωδικό κράτησης και επιστρέφει τη θέση του
	 * στη λίστα.
	 * 
	 * @param bookingCode Ο κωδικός κράτησης που μας ενδιαφέρει.
	 * @return Τη θέση του στη λίστα με τους επιβάτες. Αν δεν βρεθεί
	 * επιστρέφει -1
	 * @see DoublyLinkedList#getLength()
	 * @see DoublyLinkedList#getNodeValue(int)
	 * @see Passenger#getUid()
	 */
	public int searchForCode(String bookingCode){
		Passenger searchPassenger;
		int index;
		boolean found=false;
		int listLength=passengers.getLength();
		
		for(index=1;index<=listLength;index++){
			//Για κάθε έναν επιβάτη
			//Παίρνει την τιμή του κόμβου
			searchPassenger=passengers.getNodeValue(index);
			if(searchPassenger.getUid().equals(bookingCode)){
				//Αν ο κωδικός κράτησης είναι ίδιος με τον
				//κωδικό κράτησης που μας ενδιαφέρει
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
