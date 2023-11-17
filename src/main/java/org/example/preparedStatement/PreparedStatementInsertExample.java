package org.example.preparedStatement;

import org.example.util.LoadAndCreateConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementInsertExample {

    private static void insertData(int studentId, String lastName, String firstName, String address, String city) {
        String QUERY = "INSERT INTO student(student_Id, last_name, first_name, address, city) VALUES(?, ?, ?, ?, ?)";
        try (Connection connection = LoadAndCreateConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setInt(1, studentId);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, city);
            preparedStatement.executeUpdate();
            System.out.println("Data Inserted !!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        insertData(105, "mishra", "rakesh", "Delhi", "new Delhi");
    }
}
