package org.example.service;

import org.example.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ServicesRepository {

    public void getById(int id) {
        String sql = "SELECT * FROM services WHERE id = " + id + ";";

        try (Statement statement = ConnectionManager.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            if (resultSet.next()) {
                int servicesId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID: " + servicesId + ", Name: " + name);
            } else {
                System.out.println("Services with ID " + id + " does not exist.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(int id, String name) {
        String sql = "INSERT INTO services (id, name) VALUES (" + id + ", '" + name + "');";

        try (Statement statement = ConnectionManager.getConnection().createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Client with ID " + id + " and name '" + name + "' added successfully!");
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public void get() {
        String sql = "SELECT * FROM services";

        try (Statement statement = ConnectionManager.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public void update(int id, String name) {
        String sql = "UPDATE services SET name = '" + name + "' WHERE id = " + id + ";";

        try (Statement statement = ConnectionManager.getConnection().createStatement()) {
            int rowsAffected = statement.executeUpdate(sql);
            if (rowsAffected > 0) {
                System.out.println("Service name updated successfully!");
            } else {
                System.out.println("No service found with ID: " + id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM services WHERE id = " + id + ";";

        try (Statement statement = ConnectionManager.getConnection().createStatement()) {
            int rowsAffected = statement.executeUpdate(sql);
            if (rowsAffected > 0) {
                System.out.println("Service with ID " + id + " deleted successfully!");
            } else {
                System.out.println("No service found with ID: " + id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS services (" +
                "id INT PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL" +
                ");";

        try (Connection connection = ConnectionManager.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println("Table 'services' created successfully!");
        } catch (SQLException e) {
            throw new RuntimeException("Error while creating table: " + e.getMessage(), e);
        }
    }
}



