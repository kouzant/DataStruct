package business;

import java.math.BigInteger;
import java.util.Scanner;

import entities.Passenger;
import structures.DoublyLinkedList;

public class PassengerBusiness {
	//Print all the passengers
	public void listPassengers(DoublyLinkedList<Passenger> passengers){
		System.out.println(passengers);
	}
	//Add a new passenger to the list
	public String addPassenger(DoublyLinkedList<Passenger> passengers){
		Scanner in=new Scanner(System.in);
		Utilities util=new Utilities();
		System.out.println("Surname:");
		String surname=in.nextLine();
		System.out.println("Name:");
		String name=in.nextLine();
		System.out.println("ID Number:");
		String idNumber=in.nextLine();
		System.out.println("Nationality:");
		String nationality=in.nextLine();
		System.out.println("Address:");
		String address=in.nextLine();
		System.out.println("Flight code (comma separated):");
		String codeFlight=in.nextLine();
		System.out.println("Phone number:");
		BigInteger phone=in.nextBigInteger();
		//Split multiple flight codes
		String[] codeFlights=codeFlight.split("[,]");
		String stringUid=idNumber.concat(codeFlight);
		//Unique Identification Number of a passenger
		String uid=util.MD5(stringUid);
		uid=uid.substring(0, 5);
		Passenger newPassenger=new Passenger(surname,name,idNumber,nationality,address,phone,uid);
		//Add every one flight to the passenger's flight list
		for(int i=0;i<codeFlights.length;i++){
			System.out.println(codeFlights[i]);
			newPassenger.setBookedFlights(codeFlights[i]);
		}
		passengers.addTail(newPassenger);
		System.out.println("Your booking code is: "+uid);
		return uid;
	}
	//Remove a passenger from the passengers list
	public void removePassenger(DoublyLinkedList<Passenger> passengers){
		System.out.println("Give your booking code:");
		Scanner in=new Scanner(System.in);
		String bookingCode=in.nextLine();
		int index=searchForCode(passengers, bookingCode);
		passengers.removeNode(index);
	}
	//Search for a booking ID and returns the position of that passenger
	public int searchForCode(DoublyLinkedList<Passenger> passengers, String bookingCode){
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
