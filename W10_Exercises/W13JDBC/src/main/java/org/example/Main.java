package org.example;

import org.example.booking.Bookings;
import org.example.booking.BookingsDataStorage;
import org.example.booking.DbBookingsDAO;
import org.example.customerBooking.BookingsPerCustomer;
import org.example.customerBooking.CustomerBooking;
import org.example.customers.Customers;
import org.example.customers.CustomersDataStorage;
import org.example.customers.DBCustomersDAO;
import org.example.flight.DBFlightDAO;
import org.example.flight.Flight;
import org.example.flight.FlightAirportDay;
import org.example.flight.FlightsDataStorage;
import org.example.persistence.util.CheckConnection;
import org.example.persistence.util.DAO;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        CheckConnection checkConnection = new CheckConnection();
        checkConnection.checkConnection();

        FlightsDataStorage flightsDataStorage = new FlightsDataStorage();
        flightsDataStorage.addFlightsList();

        CustomersDataStorage customersDataStorage = new CustomersDataStorage();
        customersDataStorage.addCustomersList();

        BookingsDataStorage bookingsDataStorage = new BookingsDataStorage();
        bookingsDataStorage.addBookingsList();

        CustomerBooking customerBooking = new CustomerBooking();
        customerBooking.joinCustomerBooking();

        FlightAirportDay flightAirportDay = new FlightAirportDay();
        flightAirportDay.joinFlightAirport();

        BookingsPerCustomer bookingsPerCustomer = new BookingsPerCustomer();
        bookingsPerCustomer.joinBookingsPerCustomer();


        }
    }

