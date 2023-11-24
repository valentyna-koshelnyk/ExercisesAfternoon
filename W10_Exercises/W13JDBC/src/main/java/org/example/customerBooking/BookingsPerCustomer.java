package org.example.customerBooking;

import org.example.Main;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BookingsPerCustomer {

    private static final String BOOKINGS_CUSTOMER = "SELECT  Customers.Name, COUNT(Bookings.BookingID) AS n_bookings " +
            "FROM Bookings " +
            "Inner JOIN Customers ON Customers.CustomerId = Bookings.CustomerId " +
            "GROUP BY Customers.Name " +
            "ORDER BY n_bookings DESC";

    public void joinBookingsPerCustomer(){
        Properties prop = new Properties();
        try (
                InputStream input = Main.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            prop.load(input);
            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.username");
            String password = prop.getProperty("db.password");
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                try (PreparedStatement preparedStatement = conn.prepareStatement(BOOKINGS_CUSTOMER)) {
                    try (ResultSet rs = preparedStatement.executeQuery()) {
                        while (rs.next()) {
                            String Name = rs.getString("Name");
                            int n_bookings = rs.getInt("n_bookings");
                            System.out.println("Name: " + Name + " Number of Bookings: " + n_bookings);
                        }
                    }
                } catch (SQLException e) {
                    throw new RuntimeException("Error executing SQL query", e);
                }
            } catch (SQLException e) {
                throw new RuntimeException("Error connecting to the database", e);
            }

        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }

    }
}


