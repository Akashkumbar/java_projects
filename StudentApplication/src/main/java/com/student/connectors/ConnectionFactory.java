package com.student.connectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/company_1";
    private static final String USER = "root";
    private static final String PASSWORD = "tiger";

    // Method to create and return a database connection
    public static Connection requestConnection() {
        Connection con = null;
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Create connection
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connection established successfully.");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found. Include it in your library path.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Failed to establish a database connection. Check the URL, username, or password.");
            e.printStackTrace();
        }
        return con;
    }
}
