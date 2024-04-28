package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample2 {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		String url = "jdbc:mysql://localhost:3306/sample?useSSL=false";
		String uId = "root";
		String pwd = "1234";
		
		try {
			//Load the Driver
			Class.forName("com.mysql.jdbc.Driver");
			//Create connection
			connection =  DriverManager.getConnection(url,uId,pwd);
			System.out.println("Connection Successful...");
			statement = connection.createStatement();
			statement.execute("INSERT INTO Persons (PersonID, LastName, FirstName, Address, City)\r\n"
					+ "VALUES (1, 'Doe', 'John', '123 Main St', 'New York'),\r\n"
					+ "       (2, 'Smith', 'Jane', '456 Elm St', 'Los Angeles'),\r\n"
					+ "       (3, 'Johnson', 'David', '789 Oak St', 'Chicago');\r\n"
					+ "");
			System.out.println("Insert Successful");
			
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(connection != null) connection.close();
				if(statement != null) statement.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
