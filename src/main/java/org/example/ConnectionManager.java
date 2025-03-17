package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    public static Connection getConnection(){
        Connection connection = null;
        String url = "jdbc:postgresql://localhost:5432/";

        try {
            connection = DriverManager.getConnection(url + DbConfig.DB_NAME, DbConfig.USER, DbConfig.PASSWORD);
            if (connection != null) {
                System.out.println("Connection established successfully!");

            } else {
                System.out.println("Connection error");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
