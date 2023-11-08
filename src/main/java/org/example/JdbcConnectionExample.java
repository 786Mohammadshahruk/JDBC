package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionExample {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Is Loaded");
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
            System.out.println("Getting Error While Loading the JDBC Driver");
        }

        Connection connection = null;
        String USER = "root";
        String PASSWORD = "root12345";
        String URL = "jdbc:mysql://localhost:3306/testdb";
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Getting Error While Establishing the Connection");
        }
        if (connection != null) {
            System.out.println("Connection Established ");
        } else {
            System.out.println("Connection Not Established ");
        }
    }
}
