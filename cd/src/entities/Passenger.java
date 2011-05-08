package entities;

import java.math.BigInteger;
import structures.SimplyLinkedList;

/**
 * Κλάση που κρατάει πληροφορίες για του επιβάτες-κρατήσεις.
 * Κάθε instance αυτής της κλάσης αποθηκεύεται σε μία διπλά
 * συνδεδεμένη λίστα.
 */
public class Passenger {
	private String surname;
	private String name;
	private String idNumber;
	private String nationality;
	private String address;
	private BigInteger phone;
	private String uid;
	//true αν ο επιβάτης είναι σε λίστα επιβίβασης,
	//false αν ο επιβάτης είναι σε ουρά αναμονής
	private boolean status;
	//Λίστα με τους κωδικούς πτήσεων που έχει κάνει κράτηση ο επιβάτης
	private SimplyLinkedList<String> bookedFlightsList;
	
	/**
	 * Constructor για τη δημιουργία ενός νέου instance επιβάτη-κράτησης.
	 * 
	 * @param surname Το επίθετο του επιβάτη.
	 * @param name Το όνομα του επιβάτη.
	 * @param idNumber Ο αριθμός ταυτότητας του επιβάτη.
	 * @param nationality Η εθνικότητα του επιβάτη.
	 * @param address Η διεύθυνση του επιβάτη. 
	 * @param phone Το τηλέφωνο του επιβάτη.
	 * @param uid Το μοναδικό αναγνωριστικό της κράτησης.
	 */
	public Passenger(String surname, String name, String idNumber,
			String nationality, String address, BigInteger phone, String uid){
		this.surname=surname;
		this.name=name;
		this.idNumber=idNumber;
		this.nationality=nationality;
		this.address=address;
		this.phone=phone;
		this.uid=uid;
		//Δημιουργία της λίστας με τους κωδικούς πτήσης που έχει κάνει
		//κράτηση ο επιβάτης
		bookedFlightsList=new SimplyLinkedList<String>();
	}
	/**
	 * Παίρνουμε το επίθετο του επιβάτη.
	 * 
	 * @return Το επίθετο του επιβάτη.
	 */
	public String getSurname(){
		return surname;
	}
	/**
	 * Παίρνουμε το όνομα του επιβάτη.
	 * 
	 * @return Το όνομα του επιβάτη.
	 */
	public String getName(){
		return name;
	}
	/**
	 * Παίρνουμε τον αριθμό ταυτότητας του επιβάτη.
	 * 
	 * @return Τον αριθμό ταυτότητας του επιβάτη.
	 */
	public String getIdNumber(){
		return idNumber;
	}
	/**
	 * Παίρνουμε την εθνικότητα του χρήστη.
	 * 
	 * @return Την εθνικότητα του χρήστης.
	 */
	public String getNationality(){
		return nationality;
	}
	/**
	 * Παίρνουμε τη διεύθυνση του χρήστη.
	 * 
	 * @return Τη διεύθυνση του χρήστη.
	 */
	public String getAddress(){
		return address;
	}
	/**
	 * Παίρνουμε το τηλέφωνο του χρήστη.
	 * 
	 * @return Το τηλέφωνο του χρήστη.
	 */
	public BigInteger getPhone(){
		return phone;
	}
	/**
	 * Παίρνουμε το μοναδικό αναγνωριστικό της κράτησης.
	 * 
	 * @return Το μοναδικό αναγνωριστικό της κράτησης.
	 */
	public String getUid(){
		return uid;
	}
	/**
	 * Παίρνουμε την κατάσταση κράτησης του επιβάτη.
	 * 
	 * @return Την κατάσταση κράτησης του επιβάτη.
	 */
	public boolean getStatus(){
		return status;
	}
	/**
	 * Παίρνουμε τη λίστα με τους κωδικούς πτήσεων που έχει κάνει
	 * κράτηση ο επιβάτης.
	 * 
	 * @return Τη λίστα με τους κωδικούς πτήσεων που έχει κάνει
	 * κράτηση ο επιβάτης.
	 */
	public SimplyLinkedList<String> getBookedFlights(){
		return bookedFlightsList;
	}
	/**
	 * Προσθέτουμε ένα νέο κωδικό πτήσης στην υπάρχουσα λίστα κράτησης.
	 * 
	 * @param flightCode Ο κωδικός πτήσης.
	 */
	public void setBookedFlights(String flightCode){
		bookedFlightsList.addTail(flightCode);
	}
	/**
	 * Ορίζουμε την κατάσταση κράτησης του επιβάτη.
	 * 
	 * @param status Η κατάσταση κράτησης του επιβάτη.
	 */
	public void setStatus(boolean status){
		this.status=status;
	}
	/**
	 * Επιστρέφει όλες τις λεπτομέρειες ενός επιβάτη-κράτησης.
	 * 
	 * @return Τις λεπτομέρειες ενός επιβάτη-κράτησης.
	 */
	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append("\n");
		sb.append("Surname: ").append(surname).append("\n");
		sb.append("Name: ").append(name).append("\n");
		sb.append("ID Number: ").append(idNumber).append("\n");
		sb.append("Nationality: ").append(nationality).append("\n");
		sb.append("Address: ").append(address).append("\n");
		sb.append("Phone: ").append(phone).append("\n");
		sb.append("uid: ").append(uid).append("\n");
		sb.append("Booked Flights: ").append(bookedFlightsList).append("\n");
		sb.append("Status: ");
		if(status){
			sb.append("Boarded");
		}else{
			sb.append("Pending");
		}
		sb.append("\n");
		
		return sb.toString();
	}
}
