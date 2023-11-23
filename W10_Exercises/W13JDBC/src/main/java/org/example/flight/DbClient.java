package org.example.flight;

import org.example.Main;
import org.example.customers.Customers;
import org.example.flight.Flight;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DbClient {

    public DbClient(Connection dataSource) {
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

    public void run(String str) {
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
                    statement.executeUpdate(str);
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

    public Flight select(String query) {
        List<Flight> flights = selectForFlightList(query);
        if (flights.size() == 1) {
            return flights.get(0);
        } else if (flights.size() == 0) {
            return null;
        } else {
            throw new IllegalStateException("Query returned more than one object");
        }
    }

    public List<Flight> selectForFlightList(String query) {
        List<Flight> flights = new ArrayList<>();

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
                 ResultSet resultSetFlight = statement.executeQuery(query)) {
                while (resultSetFlight.next()) {
                    int FlightId = resultSetFlight.getInt("FlightId");
                    String Airline = resultSetFlight.getString("Airline");
                    String Origin = resultSetFlight.getString("Origin");
                    String Destination = resultSetFlight.getString("Destination");
                    String DepartureTime = resultSetFlight.getString("DepartureTime");
                    String ArrivalTime = resultSetFlight.getString("ArrivalTime");
                    double Price = resultSetFlight.getDouble("Price");
                    int SeatsAvailable = resultSetFlight.getInt("SeatsAvailable");
                    Flight flight = new Flight(FlightId, Airline, Origin, Destination, DepartureTime, ArrivalTime, Price, SeatsAvailable);
                    flights.add(flight);
                }
                return flights;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
