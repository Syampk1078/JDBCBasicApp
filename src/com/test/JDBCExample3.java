package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample3 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/sample?useSSL=false";
		String uId = "root";
		String pwd = "1234";
		
		try(Connection connection = DriverManager.getConnection(url, uId, pwd);
				Statement statement = connection.createStatement()){
			
			ResultSet res = statement.executeQuery("select *from persons");
			while(res.next()) {
				System.out.println(res.getString("LastName"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
