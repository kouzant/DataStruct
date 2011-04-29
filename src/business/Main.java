package business;

import java.util.Scanner;

import entities.*;
import structures.*;

public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Flights list
		DoublyLinkedList<Flight> flights=new DoublyLinkedList<Flight>();
		FlightsBusiness flightB=new FlightsBusiness();
		flightB.setFlightsList(flights);
		flightB.loadFlights();
		//Passengers list
		DoublyLinkedList<Passenger> passengers=new DoublyLinkedList<Passenger>();
		PassengerBusiness passB=new PassengerBusiness();
		passB.setPassengersList(passengers);
		
		Scanner inM=new Scanner(System.in);
		boolean running=true;
		System.out.println("Welcome to the airline booking system");
		
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
				flightB.listFlights();
				break;
			case 2:
				flightB.addFlight();
				break;
			case 3:
				flightB.removeFlight();
				break;
			case 4:
				//Add the user to the passengers list
				String[] codeFlights=passB.askPassenger();
				boolean valid=flightB.validateFlights(codeFlights);
				if(valid){
					//Add to the passenger list
					String bookingID=passB.addPassenger(codeFlights);
				//Add the booking ID to the passenger list or the waiting
				//queue of a specific flight
				//That block of code wasn't written by me, but it works!
				int index=passB.searchForCode(bookingID);
				Passenger newPassenger=passengers.getNodeValue(index);
				int listLength=newPassenger.getBookedFlights().getLength();
				for(int i=0;i<listLength;i++){
					String flightID=newPassenger.getBookedFlights().getNodeValue(i);
					int result=flightB.bookFlight(bookingID, flightID);
					if(result==1){
						System.out.println("Your booking was successful");
					}else if(result==0){
						System.out.println("There were no available seats. You've been " +
						"placed to the waiting queue");
					}
				}
				}else{
					System.out.println("The flights' details are incorrect");
				}
				break;
			case 5:
				passB.listPassengers();
				break;
			case 6:
				passB.removePassenger();
				break;
			case 0:
				running=false;
				break;
			default:
				flightB.listFlights();
				break;
			}
		}
	}
}
