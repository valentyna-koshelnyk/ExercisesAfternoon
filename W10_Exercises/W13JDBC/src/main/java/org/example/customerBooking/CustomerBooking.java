package org.example.customerBooking;

import org.example.Main;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class CustomerBooking {
    private static final String SQL_JOIN = "SELECT Bookings.bookingId, Customers.customerId, Customers.Name, Flight.Origin, Flight.Destination " +
            "FROM Bookings " +
            "JOIN Customers " +
            "ON Bookings.CustomerId = Customers.CustomerId " +
            "JOIN Flight " +
            "ON Bookings.FlightId = Flight.FlightId";

    public void joinCustomerBooking(){
        Properties prop = new Properties();
        try (InputStream input = Main.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            prop.load(input);
            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.username");
            String password = prop.getProperty("db.password");
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                try (PreparedStatement preparedStatement = conn.prepareStatement(SQL_JOIN)) {
                    try (ResultSet rs = preparedStatement.executeQuery()) {
                        while (rs.next()) {
                            int bookingId = rs.getInt("bookingId");
                            int customerId = rs.getInt("customerId");
                            String customerName = rs.getString("Name");
                            String Origin = rs.getString("Origin");
                            String Destination = rs.getString("Destination");


                            System.out.println("BookingID: " + bookingId + ", CustomerID: " + customerId +
                                    "Customer Name: " + customerName  +
                                    " Origin: " + Origin + " Destination: " + Destination);
                        }
                    }
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
}
