package business;

import java.util.Date;
import java.util.GregorianCalendar;

import entities.*;
import structures.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DoublyLinkedList<Flight> flights=DummyLoad.loadFlights();
		Menu menu=new Menu();
		FlightsBusiness flightB=new FlightsBusiness();
		System.out.println("SKATA!!!");
		int choice=menu.mainMenu();
		System.out.println("Choice: "+choice);
		
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
		default:
			flightB.listFlights(flights);
			break;
		}

		flightB.listFlights(flights);
	}

}
