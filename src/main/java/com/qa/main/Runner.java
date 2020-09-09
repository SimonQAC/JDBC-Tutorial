package com.qa.main;

import java.sql.SQLException;
import java.util.Scanner;

public class Runner {
	
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {

		DatabaseConnector db = new DatabaseConnector();
		CRUDer CRUD = new CRUDer();
		
		String action = "";
		
		try {	
			do {
				action = getAction();
				switch (action) {
				case "C":
					CRUD.create();
					break;
				case "R":
					db.readAll();
					break;
				case "U":
					CRUD.update();
					break;
				
				case "D":
					System.out.println("Delete record with id");
					int id = scan.nextInt();	
					db.deleteRecord(id);
					break;
				case "E":
					break;
				default:
					System.out.println("No Match");
		}
			}
			while (!action.equals("E"));
			System.out.println("bye");
		}
		finally {
			scan.close();
			db.close();
		}
		
		//db.createRecord("Nick" , "Johnson");
		//db.readAll();
		//db.updateSurname("Nick", "Johnson", "Cage");
		//db.readAll();
		//db.deleteRecord("Nick","Cage");
		//db.readAll();

		
	}
	
	private static String getAction() {
				System.out.println("Ender C/R/U/D	(E)");
		return scan.nextLine();
		
	}


}
