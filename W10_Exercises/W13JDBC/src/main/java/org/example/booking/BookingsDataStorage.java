package org.example.booking;

import W9_Exercises.W91_IOStreams.Book;
import org.example.customers.Customers;
import org.example.customers.DBCustomersDAO;
import org.example.persistence.util.DAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class BookingsDataStorage {
    public void addBookingsList() {
        DAO bookingsDAO = new DbBookingsDAO();

        List<Bookings> bookings = generateBookings();

        for (Bookings booking : bookings) {
            bookingsDAO.add(booking);
        }
    }

    public List<Bookings> generateBookings() {
        List<Bookings> bookings = new ArrayList<>();

        bookings.add(new Bookings(0,
                0,
                0,
                Date.valueOf("2023-12-25"),
                2,
                "approved"));
        bookings.add(new Bookings(1,
                1,
                0,
                Date.valueOf("2023-12-20"),
                1,
                "approved"));
        bookings.add(new Bookings(2,
                2,
                1,
                Date.valueOf("2023-12-20"),
                1,
                "approved"));

        bookings.add(new Bookings(3,
                3,
                4,
                Date.valueOf("2023-12-18"),
                1,
                "approved"));

        bookings.add(new Bookings(4,
                5,
                4,
                Date.valueOf("2023-12-18"),
                1,
                "approved"));
        bookings.add(new Bookings(5,
                6,
                4,
                Date.valueOf("2023-12-18"),
                1,
                "approved"));
        bookings.add(new Bookings(6,
                7,
                4,
                Date.valueOf("2023-12-18"),
                1,
                "approved"));
        bookings.add(new Bookings(7,
                8,
                5,
                Date.valueOf("2023-12-15"),
                1,
                "approved"));

        bookings.add(new Bookings(8, 7, 5, Date.valueOf("2023-12-19"), 1, "approved"));
        bookings.add(new Bookings(9, 7, 1, Date.valueOf("2023-12-10"), 1, "approved"));
        bookings.add(new Bookings(10, 7, 4, Date.valueOf("2024-01-10"), 1, "approved"));
        bookings.add(new Bookings(11, 8, 4, Date.valueOf("2024-01-10"), 1, "approved"));
        bookings.add(new Bookings(12, 8, 9, Date.valueOf("2024-12-10"), 1, "approved"));
        bookings.add(new Bookings(13, 8, 5, Date.valueOf("2024-12-19"), 1, "approved"));
        bookings.add(new Bookings(14, 8, 1, Date.valueOf("2024-12-20"), 1, "approved"));
        return bookings;
    }
}