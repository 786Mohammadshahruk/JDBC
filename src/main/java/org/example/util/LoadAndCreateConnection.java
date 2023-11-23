package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoadAndCreateConnection {

    public static Connection getConnection() {

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
        String URL = "jdbc:mysql://localhost:3306/student_db";
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Getting Error While Establishing the Connection");
        }
        return connection;
    }
}
