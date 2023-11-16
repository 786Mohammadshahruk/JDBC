package org.example;

import org.example.util.LoadAndCreateConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUpdateExample {
    public static void main(String[] args) {
        Connection connection = LoadAndCreateConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            String QUERY = "Update student SET city = 'Pune' where student_Id = 101";
            statement.executeUpdate(QUERY);
            System.out.println("Record Updated ");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
