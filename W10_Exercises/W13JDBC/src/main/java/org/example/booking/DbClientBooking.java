package org.example.booking;

import org.example.Main;
import org.example.flight.Flight;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DbClientBooking {

    public DbClientBooking(Connection dataSource) {
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

    public Bookings select(String query) {
        List<Bookings> bookings = selectForBookingsList(query);
        if (bookings.size() == 1) {
            return bookings.get(0);
        } else if (bookings.size() == 0) {
            return null;
        } else {
            throw new IllegalStateException("Query returned more than one object");
        }
    }

    public List<Bookings> selectForBookingsList(String query) {
        List<Bookings> bookings = new ArrayList<>();

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
                 ResultSet resultSetBooking = statement.executeQuery(query)) {
                while (resultSetBooking.next()) {
                    int BookingID = resultSetBooking.getInt("BookingId");
                    int CustomerId = resultSetBooking.getInt("CustomerID");
                    int FlightId = resultSetBooking.getInt("FlightId");
                    Date bookingDate = resultSetBooking.getDate("BookingDate");
                    int NumberOfPassengers = resultSetBooking.getInt("NumberOfPassengers");
                    String Status = resultSetBooking.getString("Status");
                    Bookings booking = new Bookings(BookingID, CustomerId, FlightId, bookingDate, NumberOfPassengers, Status);
                    bookings.add(booking);
                }
                return bookings;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

