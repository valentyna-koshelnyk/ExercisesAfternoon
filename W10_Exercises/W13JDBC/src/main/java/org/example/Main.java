package org.example;

import org.example.booking.Bookings;
import org.example.booking.DbBookingsDAO;
import org.example.customers.Customers;
import org.example.customers.DBCustomersDAO;
import org.example.flight.DBFlightDAO;
import org.example.flight.Flight;
import org.example.persistence.util.CheckConnection;
import org.example.persistence.util.DAO;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        CheckConnection checkConnection = new CheckConnection();
        checkConnection.checkConnection();

        // Generating 10 flights with IDs in the range from 50 to 59
        DAO flightDAO = new DBFlightDAO();
        for (int i = 50; i <= 59; i++) {
            Flight flight = new Flight(
                    i,
                    "Airline" + i,
                    "Origin" + i,
                    "Destination" + i,
                    "18:00", // Replace with your actual departure time
                    "20:00", // Replace with your actual arrival time
                    100.0 + i, // Replace with your actual price calculation
                    150 + i // Replace with your actual seats available
            );
            flightDAO.add(flight);
        }

        // Generating 10 customers with IDs in the range from 50 to 59
        DAO customerDAO = new DBCustomersDAO();
        for (int i = 50; i <= 59; i++) {
            Customers customer = new Customers(
                    i,
                    "Name" + i,
                    "email" + i + "@example.com",
                    "+123456789" + i
            );
            customerDAO.add(customer);
        }

        // Generating 10 bookings with IDs in the range from 50 to 59
        DAO bookingDAO = new DbBookingsDAO();
        for (int i = 50; i <= 59; i++) {
            Bookings booking = new Bookings(
                    i,
                    (i % 10) + 1, // Assigning a customer ID (1 to 10) for simplicity
                    (i % 10) + 1, // Assigning a flight ID (1 to 10) for simplicity
                    Date.valueOf("2023-12-25"),
                    (i % 2) + 1, // Assigning a seat number (1 or 2) for simplicity
                    "approved"
            );
            bookingDAO.add(booking);
        }
    }
}
