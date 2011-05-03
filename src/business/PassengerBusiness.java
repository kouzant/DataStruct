package business;

import java.math.BigInteger;
import java.util.Scanner;

import entities.Passenger;
import structures.DoublyLinkedList;

public class PassengerBusiness {
	private DoublyLinkedList<Passenger> passengers;
	private String surname;
	private String name;
	private String idNumber;
	private String nationality;
	private String address;
	private BigInteger phone;
	
	public void setPassengersList(DoublyLinkedList<Passenger> passengers){
		this.passengers=passengers;
	}
	//Print all the passengers
	public void listPassengers(){
		System.out.println(passengers);
	}
	//Ask the passenger for details
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
		//Convert flightcode to uppercase
		codeFlight=codeFlight.toUpperCase();
		//Split multiple flight codes
		String[] codeFlights=codeFlight.split("[,]");
		
		return codeFlights;
	}
	//Add new passenger to passengers list
	public String addPassenger(String[] codeFlights){
		String uid;
		String stringUid=null;
		Utilities util=new Utilities();
		for(int i=0;i<codeFlights.length;i++)
			stringUid=idNumber.concat(codeFlights[i]);
		//Unique Identification Number of a passenger
		uid=util.MD5(stringUid);
		uid=uid.substring(0, 5);
		Passenger newPassenger=new Passenger(surname,name,idNumber,nationality,address,phone,uid);
		//Add every one flight to the passenger's flight list
		for(int i=0;i<codeFlights.length;i++){
			newPassenger.setBookedFlights(codeFlights[i]);
		}
		passengers.addTail(newPassenger);

		return uid;
	}
	//Ask for the booking code to be removed
	public String askRemovePassenger(){
		System.out.println("Give your booking code:");
		Scanner in=new Scanner(System.in);
		String bookingCode=in.nextLine();
		//int index=searchForCode(bookingCode);
		//passengers.removeNode(index);
		
		return bookingCode;
	}
	
	//Remove a passenger from the passengers list
	public void removePassenger(String bookingCode){
		int index=searchForCode(bookingCode);
		passengers.removeNode(index);
	}
	
	//Search for a booking ID and returns the position of that passenger
	public int searchForCode(String bookingCode){
		Passenger searchPassenger;
		int index;
		boolean found=false;
		int listLength=passengers.getLength();
		
		for(index=1;index<=listLength;index++){
			searchPassenger=passengers.getNodeValue(index);
			if(searchPassenger.getUid().equals(bookingCode)){
				found=true;
				break;
			}
		}
		if(found==false)
			index=-1;
		
		return index;
	}
}
