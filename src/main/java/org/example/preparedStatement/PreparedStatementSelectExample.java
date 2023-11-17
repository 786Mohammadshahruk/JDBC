package org.example.preparedStatement;

import org.example.util.LoadAndCreateConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementSelectExample {

    public static void main(String[] args) throws SQLException {

        String QUERY = "SELECT * from student where student_id = ? And last_name = ?";
        try (Connection connection = LoadAndCreateConnection.getConnection()){ //1.7
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setInt(1,103);
            preparedStatement.setString(2,"Gupta");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int student_Id = resultSet.getInt("student_Id");
                String last_name = resultSet.getString("last_name");
                String first_name = resultSet.getString("first_name");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                System.out.println(student_Id + " , " + last_name + " , " + first_name + " , " + address + " , " + city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
