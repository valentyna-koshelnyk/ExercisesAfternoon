package org.example.flight;

import org.example.Main;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class FlightAirportDay {

//    private final static String FLIGHT_AIRPORT = "SELECT Flight.Origin, Flight.DepartureTime " +
//            " COUNT(Flight.Origin) AS n_flights_airport " +
//            " FROM Flight " +
//            " GROUP BY Flight.Origin " +
//            " ORDER BY n_flights_airport ";
private final static String FLIGHT_AIRPORT = "SELECT Origin, COUNT(FlightId) AS n_flights_airport " +
        "FROM Flight " +
        "GROUP BY Origin " +
        "ORDER BY COUNT(FlightId) DESC";
    public void joinFlightAirport(){
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
            try (PreparedStatement preparedStatement = conn.prepareStatement(FLIGHT_AIRPORT)) {
                try (ResultSet rs = preparedStatement.executeQuery()) {
                    while (rs.next()) {
                        String Origin = rs.getString("Origin");
                        int n_flights_airport = rs.getInt("n_flights_airport");
                        System.out.println("Origin: " + Origin + "Number of Flights per Airport: " + n_flights_airport);
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


