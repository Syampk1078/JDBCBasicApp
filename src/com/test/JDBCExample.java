package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/project?useSSL=false";
		String uId = "root";
		String pwd = "1234";
		Connection connection =  DriverManager.getConnection(url,uId,pwd);
		System.out.println("Connection Successful...");

	}

}
