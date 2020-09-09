package com.qa.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.qa.utils.DatabaseConfiguration;

public class DatabaseConnector {

	private Connection connection;
	
	private Statement statement;
	
	public DatabaseConnector() throws SQLException{
		connection = DriverManager.getConnection(
				DatabaseConfiguration.URL, 
				DatabaseConfiguration.USER, 
				DatabaseConfiguration.PASSWORD
				);
	}
	
	public void createRecord(String forename, String surname) throws SQLException{
        String query = "INSERT INTO first VALUES " + "(?,?)";
        PreparedStatement pS = connection.prepareStatement(query);
        pS.setString(1, forename);
        pS.setString(2, surname);
        pS.execute();
		System.out.println(forename + " " + surname + " added successfully");
	}
	
	public void readAll() throws SQLException{
		String query = "SELECT * FROM first";
		System.out.println("----------------------");
		System.out.println("| Forename | Surname |");
		System.out.println("----------------------");
		this.statement = connection.createStatement();
		ResultSet results = this.statement.executeQuery(query);
		
			while (results.next()) {
				System.out.println(String.format("%s %s", results.getString("forename"), results.getString("surname")));
		}
			System.out.println("----------------------");
	}
	
	public void updateSurname(String forename, String surname, String newsurname) throws SQLException{
		String query = "UPDATE first SET surname = ? WHERE forename = ? AND surname = ? ";
		PreparedStatement pS = connection.prepareStatement(query);
		pS.setString(1, newsurname);
		pS.setString(2, forename);
		pS.setString(3, surname);
		pS.execute();
		System.out.println("Updated " + forename + " " + surname + " to " + forename + " " + newsurname);
	}
	
	public void deleteRecord(String forename, String surname) throws SQLException{
		String query = "DELETE FROM first WHERE forename=? AND surname=?";
		PreparedStatement pS = connection.prepareStatement(query);
		pS.setString(1, forename);
		pS.setString(2, surname);
		pS.execute();
		System.out.println("Deleted " + forename + " " + surname);
	}
	
	
	
}
