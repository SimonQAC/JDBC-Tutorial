package com.qa.main;

import java.sql.SQLException;

public class Runner {

	public static void main(String[] args) throws SQLException {

		DatabaseConnector db = new DatabaseConnector();
		db.createRecord("Nick" , "Johnson");
		db.readAll();
		db.updateSurname("Nick", "Johnson", "Cage");
		db.readAll();
		db.deleteRecord("Nick","Cage");
		db.readAll();
		
		//DatabaseConnectorSecond db2 = new DatabaseConnectorSecond();
		//db2.createRecord2("Test3","Ificate3", 6);
		//db2.readAll2();
	}

}
