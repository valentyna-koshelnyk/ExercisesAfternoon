package org.example.customers;

import org.example.Main;
import org.example.persistence.util.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class DBCustomersDAO implements DAO<Customers> {
    private static final String CREATE_DB = "CREATE TABLE IF NOT EXISTS CUSTOMERS(" +
            "CustomerId INT PRIMARY KEY," +
            "Name VARCHAR(50) NOT NULL," +
            "Email VARCHAR(50) UNIQUE NOT NULL," +
            "Phone VARCHAR(15) NOT NULL" +
            ");";
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/ATReservation";
    private static final String SELECT_ALL = "SELECT * FROM Customers";
    private static final String SELECT = "SELECT * FROM Customers WHERE CustomerId = ?";
    private static final String INSERT_DATA = "INSERT INTO Customers VALUES (?,?,?,?)";

    private static final String UPDATE_DATA = "UPDATE Customers SET " +
            "Name = ?, Email = ?, " +
            "Phone = ?  " +
            "WHERE CustomerID = ?";
    private static final String DELETE_DATA = "DELETE FROM Customers WHERE CustomerID = ?";

    private final DbClientCustomers dbClient;
    private final Connection connection;

    public DBCustomersDAO() {
        Properties prop = new Properties();
        try (InputStream input = Main.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                throw new RuntimeException("Missing config.properties");
            }
            // Load a properties file from classpath
            prop.load(input);
            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.username");
            String password = prop.getProperty("db.password");

            this.connection = DriverManager.getConnection(url, user, password);
            this.dbClient = new DbClientCustomers(connection);
            dbClient.run(CREATE_DB);
            System.out.println("Customers data structure created");
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customers> findall() {
        return dbClient.selectForCustomersList(SELECT_ALL);
    }

    @Override
    public Customers findById(int id) {
        Customers customers = dbClient.select(String.format(SELECT, id));

        if (customers != null) {
            System.out.println("Customer: Id " + id + ", found");
            return customers;
        } else {
            System.out.println("Customer: Id " + id + ", not found");
            return null;
        }
    }
    @Override
    public void add(Customers customers) {
        if (dbClient != null) {
            String insertQuery = "INSERT INTO Customers VALUES (?,?,?,?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, customers.getCustomerID());
                preparedStatement.setString(2, customers.getName());
                preparedStatement.setString(3, customers.getEmail());
                preparedStatement.setString(4, customers.getPhone());

                preparedStatement.executeUpdate();

                System.out.println("Customer added successfully");
            } catch (SQLException e) {
                throw new RuntimeException("Error executing SQL query", e);
            }
        } else {
            System.out.println("DbClient is null. Check initialization.");
        }
    }

    @Override
    public void update(Customers customers) {
        dbClient.run(String.format(UPDATE_DATA,
                customers.getCustomerID(),
                customers.getName(), customers.getEmail(), customers.getPhone()));
        System.out.println("Customer updated");

    }



    @Override
    public void deleteById(int id) {
        dbClient.run(String.format(DELETE_DATA, id));
        System.out.println("Customer: Id " + id + " , deleted");

    }


}
