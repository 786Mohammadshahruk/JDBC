package org.example.preparedStatement;

import org.example.util.LoadAndCreateConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateExample {

    private static void update(int id, String value) {
        try (Connection connection = LoadAndCreateConnection.getConnection()) {
            String QUERY = "update student set last_name = ? where student_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, value);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            System.out.println("Record update");
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println(exception.getMessage());
        }

    }

    public static void main(String[] args) {
        update(104, "Mishra");
    }
}
