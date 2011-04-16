package booking;

import java.math.BigInteger;
import java.util.Date;
import java.util.GregorianCalendar;

import structures.SimplyLinkedList;

public class Passenger {
	private String surname;
	private String name;
	private String idNumber;
	private String nationality;
	private String address;
	private BigInteger phone;
	private SimplyLinkedList<String> bookedFlightsList;
	
	public Passenger(String surname, String name, String idNumber, String nationality,
			String address, BigInteger phone){
		this.surname=surname;
		this.name=name;
		this.idNumber=idNumber;
		this.nationality=nationality;
		this.address=address;
		this.phone=phone;
		bookedFlightsList=new SimplyLinkedList<String>();
	}
	
	public String getSurname(){
		return surname;
	}
	public String getName(){
		return name;
	}
	public String getIdNumber(){
		return idNumber;
	}
	public String getNationality(){
		return nationality;
	}
	public String getAddress(){
		return address;
	}
	public BigInteger getPhone(){
		return phone;
	}
	public SimplyLinkedList<String> getBookedFlightsList(){
		return bookedFlightsList;
	}
	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append("Surname: ").append(surname).append("\n");
		sb.append("Name: ").append(name).append("\n");
		sb.append("ID Number: ").append(idNumber).append("\n");
		sb.append("Nationality: ").append(nationality).append("\n");
		sb.append("Address: ").append(address).append("\n");
		sb.append("Phone: ").append(phone).append("\n");
		sb.append("Booked Flights: ").append(bookedFlightsList).append("\n");
		
		return sb.toString();
	}
	//Test. TO BE DELETED
	public static void main(String[] args){
		Passenger antonis=new Passenger("Kouzoupis", "Antonis", "X51857", "Greek", "Idis 19, Ilioupoli, Athens, Greece", new BigInteger("6944916938"));
		SimplyLinkedList<String> aList=antonis.getBookedFlightsList();
		aList.addTail("EZY8567");
		aList.addTail("ESU8797");
		
		System.out.println(antonis);
	}
}
