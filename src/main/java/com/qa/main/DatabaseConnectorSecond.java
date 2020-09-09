package com.qa.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.qa.utils.DatabaseConfiguration;

public class DatabaseConnectorSecond {
	
	private Connection connection;
	
	private Statement statement;
	
	//second class to insert into different table
	
	public DatabaseConnectorSecond() throws SQLException{
		connection = DriverManager.getConnection(
				DatabaseConfiguration.URL, 
				DatabaseConfiguration.USER, 
				DatabaseConfiguration.PASSWORD
				);
	}
	
	public void createRecord2(String forename, String surname, int age) throws SQLException{
        String query = "INSERT INTO second (forename, surname, age) VALUES " + "(?, ?, ?)";
        PreparedStatement pS = connection.prepareStatement(query);
        pS.setString(1, forename);
        pS.setString(2, surname);
        pS.setInt(3, age);
        pS.execute();
		System.out.println(forename + " " + surname + " added successfully");
	}
	
	public void readAll2() throws SQLException{
		String query = "SELECT * FROM second";
		this.statement = connection.createStatement();
		ResultSet results = this.statement.executeQuery(query);
		
			while (results.next()) {
				System.out.println(String.format("%s %s %s %s", results.getInt("ID"), results.getString("forename"), results.getString("surname"), results.getString("age")));
		}
	}
}
