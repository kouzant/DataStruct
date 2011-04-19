package business;

import java.util.Scanner;

public class Menu {
	private StringBuilder sb=new StringBuilder();
	private Scanner in=new Scanner(System.in);
	private int choice;
	
	public int mainMenu(){
		sb.append("Welcome to the airline booking system").append("\n");
		sb.append("Please make your choice").append("\n");
		sb.append("<--------------------->").append("\n");
		sb.append("1 -- View available flights").append("\n");
		sb.append("2 -- Add Flight").append("\n");
		sb.append("3 -- Delete Flight").append("\n");
		sb.append("0 -- Exit").append("\n");
		System.out.println(sb.toString());
		choice=in.nextInt();
		System.out.println("Choice: "+choice);
		
		return choice;
	}
}
