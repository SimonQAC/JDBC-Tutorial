package com.qa.main;
import java.sql.SQLException;
import java.util.Scanner;

public class CRUDer {
	private static Scanner scan = new Scanner(System.in);
	
	
	public void update() throws SQLException {
	DatabaseConnector db = new DatabaseConnector();
	String action2 = "";
	do {
	action2 = getAction2();
	switch(action2) {
		case "S":
			System.out.println("Enter ID to update");
			int id = scan.nextInt();
			scan.nextLine();
			System.out.println("Enter new Surname");
			String newsurname = scan.nextLine();
			db.updateSurname(id, newsurname);
			System.out.println("Updated " + id + " to surname " + newsurname);
			break;
		case "F":
			System.out.println("Not available yet");
			break;
		case "A":
			System.out.println("Not available yet");
			break;
		case "E":
			System.out.println("Exited U");
			break;
		default:
			System.out.println("No Match");
			break;
		} 
	}
	while (!action2.equals("E"));
	}
	
	public void create() throws SQLException{
		DatabaseConnector db = new DatabaseConnector();
		System.out.println("Enter forename");
		String forename = scan.nextLine();
		System.out.println("Enter surname");
		String surname = scan.nextLine();
		System.out.println("Enter age");
		int age = scan.nextInt();
		db.createRecord(forename, surname,age);;
	}

	private static String getAction2() {
		System.out.println("Ender F/S/A:	(H)(E)");
	return scan.nextLine();
	}
	
}
