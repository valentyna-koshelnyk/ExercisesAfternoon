package org.example.flight;

import java.sql.Timestamp;

public class Flight {
    private int FlightID;
    private String Airline;

    public Flight(int flightID, String airline, String origin, String destination, Timestamp departureTime, Timestamp arrivalTime, double price, int seatsAvailable) {
        FlightID = flightID;
        Airline = airline;
        Origin = origin;
        Destination = destination;
        DepartureTime = departureTime;
        ArrivalTime = arrivalTime;
        Price = price;
        SeatsAvailable = seatsAvailable;
    }

    private String Origin;

    public int getFlightID() {
        return FlightID;
    }

    public void setFlightID(int flightID) {
        FlightID = flightID;
    }

    public String getAirline() {
        return Airline;
    }

    public void setAirline(String airline) {
        Airline = airline;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String origin) {
        Origin = origin;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public Timestamp getDepartureTime() {
        return DepartureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        DepartureTime = departureTime;
    }

    public Timestamp getArrivalTime() {
        return ArrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        ArrivalTime = arrivalTime;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getSeatsAvailable() {
        return SeatsAvailable;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        SeatsAvailable = seatsAvailable;
    }

    private String Destination;
private Timestamp DepartureTime;
private Timestamp ArrivalTime;
private double Price;
private int SeatsAvailable;
}
