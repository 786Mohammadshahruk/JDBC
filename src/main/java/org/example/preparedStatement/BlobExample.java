package org.example.preparedStatement;

import org.example.util.LoadAndCreateConnection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class BlobExample {

    private static void uploadFile(String path) {

        try (Connection connection = LoadAndCreateConnection.getConnection()) {
            String QUERY = "INSERT INTO image_example_2(id,text_data ) VALUES(?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setInt(1, 106);

            File fileInputStream = new File(path);
            System.out.println(fileInputStream.getName());
            FileReader fileReader = new FileReader(fileInputStream);
            preparedStatement.setCharacterStream(2, fileReader, (int) fileInputStream.length());

            preparedStatement.executeUpdate();
            System.out.println("image Inserted ");

        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println(exception.getMessage());
        }

    }

    public static void main(String[] args) {
        uploadFile("/Users/mohammadshahruk/SHAHRUK/Teat2/abc.txt");
    }
}
