package com.qa.main;

import java.sql.SQLException;

public class Runner {
	

	public static void main(String[] args)  {
		
		try {
			Action.getAction();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


