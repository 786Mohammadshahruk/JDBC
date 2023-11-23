package org.example.callableStatement;

import org.example.util.LoadAndCreateConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class FunctionExample {

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        try {
            connection = LoadAndCreateConnection.getConnection();

            // RETURN_TYPE call calculate_sum(parameter_1,parameter_2)
            String QUERY = "{ ? = call calculate_sum(?,?) }";
            CallableStatement callableStatement = connection.prepareCall(QUERY);

            callableStatement.registerOutParameter(1, Types.INTEGER);
            callableStatement.setInt(2, 100);
            callableStatement.setInt(3, 200);
            callableStatement.execute();

            int result = callableStatement.getInt(1);

            System.out.println("RESULT : " + result);
            callableStatement.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            connection.close();
        }
    }
}
