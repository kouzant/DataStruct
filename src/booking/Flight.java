package booking;

import java.util.Date;
import java.util.GregorianCalendar;

public class Flight {
	private String flightCode;
	private String startingPoint;
	private String destination;
	private Date departureTime;
	private Date arrivalTime;
	private double ticketPrice;
	private String planeType;
	private int totalSeats;
	private int availableSeats;
	
	public Flight(String flightCode, String startingPoint, String destination, Date departureTime,
			Date arrivalTime, double ticketPrice, String planeType, int totalSeats, int availableSeats){
		this.flightCode=flightCode;
		this.startingPoint=startingPoint;
		this.destination=destination;
		this.departureTime=departureTime;
		this.arrivalTime=arrivalTime;
		this.ticketPrice=ticketPrice;
		this.planeType=planeType;
		this.totalSeats=totalSeats;
		this.availableSeats=availableSeats;
	}
	
	public String getFlightCode(){
		return flightCode;
	}
	public String getStartingPoint(){
		return startingPoint;
	}
	public String getDestination(){
		return destination;
	}
	public Date getDepartureTime(){
		return departureTime;
	}
	public Date getArrivalTime(){
		return arrivalTime;
	}
	public double getTicketprice(){
		return ticketPrice;
	}
	public String getPlaneType(){
		return planeType;
	}
	public int getTotalSeats(){
		return totalSeats;
	}
	public int getAvailableSeats(){
		return availableSeats;
	}
	
	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append("");
		sb.append("--------------------").append("\n");
		sb.append("Flight Code: ").append(flightCode).append("\n");
		sb.append("Starting Point: ").append(startingPoint).append("\n");
		sb.append("Destination: ").append(destination).append("\n");
		sb.append("Departure Time: ").append(departureTime).append("\n");
		sb.append("Arrival Time: ").append(arrivalTime).append("\n");
		sb.append("Ticket Price: ").append(ticketPrice).append("\n");
		sb.append("Plane Type: ").append(planeType).append("\n");
		sb.append("Total Seats: ").append(totalSeats).append("\n");
		sb.append("Available Seats: ").append(availableSeats);
		
		return sb.toString();
	}
	
	//Test. TO BE DELETED
	public static void main(String[] args){
		Date departureTime=new GregorianCalendar(2011,04,15,18,15).getTime();
		Date arrivalTime=new GregorianCalendar(2011,04,15,20,30).getTime();
		Flight lala=new Flight("EZY8765", "Athens", "London", departureTime, arrivalTime, 180.55, "Airbus 320", 100, 30);
		System.out.println(lala);
		long diff=arrivalTime.getTime() - departureTime.getTime();
		System.out.println("diff: "+diff);
	}
}
