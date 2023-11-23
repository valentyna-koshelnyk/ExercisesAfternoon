package org.example.flight;

public class Flight {
    private int FlightID;
    private String Airline;
    private String Destination;
    private String DepartureTime;
    private String ArrivalTime;
    private double Price;
    private int SeatsAvailable;
    private String Origin;

    public Flight(int flightID, String airline, String origin, String destination, String departureTime, String arrivalTime, double price, int seatsAvailable) {
        FlightID = flightID;
        Airline = airline;
        Origin = origin;
        Destination = destination;
        DepartureTime = departureTime;
        ArrivalTime = arrivalTime;
        Price = price;
        SeatsAvailable = seatsAvailable;
    }


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

    public String getDepartureTime() {
        return DepartureTime;
    }

    public void setDepartureTime(String departureTime) {
        DepartureTime = departureTime;
    }

    public String getArrivalTime() {
        return ArrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
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


}
