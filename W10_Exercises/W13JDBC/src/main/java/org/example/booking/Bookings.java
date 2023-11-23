package org.example.booking;

import java.util.Date;

public class Bookings {
private int BookingID;

    public Bookings(int bookingID, int customerID, int flightID, Date bookingDate, int numberOfPassengers, String status) {
        BookingID = bookingID;
        CustomerID = customerID;
        FlightID = flightID;
        BookingDate = bookingDate;
        NumberOfPassengers = numberOfPassengers;
        Status = status;
    }

    public int getBookingID() {
        return BookingID;
    }

    public void setBookingID(int bookingID) {
        BookingID = bookingID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public int getFlightID() {
        return FlightID;
    }

    public void setFlightID(int flightID) {
        FlightID = flightID;
    }

    public java.sql.Date getBookingDate() {
        return (java.sql.Date) BookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        BookingDate = bookingDate;
    }

    public int getNumberOfPassengers() {
        return NumberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        NumberOfPassengers = numberOfPassengers;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    private int CustomerID;
private int FlightID;
private Date BookingDate;
private int NumberOfPassengers;
private String Status;

}
