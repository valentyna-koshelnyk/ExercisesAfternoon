package org.example.customers;

import org.example.Main;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DbClientCustomers {


    public DbClientCustomers(Connection dataSource) {
        Properties prop = new Properties();
        try (InputStream input = Main.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            // Load a properties file from class path, inside static method
            prop.load(input);
            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.username");
            String password = prop.getProperty("db.password");
            try (Connection conn = DriverManager.getConnection(url, user,
                    password)) {
                System.out.println("Connected to the database successfully");
                conn.close();

            } catch (SQLException e) {

                System.out.println("Error connecting to the database");

                e.printStackTrace();


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void run(String sql) {
        Properties prop = new Properties();
        try (InputStream input = Main.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }

            // Load a properties file from class path, inside static method
            prop.load(input);
            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.username");
            String password = prop.getProperty("db.password");

            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                try (Statement statement = conn.createStatement()) {
                    statement.executeUpdate(sql);
                } catch (SQLException e) {
                    throw new RuntimeException("Error executing SQL query", e);
                }
            } catch (SQLException e) {
                throw new RuntimeException("Error connecting to the database", e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Customers select(String query) {
        List<Customers> customers = selectForCustomersList(query);
        if (customers.size() == 1) {
            return customers.get(0);
        } else if (customers.size() == 0) {
            return null;
        } else {
            throw new IllegalStateException("Query returned more than one object");
        }
    }

    public List<Customers> selectForCustomersList(String query) {
        List<Customers> customers = new ArrayList<>();

        Properties prop = new Properties();
        try (InputStream input = Main.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
            }
            // Load a properties file from class path, inside static method
            prop.load(input);
            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.username");
            String password = prop.getProperty("db.password");

            try (Connection conn = DriverManager.getConnection(url, user,
                    password);
                 Statement statement = conn.createStatement();
                 ResultSet resultSetCustomers = statement.executeQuery(query)) {

                while (resultSetCustomers.next()) {
                    int customerId = resultSetCustomers.getInt("CustomerId");
                    String name = resultSetCustomers.getString("Name");
                    String email = resultSetCustomers.getString("Email");
                    String phone = resultSetCustomers.getString("Phone");
                    Customers customer = new Customers(customerId, name, email, phone);
                    customers.add(customer);
                }
                return customers;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
