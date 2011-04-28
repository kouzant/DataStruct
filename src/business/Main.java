package business;

import java.util.Scanner;

import entities.*;
import structures.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FlightsBusiness flightB=new FlightsBusiness();
		DoublyLinkedList<Flight> flights=flightB.loadFlights();
		Scanner inM=new Scanner(System.in);
		boolean running=true;
		System.out.println("Welcome to the airline booking system");
		
		while(running){
			System.out.println("Please make your choice");
			System.out.println("<--------------------->");
			System.out.println("1 -- View available flights");
			System.out.println("2 -- Add Flight");
			System.out.println("3 -- Delete Flight");
			System.out.println("0 -- Exit");
			int choice=inM.nextInt();

			switch (choice) {
			case 1:
				flightB.listFlights(flights);
				break;
			case 2:
				flightB.addFlight(flights);
				break;
			case 3:
				flightB.removeFlight(flights);
				break;
			case 0:
				running=false;
				break;
			default:
				flightB.listFlights(flights);
				break;
			}
		}
	}
}
