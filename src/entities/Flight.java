package entities;

import java.util.Date;
import structures.FifoQueue;
import structures.SimplyLinkedList;

/**
 * Κλάση που κρατάει πληροφορίες για τις διαθέσιμες πτήσεις.
 * Κάθε instance αυτής της κλάσης αποθηκεύεται σε μία
 * διπλά συνδεδεμένη λίστα.
 */
public class Flight {
	private String flightCode;
	private String startingPoint;
	private String destination;
	private Date departureTime;
	private Date arrivalTime;
	private double ticketPrice;
	private String planeType;
	private int totalSeats;
	private int availableSeats;
	//Μονά συνδεδεμένη λίστα με όλους τους κωδικούς
	//κράτησης της εκάστοτε πτήσης
	private SimplyLinkedList<String> boardedPass;
	//Ουρά αναμονής με τους κωδικούς κράτησης, των
	//επιβατών που δεν βρίκαν ελεύθερη θέση στην πτήση
	//και προστέθηκαν στη λίστα αναμονής
	private FifoQueue<String> waitingPass;
	
	/**
	 * Constructor για την δημιουργία ενός νέου instance μιας πτήσης.
	 * 
	 * @param flightCode Ο κωδικός πτήσης.
	 * @param startingPoint Η αφαιτηρία.
	 * @param destination Ο προορισμός.
	 * @param departureTime Ημερομηνία αναχώρησης.
	 * @param arrivalTime Ημερομηνία άφιξης.
	 * @param ticketPrice Τιμή εισιτηρίου.
	 * @param planeType Τύπος αεροπλάνου.
	 * @param totalSeats Συνολικές θέσεις αεροπλάνου.
	 * @param availableSeats Διαθέσιμες θέσεις αεροπλάνου.
	 */
	public Flight(String flightCode, String startingPoint, String destination, Date departureTime,
			Date arrivalTime, double ticketPrice, String planeType, int totalSeats, int availableSeats){
		this.flightCode=flightCode;
		this.startingPoint=startingPoint;
		this.destination=destination;
		this.departureTime=departureTime;
		this.arrivalTime=arrivalTime;
		this.ticketPrice=ticketPrice;
		this.planeType=planeType;
		this.totalSeats=totalSeats;
		this.availableSeats=availableSeats;
		//Δημιουργία της λίστας με τους επιβάτες
		boardedPass=new SimplyLinkedList<String>();
		//Δημιουργία της ουράς αναμονής με τους επιβάτες που αναμένουν
		waitingPass=new FifoQueue<String>();
	}
	
	/**
	 * Παίρνουμε τον κωδικό πτήσης.
	 * 
	 * @return Τον κωδικό πτήσης.
	 */
	public String getFlightCode(){
		return flightCode;
	}
	/**
	 * Παίρνουμε την αφετηρία της πτήσης.
	 * 
	 * @return Την αφετηρία της πτήσης.
	 */
	public String getStartingPoint(){
		return startingPoint;
	}
	/**
	 * Παίρνουμε τον προορισμό της πτήσης.
	 * 
	 * @return Τον προορισμό της πτήσης.
	 */
	public String getDestination(){
		return destination;
	}
	/**
	 * Παίρνουμε την ημερομηνία αναχώρισης της πτήσης.
	 * 
	 * @return Την ημερομηνία αναχώρισης της πτήσης.
	 */
	public Date getDepartureTime(){
		return departureTime;
	}
	/**
	 * Παίρνουμε την ημερομηνία άφιξης της πτήσης.
	 * 
	 * @return Την ημερομηνία άφιξης της πτήσης.
	 */
	public Date getArrivalTime(){
		return arrivalTime;
	}
	/**
	 * Παίρνουμε την τιμή του εισιτηρίου της πτήσης.
	 * 
	 * @return Την τιμή του εισιτηρίου της πτήσης.
	 */
	public double getTicketprice(){
		return ticketPrice;
	}
	/**
	 * Παίρνουμε τον τύπο του αεροπλάνου.
	 * 
	 * @return Τον τύπο του αεροπλάνου.
	 */
	public String getPlaneType(){
		return planeType;
	}
	/**
	 * Παίρνουμε τον αριθμό των συνολικών θέσεων στο αεροπλάνο.
	 * 
	 * @return Τον αριθμό των συνολικών θέσεων στο αεροπλάνο.
	 */
	public int getTotalSeats(){
		return totalSeats;
	}
	/**
	 * Παίρνουμε τις διαθέσιμες θέσεις στο αεροπλάνο.
	 * 
	 * @return Τις διαθέσιμες θέσεις στο αεροπλάνο. 
	 */
	public int getAvailableSeats(){
		return availableSeats;
	}
	/**
	 * Πέρνουμε τη λίστα με τους επιβάτες προς επιβίβαση.
	 * 
	 * @return Τη λίστα με τους επιβάτες προς επιβίβαση.
	 */
	public SimplyLinkedList<String> getBoardedPass(){
		return boardedPass;
	}
	/**
	 * Παίρνουμε την ουρά αναμονής με τους επιβάτες σε αναμονή.
	 * 
	 * @return Την ουρά αναμονής με τους επιβάτες σε αναμονή.
	 */
	public FifoQueue<String> getWaitingPass(){
		return waitingPass;
	}
	/**
	 * Προσθέτουμε στη λίστα επιβίβασης ένα νέο επιβάτη.
	 * 
	 * @param bookingCode Ο μοναδικός κωδικός επιβάτη-κράτησης.
	 */
	public void setBoardedPass(String bookingCode){
		boardedPass.addTail(bookingCode);
	}
	/**
	 * Προσθέτουμε στην ουρά αναμονής ένα νέο επιβάτη.
	 * 
	 * @param bookingCode Ο μοναδικός κωδικός επιβάτη-κράτησης.
	 */
	public void setWaitingPass(String bookingCode){
		waitingPass.enqueue(bookingCode);
	}
	/**
	 * Ορίζουμε την ουρά αναμονής.
	 * 
	 * @param waitingPass Η ουρά αναμονής.
	 */
	public void setWaitingPass(FifoQueue<String> waitingPass){
		this.waitingPass=waitingPass;
	}
	/**
	 * Ορίζουμε τις διαθέσιμες θέσεις του αεροπλάνου.
	 * 
	 * @param availableSeats Οι διαθέσιμες θέσεις του αεροπλάνου.
	 */
	public void setAvailableSeats(int availableSeats){
		this.availableSeats=availableSeats;
	}
	/**
	 * Επιστρέφει όλες τις λεπτομέρειες μιας πτήσης.
	 * 
	 * @return Τις λεπτομέρειες μιας πτήσης.
	 */
	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append("\n");
		sb.append("--------------------").append("\n");
		sb.append("Flight Code: ").append(flightCode).append("\n");
		sb.append("Starting Point: ").append(startingPoint).append("\n");
		sb.append("Destination: ").append(destination).append("\n");
		sb.append("Departure Time: ").append(departureTime).append("\n");
		sb.append("Arrival Time: ").append(arrivalTime).append("\n");
		sb.append("Ticket Price: ").append(ticketPrice).append("\n");
		sb.append("Plane Type: ").append(planeType).append("\n");
		sb.append("Total Seats: ").append(totalSeats).append("\n");
		sb.append("Available Seats: ").append(availableSeats);
		//Αν η ουρά αναμονής έχει κόμβους,
		//δηλαδή αν υπάρχουν επιβάτες σε αναμονή.
		if(waitingPass.getLength()>0){
			sb.append("\n");
			sb.append("Pending Seats: ").append(waitingPass.getLength()).append("\n");
		}
		
		return sb.toString();
	}
}
