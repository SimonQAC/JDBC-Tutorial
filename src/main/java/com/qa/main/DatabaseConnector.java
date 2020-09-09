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
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void createRecord(String forename, String surname, int age) throws SQLException{
        String query = "INSERT INTO first (forename, surname, age) VALUES " + "(?,?,?)";
        PreparedStatement pS = connection.prepareStatement(query);
        pS.setString(1, forename);
        pS.setString(2, surname);
        pS.setInt(3, age);
        pS.execute();
		System.out.println(forename + " " + surname + " age " + age + " added successfully");
	}
	
	public void readAll() throws SQLException{
		String query = "SELECT * FROM first";
		System.out.println("---------------------------------");
		System.out.println("| Forename | Surname | Age | ID |");
		System.out.println("---------------------------------");
		this.statement = connection.createStatement();
		ResultSet results = this.statement.executeQuery(query);
		
			while (results.next()) {
				//System.out.println(String.format("%s %s", results.getString("forename"), results.getString("surname")));
				String text = results.getString("forename") + " " + results.getString("surname") + "   |   " + results.getInt("age") + "   |   " + results.getInt("id");
				System.out.println(text);
		}
			System.out.println("---------------------------------");
	}
	
	public void updateSurname(int id, String newsurname) throws SQLException{
		String query = "UPDATE first SET surname = ? WHERE id = ? ";
		PreparedStatement pS = connection.prepareStatement(query);
		pS.setInt(2, id);
		pS.setString(1, newsurname);
		pS.execute();		
	}
	
	public void updateForename(int id2, String newforename) throws SQLException{
		String query = "UPDATE first SET forename = ? WHERE id = ? ";
		PreparedStatement pS = connection.prepareStatement(query);
		pS.setInt(2, id2);
		pS.setString(1, newforename);
		pS.execute();	
	}
	
	public void updateAge(int id3, String newage) throws SQLException{
		String query = "UPDATE first SET age = ? WHERE id = ? ";
		PreparedStatement pS = connection.prepareStatement(query);
		pS.setInt(2, id3);
		pS.setString(1, newage);
		pS.execute();	
	}
	
	public void deleteRecord(int id) throws SQLException{
		String query = "DELETE FROM first WHERE id=?";
		PreparedStatement pS = connection.prepareStatement(query);
		pS.setInt(1, id);
		pS.execute();
		System.out.println("Deleted " + id);
	}
	
	
	
}
