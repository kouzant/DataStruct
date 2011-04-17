package booking;

import structures.DoublyLinkedList;
import entities.Flight;

public class Utilities {
	//Traverse the list and search for the given flight code
	public int searchForFlightCode(DoublyLinkedList<Flight> flights, String flightCode){
		Flight searchFlight;
		int index;
		boolean found=false;
		int listLength=flights.getLength();
		
		for(index=1;index<=listLength;index++){
			searchFlight=flights.getNodeValue(index);
			System.out.println("Flight Code: "+searchFlight.getFlightCode());
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
