package org.example.flight;

import org.example.persistence.util.DAO;

import java.util.ArrayList;
import java.util.List;

public class FlightsDataStorage {    public void addFlightsList(){
    DAO flightDAO = new DBFlightDAO();

    List<Flight> flights = generateFlights();

    for (Flight flight : flights) {
        flightDAO.add(flight);
    }
}


    public List<Flight> generateFlights(){
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight(27, "MAU", "Odesa", "Berlin",
                "16:05", "18:02", 100.00, 68));
        flights.add(new Flight(1, "Ryanair", "Berlin", "Lissabon",
                "12:00", "15:05", 65.00, 112));
        flights.add(new Flight(2 ,"Lufthansa", "Heathrow Airport", "Los Angeles International Airport", "12:00", "17:30", 500.0, 150));
        flights.add(new Flight(3, "Emirates", "Dubai International Airport", "John F. Kennedy International Airport", "15:45", "22:15", 700.0, 180));
        flights.add(new Flight(4, "British Airways", "Sydney Airport", "Heathrow Airport", "18:30", "04:00", 600.0, 130));
        flights.add(new Flight(5, "Air France", "Charles de Gaulle Airport", "Haneda Airport", "09:15", "14:45", 550.0, 160));
        flights.add(new Flight(24, "Delta Airlines", "Los Angeles International Airport", "Frankfurt Airport", "11:30", "20:00", 650.0, 170));
        flights.add(new Flight(6, "Qatar Airways", "Hamad International Airport", "San Francisco International Airport", "14:20", "23:00", 720.0, 140));
        flights.add(new Flight(7, "Singapore Airlines", "Changi Airport", "Incheon International Airport", "17:10", "01:45", 680.0, 155));
        flights.add(new Flight(8, "Cathay Pacific", "Hong Kong International Airport", "Dallas/Fort Worth International Airport", "20:00", "05:30", 620.0, 165));
        flights.add(new Flight(9, "American Airlines", "Chicago O'Hare International Airport", "Barcelona–El Prat Airport", "10:45", "16:15", 590.0, 145));
        flights.add(new Flight(10, "KLM Royal Dutch Airlines", "Amsterdam Airport Schiphol", "Toronto Pearson International Airport", "13:30", "19:00", 670.0, 155));
        flights.add(new Flight(11, "Turkish Airlines", "Istanbul Airport", "Seattle–Tacoma International Airport", "16:15", "22:45", 630.0, 160));
        flights.add(new Flight(12, "Qantas", "Melbourne Airport", "Abu Dhabi International Airport", "19:00", "03:30", 690.0, 170));
        flights.add(new Flight(13, "Etihad Airways", "Abu Dhabi International Airport", "São Paulo International Airport", "08:30", "14:00", 740.0, 180));
        flights.add(new Flight(14, "Swiss International Air Lines", "Zurich Airport", "Los Angeles International Airport", "11:15", "16:45", 580.0, 135));
        flights.add(new Flight(15, "Finnair", "Helsinki Airport", "Chhatrapati Shivaji Maharaj International Airport", "14:00", "20:30", 660.0, 155));
        flights.add(new Flight(16, "Aeroflot", "Sheremetyevo International Airport", "Jorge Chávez International Airport", "17:45", "23:15", 610.0, 150));
        flights.add(new Flight(17, "China Southern Airlines", "Guangzhou Baiyun International Airport", "Newark Liberty International Airport", "20:30", "02:00", 700.0, 160));
        flights.add(new Flight(18, "Lufthansa", "Munich Airport", "Hong Kong International Airport", "09:00", "15:30", 620.0, 145));
        flights.add(new Flight(19, "Air Canada", "Toronto Pearson International Airport", "Heathrow Airport", "12:30", "18:00", 590.0, 155));
        flights.add(new Flight(20, "Japan Airlines", "Narita International Airport", "Sydney Airport", "15:15", "20:45", 650.0, 165));

        return flights;
    }

}
