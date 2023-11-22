package org.example.transcation;

import org.example.util.LoadAndCreateConnection;

import java.sql.Connection;
import java.sql.Statement;

public class WithoutTransaction {

    public static void main(String[] args) {
        try (Connection connection = LoadAndCreateConnection.getConnection()) {
            Statement statement = connection.createStatement();

            String SQL1 = "Insert into student (student_id, last_name, first_name, address, city)" +
                    "Values(107,'Gupta','Amit','Delhi','New Delhi')";
            statement.executeUpdate(SQL1);

            String SQL2 = "Insert (student_id, last_name, first_name, address, city)" +
                    "Values(108,'Gupta','Parth','jaipur','jaipur')";
            statement.executeUpdate(SQL2);
            System.out.println("Inserted Value");

        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("Message : " + exception.getMessage());
        }
    }
}
