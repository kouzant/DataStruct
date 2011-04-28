package business;

import java.util.Scanner;
import java.util.Date;
import java.util.GregorianCalendar;

import entities.Flight;
import structures.DoublyLinkedList;

public class FlightsBusiness {
	public DoublyLinkedList<Flight> loadFlights(){
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
		arrivalDate=new GregorianCalendar(2011, 05, 1, 13, 40).getTime();
		flight=new Flight("DEF5678", "Crete", "Alexandria", departureDate, arrivalDate, 200.20, "Airbus 450", 200, 150);
		flights.addTail(flight);
		
		return flights;
	}
	
	public void listFlights(DoublyLinkedList<Flight> flights){
		System.out.println(flights);
	}
	public void addFlight(DoublyLinkedList<Flight> flights){
		Scanner in=new Scanner(System.in);
		System.out.println("Flight Code:");
		String flightCode=in.nextLine();
		System.out.println("Starting Point:");
		String startingPoint=in.nextLine();
		System.out.println("Destination:");
		String destination=in.nextLine();
		System.out.println("Departure Time (yyyy:mm:dd:hh:mm)");
		String depTime=in.nextLine();
		System.out.println("Arrival Time (yyyy:mm:dd:hh:mm)");
		String arTime=in.nextLine();
		System.out.println("Plane Type:");
		String planeType=in.nextLine();
		System.out.println("Total Seats:");
		int totalSeats=in.nextInt();
		System.out.println("Available Seats:");
		int availableSeats=in.nextInt();
		System.out.println("Ticket Price:");
		double ticketPrice= in.nextDouble();
		String[] tmpDTime=depTime.split("[:]");
		String[] tmpATime=arTime.split("[:]");
		Date departureTime=new GregorianCalendar(Integer.parseInt(tmpDTime[0]), Integer.parseInt(tmpDTime[1])-1, Integer.parseInt(tmpDTime[2]), Integer.parseInt(tmpDTime[3]), Integer.parseInt(tmpDTime[4])).getTime();
		Date arrivalTime=new GregorianCalendar(Integer.parseInt(tmpATime[0]), Integer.parseInt(tmpATime[1])-1, Integer.parseInt(tmpATime[2]), Integer.parseInt(tmpATime[3]), Integer.parseInt(tmpATime[4])).getTime();
		Flight newFlight=new Flight(flightCode, startingPoint, destination, departureTime, arrivalTime, ticketPrice, planeType, totalSeats, availableSeats);
		flights.addTail(newFlight);
	}
	public void removeFlight(DoublyLinkedList<Flight> flights){
		System.out.println("Give flight code:");
		Scanner in=new Scanner(System.in);
		String flightCode=in.nextLine();
		int index=searchForFlightCode(flights, flightCode);
		flights.removeNode(index);
	}
	private int searchForFlightCode(DoublyLinkedList<Flight> flights, String flightCode){
		Flight searchFlight;
		int index;
		boolean found=false;
		int listLength=flights.getLength();
		
		for(index=1;index<=listLength;index++){
			searchFlight=flights.getNodeValue(index);
			if(searchFlight.getFlightCode().equals(flightCode)){
				found=true;
				break;
			}
		}
		if(found==false)
			index=-1;
		
		return index;
	}
}
