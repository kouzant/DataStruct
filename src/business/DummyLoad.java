package business;

import java.util.Date;
import java.util.GregorianCalendar;

import structures.DoublyLinkedList;
import entities.Flight;

public class DummyLoad {
	public static DoublyLinkedList<Flight> loadFlights(){
		DoublyLinkedList<Flight> flights=new DoublyLinkedList<Flight>();
		
		Date departureDate=new GregorianCalendar(2011,04,15,18,15).getTime();
		Date arrivalDate=new GregorianCalendar(2011,04,15,20,30).getTime();
		Flight flight=new Flight("EZY8567", "Athens", "London", departureDate, arrivalDate, 180.50, "Airbus 320", 100, 50);
		flights.addTail(flight);
		
		departureDate=new GregorianCalendar(2011, 04, 16, 15, 00).getTime();
		arrivalDate=new GregorianCalendar(2011, 04, 16, 17, 30).getTime();
		flight=new Flight("ABC1234", "Athens", "Crete", departureDate, arrivalDate, 100, "Airbus123", 50, 9);
		flights.addTail(flight);
		
		departureDate=new GregorianCalendar(2011, 05, 1, 8, 2).getTime();
		arrivalDate=new GregorianCalendar(2011, 5, 1, 13, 40).getTime();
		flight=new Flight("DEF5678", "Crete", "Alexandria", departureDate, arrivalDate, 200.20, "Airbus 450", 200, 150);
		flights.addTail(flight);
		
		return flights;
	}
}
