package org.example;

import org.example.util.LoadAndCreateConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcDelete {

    public static void main(String[] args) {
        Connection connection = LoadAndCreateConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            Scanner scanner = new Scanner(System.in);
            System.out.println("please enter the student id");
            int studentId = scanner.nextInt();
            String QUERY = "delete from student where student_Id = '" + studentId + "'";
            statement.executeUpdate(QUERY);
            System.out.println("Deleted the record");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
