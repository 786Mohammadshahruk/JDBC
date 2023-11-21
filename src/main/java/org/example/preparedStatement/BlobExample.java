package org.example.preparedStatement;

import org.example.util.LoadAndCreateConnection;

import java.io.*;
import java.sql.*;

public class BlobExample {

    private static void uploadFile(String path) {

        try (Connection connection = LoadAndCreateConnection.getConnection()) {
            String QUERY = "INSERT INTO image_example_2(id,text_data ) VALUES(?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setInt(1, 106);

            File fileInputStream = new File(path);// picking the file from local directory

            FileReader fileReader = new FileReader(fileInputStream);
            preparedStatement.setCharacterStream(2, fileReader, (int) fileInputStream.length());

            preparedStatement.executeUpdate();
            System.out.println("file Inserted ");

        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println(exception.getMessage());
        }

    }

    private static void uploadImage(String path) {
        try (Connection connection = LoadAndCreateConnection.getConnection()) {
            String Query = "insert into images(id,binary_data) values(?,?) ";
            PreparedStatement preparedStatement = connection.prepareStatement(Query);

            preparedStatement.setInt(1, 2);

            FileInputStream fileInputStream = new FileInputStream(path);
            preparedStatement.setBinaryStream(2, fileInputStream);
            preparedStatement.executeUpdate();
            System.out.println("Record Inserted");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private static void fetchImage() {
        try (Connection connection = LoadAndCreateConnection.getConnection()) {
            String SQL = "select * from images";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            int fileNumber = 1;
            while (resultSet.next()) {
                Blob blob = resultSet.getBlob(2);
                byte[] bytes = blob.getBytes(1, (int) blob.length());

                String fileName = "/Users/mohammadshahruk/Downloads/" + fileNumber + "Test.jpg";
                fileNumber++;
                FileOutputStream fileOutputStream = new FileOutputStream(fileName);

                fileOutputStream.write(bytes);

                fileOutputStream.close();
                System.out.println("Task Completed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void fetchFile() {
        try (Connection connection = LoadAndCreateConnection.getConnection()) {
            String SQL = "select * from image_example_2";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            int fileNumber = 1;
            while (resultSet.next()) {
                Clob clob = resultSet.getClob(2);
                Reader reader = clob.getCharacterStream();

                String FILE = "/Users/mohammadshahruk/Downloads/" + fileNumber + "Test.txt";
                fileNumber++;
                FileWriter fileWriter = new FileWriter(FILE);

                int i;
                while ((i = reader.read()) != -1) {
                    fileWriter.write((char) i);
                }
                fileWriter.close();
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //uploadFile("/Users/mohammadshahruk/SHAHRUK/Teat2/abc.txt");
        //uploadImage("/Users/mohammadshahruk/Desktop/test1.png");
        //fetchImage();
        //fetchFile();
    }
}
