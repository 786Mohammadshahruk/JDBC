package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcStatementCreateTableExample {
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
        String URL = "jdbc:mysql://localhost:3306/student_db";
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            if (connection != null) {
                System.out.println("Connection Established ");

                //Creating Statement Object
                Statement statement = connection.createStatement();

                //sending and executing the query
                String QUERY = "CREATE TABLE student (student_Id int,last_name varchar(255),first_name varchar(255),address varchar(255),city varchar(255))";
                int value = statement.executeUpdate(QUERY);
                System.out.println("Table Created : " + value);
            } else {
                System.out.println("Connection Not Established ");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Getting Error While Establishing the Connection");
        }

    }
}
