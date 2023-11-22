package org.example.persistence.util;

import org.example.flight.Flight;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbClient {
    private final DataSource dataSource;

    public DbClient(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public void run(String str){
        try (Connection con = dataSource.getConnection();
        Statement statement = con.createStatement()) {
            statement.executeUpdate(str);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Flight select(String query) {
        List<Flight> flights = selectForList(query);
        if (flights.size() == 1) {
            return flights.get(0);
        } else if (flights.size() == 0) {
            return null;
        } else {
            throw new IllegalStateException("Query returned more than one object");
        }
    }

    public List<Flight> selectForList(String query) {
        List<Flight> flights = new ArrayList<>();

        try (Connection con = dataSource.getConnection();
             Statement statement = con.createStatement();
             ResultSet resultSetFlight = statement.executeQuery(query)) {
            while (resultSetFlight.next()) {
                int FlightId = resultSetFlight.getInt("FlightId");
                String Airline = resultSetFlight.getString("Airline");
                String Origin = resultSetFlight.getString("Origin");
                String Destination = resultSetFlight.getString("Destination");
                Timestamp DepartureTime = resultSetFlight.getTimestamp("DepartureTime");
                Timestamp ArrivalTime = resultSetFlight.getTimestamp("ArrivalTime");
                double Price = resultSetFlight.getDouble("Price");
                int SeatsAvailable = resultSetFlight.getInt("SeatsAvailable");
                Flight flight = new Flight(FlightId, Airline, Origin, Destination, DepartureTime, ArrivalTime, Price, SeatsAvailable);
                flights.add(flight);
            }
            return flights;
        }
    }

    }
}
