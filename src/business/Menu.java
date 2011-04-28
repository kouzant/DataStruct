package business;

import java.util.Scanner;

public class Menu {
	private Scanner in=new Scanner(System.in);
	private int choice;
	
	public int getChoice(){
		return choice;
	}
	
	public void mainMenu(){
		System.out.println("Welcome to the airline booking system");
		System.out.println("Please make your choice");
		System.out.println("<--------------------->");
		System.out.println("1 -- View available flights");
		System.out.println("2 -- Add Flight");
		System.out.println("3 -- Delete Flight");
		System.out.println("0 -- Exit");
		int choice=in.nextInt();
	}
}
