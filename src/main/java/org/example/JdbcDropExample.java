package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDropExample {
    public static void main(String[] args) {
        try {
            // 1. Loading Driver Class
            Class.forName("com.mysql.cj.jdbc.Driver");
            String USER = "root";
            String PASSWORD = "root12345";
            String URL = "jdbc:mysql://localhost:3306/student_db";
            // 2. Creating the connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            if (connection != null) {
                //3. Creating the Statement
                Statement statement = connection.createStatement();
                String query = "DROP DATABASE testdb";
                //4. send and Executing the statement
                int value = statement.executeUpdate(query);
                System.out.println("Dropped DataBase " + value);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
