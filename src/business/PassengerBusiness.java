package business;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
		byte[] uidB=null;
		String uid=null;
		try {
			byte[] tmpUid = idNumber.concat(codeFlight).getBytes("UTF-8");
			MessageDigest md=MessageDigest.getInstance("MD5");
			uidB=md.digest(tmpUid);
			uid=new String(uidB,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		uid=uid.substring(0, 5);
		Passenger newPassenger=new Passenger(surname,name,idNumber,nationality,address,phone,uid);
		for(int i=0;i<codeFlights.length;i++){
			System.out.println(codeFlights[i]);
			newPassenger.setBookedFlights(codeFlights[i]);
		}
		passengers.addTail(newPassenger);
	}
}
