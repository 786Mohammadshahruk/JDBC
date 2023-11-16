package org.example;

import org.example.util.LoadAndCreateConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcFetchExample {

    public static void main(String[] args) throws SQLException {

        Connection connection = LoadAndCreateConnection.getConnection();

        try {
            Statement statement = connection.createStatement();
            String QUERY = "SELECT * from student where student_id = 101";
            ResultSet resultSet = statement.executeQuery(QUERY);
            while (resultSet.next()) {
                int student_Id = resultSet.getInt("student_Id");
                String last_name = resultSet.getString("last_name");
                String first_name = resultSet.getString("first_name");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                System.out.println(student_Id + " , " + last_name + " , " + first_name + " , " + address + " , " + city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }

    }
}
