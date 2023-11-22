package org.example.transcation;

import org.example.util.LoadAndCreateConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class WithTransaction {

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        // Creating the connection
        try {
            connection = LoadAndCreateConnection.getConnection();
            connection.setAutoCommit(false);

            Statement statement = connection.createStatement();

            String SQL1 = "Insert into student (student_id, last_name, first_name, address, city)" +
                    "Values(111,'Gupta','Amit','Delhi','New Delhi')";
            statement.executeUpdate(SQL1);

            String SQL2 = "Insert (student_id, last_name, first_name, address, city)" +
                    "Values(112,'Gupta','Parth','jaipur','jaipur')";

            statement.executeUpdate(SQL2);
            connection.commit();
            System.out.println("Inserted Value");

        } catch (Exception exception) {
            connection.rollback();
            connection.close();
            exception.printStackTrace();
            System.out.println("Message : " + exception.getMessage());
        }
    }
}
