package org.example.callableStatement;

import org.example.util.LoadAndCreateConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StoredProcedureExample {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        try {
            connection = LoadAndCreateConnection.getConnection();
            String QUERY = "{CALL getStudent2()} ";
            CallableStatement callableStatement = connection.prepareCall(QUERY);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Student Id : " + resultSet.getInt("student_Id"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (connection != null)
                connection.close();
        }
    }
}
