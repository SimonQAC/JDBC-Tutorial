package com.qa.main;
import java.sql.SQLException;
import java.util.Scanner;

public class CRUDer {
	private static Scanner scan = new Scanner(System.in);
	
	public static String getCRUD() {
			System.out.println("Ender C/R/U/D	(E)");
			return scan.nextLine();
	
	}
	
	public static void update() throws SQLException {
	DatabaseConnector db = new DatabaseConnector();
	String action2 = "";
	do {
	action2 = getUpdateAction();
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
			System.out.println("Enter ID to update");
			int id2 = scan.nextInt();
			scan.nextLine();
			System.out.println("Enter new Forename");
			String newforename = scan.nextLine();
			db.updateForename(id2, newforename);
			System.out.println("Updated " + id2 + " to forename " + newforename);
			break;
		case "A":
			System.out.println("Enter ID to update");
			int id3 = scan.nextInt();
			scan.nextLine();
			System.out.println("Enter new Age");
			String newage = scan.nextLine();
			db.updateAge(id3, newage);
			System.out.println("Updated " + id3 + " to age " + newage);
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
	
	public static void create() throws SQLException{
		DatabaseConnector db = new DatabaseConnector();
		System.out.println("Enter forename");
		String forename = scan.nextLine();
		System.out.println("Enter surname");
		String surname = scan.nextLine();
		System.out.println("Enter age");
		int age = scan.nextInt();
		db.createRecord(forename, surname,age);;
	}
	
	public static void delete() throws SQLException{
		DatabaseConnector db = new DatabaseConnector();
		System.out.println("Delete record with id");
		int id = scan.nextInt();	
		db.deleteRecord(id);
	}
	
	public static void read() throws SQLException{
		DatabaseConnector db = new DatabaseConnector();
		db.readAll();
	}

	private static String getUpdateAction() {
		System.out.println("Ender F/S/A:	(H)(E)");
	return scan.nextLine();
	}
	
}
