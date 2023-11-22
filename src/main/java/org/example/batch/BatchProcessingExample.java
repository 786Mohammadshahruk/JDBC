package org.example.batch;

import org.example.util.LoadAndCreateConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessingExample {

    public static void main(String[] args) throws SQLException {
        Connection connection = null;

        try {
            connection = LoadAndCreateConnection.getConnection();
            Statement statement = connection.createStatement();
            String SQL1 = "Insert into student (student_id, last_name, first_name, address, city)" +
                    "Values(203,'Gupta','Amit','Delhi','New Delhi')";
            statement.addBatch(SQL1);

            String SQL2 = "Insert into student (student_id, last_name, first_name, address, city)" +
                    "Values(204,'Gupta','Amit','Delhi','New Delhi')";
            statement.addBatch(SQL2);

            int[] executeBatches = statement.executeBatch();

            for (int value : executeBatches) {
                System.out.println(value + " Record Created ");
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}
