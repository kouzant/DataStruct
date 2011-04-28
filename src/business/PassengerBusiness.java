package business;

import java.math.BigInteger;
import java.util.Scanner;

import entities.Passenger;
import structures.DoublyLinkedList;

public class PassengerBusiness {
	public void listPassengers(DoublyLinkedList<Passenger> passengers){
		System.out.println(passengers);
	}
	public void addPassenger(DoublyLinkedList<Passenger> passengers){
		Scanner in=new Scanner(System.in);
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
		String[] codeFlights=codeFlight.split("[,]");
		Passenger newPassenger=new Passenger(surname,name,idNumber,nationality,address,phone);
		for(int i=0;i<codeFlights.length;i++){
			System.out.println(codeFlights[i]);
			newPassenger.setBookedFlights(codeFlights[i]);
		}
		passengers.addTail(newPassenger);
	}
}
