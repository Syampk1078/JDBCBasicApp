package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCExample5 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sample?useSSL=false";
        String uId = "root";
        String pwd = "1234";

        try (Scanner sc = new Scanner(System.in);
             Connection connection = DriverManager.getConnection(url, uId, pwd)) {

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO persons VALUES (?, ?, ?, ?, ?)");

            while (true) {
                int personID;
                String firstName;
                String lastName;
                String address;
                String city;

                // Input validation
                while (true) {
                    System.out.println("Enter Person Id (integer): ");
                    if (sc.hasNextInt()) {
                        personID = sc.nextInt();
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter an integer.");
                        sc.next(); // Consume invalid input
                    }
                }

                System.out.println("Enter First Name: ");
                firstName = sc.next();

                System.out.println("Enter Last Name: ");
                lastName = sc.next();

                sc.nextLine(); // Consume newline character
                System.out.println("Enter Address: ");
                address = sc.nextLine();

                System.out.println("Enter City Name: ");
                city = sc.nextLine();

                // Set parameters and execute update
                preparedStatement.setInt(1, personID);
                preparedStatement.setString(2, lastName);
                preparedStatement.setString(3, firstName);
                preparedStatement.setString(4, address);
                preparedStatement.setString(5, city);
                preparedStatement.executeUpdate();

                System.out.println("Data inserted successfully.\nDo you want to insert one more record (yes/no)");
                String str = sc.next();
                if (str.equalsIgnoreCase("no")) break;
            }

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        System.out.println("Resources are released.");
    }
}
