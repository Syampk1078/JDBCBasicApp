package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCExample4 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/sample?useSSL=false";
		String uId = "root";
		String pwd = "1234";
		
		Scanner sc = new Scanner(System.in);
		try(Connection connection = DriverManager.getConnection(url, uId, pwd);
				Statement statement = connection.createStatement()){
			 int personID;
			 String lastName;
			 String firstName;
			 String address,city;
			 
			while(true) {
				 System.out.println("Enter Person Id: ");
				 personID = sc.nextInt();
				 
				 System.out.println("Enter First Name: ");
				 sc.next();
				 firstName = sc.nextLine();
				 System.out.println("Enter Last Name: ");
				 lastName = sc.nextLine();
				 System.out.println("Enter Address: ");
				 address = sc.nextLine();
				 System.out.println("Enter City Name: ");
				 city = sc.nextLine();
				 
				 statement.execute("insert into persons values("+personID+",'"+firstName+"'"
				 		+ ",'"+lastName+"','"+address+"','"+city+"')");
				 
				 System.out.println("Data inserted successfully.\nDo you Want insert one more record (yes/no)");
				 String str = sc.next();
				 if(str=="no") break;
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Resources are released.");
	}

}
