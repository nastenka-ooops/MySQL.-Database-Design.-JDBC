package org.example;

import java.sql.*;

public class DatabaseConnection {
    public static void main(String[] args) {
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/flower_shop";
        String username = "root";
        String password = "n3a0s1t2ia";
        try{
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Соединение успешно установлено!");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM flower");
            while (resultSet.next()){
                System.out.println(resultSet.getString(2));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Соединение не установлено!");
        }
    }
}
