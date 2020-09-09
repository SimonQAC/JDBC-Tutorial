package com.qa.main;

import java.sql.SQLException;
import java.util.Scanner;

public class Action {
	
	private static Scanner scan = new Scanner(System.in);

	public static void getAction() throws SQLException{
	DatabaseConnector db = new DatabaseConnector();
	String action = "";
	
	try {	
		do {
			action = CRUDer.getCRUD();
			switch (action) {
			case "C":
				CRUDer.create();
				break;
			case "R":
				CRUDer.read();
				break;
			case "U":
				CRUDer.update();
				break;
			case "D":
				CRUDer.delete();
				break;
			case "E":
				break;
			default:
				System.out.println("No Match");
			}
		}
		while (!action.equals("E"));
		System.out.println("Exiting");
	}
	finally {
		scan.close();
		db.close();
	}
}
}
