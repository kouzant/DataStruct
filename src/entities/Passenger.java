package entities;

import java.math.BigInteger;
import structures.SimplyLinkedList;

public class Passenger {
	private String surname;
	private String name;
	private String idNumber;
	private String nationality;
	private String address;
	private BigInteger phone;
	private String uid;
	private boolean status;
	private SimplyLinkedList<String> bookedFlightsList;
	
	public Passenger(String surname, String name, String idNumber, String nationality,
			String address, BigInteger phone, String uid){
		this.surname=surname;
		this.name=name;
		this.idNumber=idNumber;
		this.nationality=nationality;
		this.address=address;
		this.phone=phone;
		this.uid=uid;
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
	public String getUid(){
		return uid;
	}
	public SimplyLinkedList<String> getBookedFlights(){
		return bookedFlightsList;
	}
	public void setBookedFlights(String flightCode){
		bookedFlightsList.addTail(flightCode);
	}
	public void setStatus(boolean status){
		this.status=status;
	}
	@Override
	//Print a passenger's details
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
