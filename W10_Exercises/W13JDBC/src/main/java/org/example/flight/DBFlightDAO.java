package org.example.flight;

import org.example.Main;
import org.example.persistence.util.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class DBFlightDAO implements DAO<Flight> {

    private static final String CREATE_DB = "CREATE TABLE IF NOT EXISTS FLIGHT(" +
            "FlightID INT PRIMARY KEY," +
            "Airline VARCHAR(50) NOT NULL," +
            "Origin VARCHAR(50) NOT NULL," +
            "Destination VARCHAR(50) NOT NULL," +
            "DepartureTime VARCHAR(50) NOT NULL," +
            "ArrivalTime VARCHAR(50) NOT NULL," +
            "Price DECIMAL(10,2) NOT NULL," +
            "SeatsAvailable INT" +
            ");";

    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/ATReservation";
    private static final String SELECT_ALL = "SELECT * FROM Flight";
    private static final String SELECT = "SELECT * FROM Flight WHERE id = %d";
    private static final String INSERT_DATA = "INSERT INTO Flight VALUES (?,?,?,?,?,?,?,?)";

    private static final String UPDATE_DATA = "UPDATE FLIGHT SET " +
            "Airline = ?, Origin = ?, Destination = ?, " +
            "DepartureTime = ?, ArrivalTime = ?, Price = ?, SeatsAvailable = ? " +
            "WHERE FlightID = ?";

    private static final String DELETE_DATA = "DELETE FROM FLIGHT WHERE FlightID = ?";

    private final DbClient dbClient;
    private final Connection connection;

    public DBFlightDAO() {
        Properties prop = new Properties();
        try (InputStream input = Main.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                throw new RuntimeException("Missing config.properties");
            }
            // Load a properties file from classpath
            prop.load(input);
            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.username");
            String password = prop.getProperty("db.password");

            this.connection = DriverManager.getConnection(url, user, password);
            this.dbClient = new DbClient(connection);
            dbClient.run(CREATE_DB);
            System.out.println("Flights data structure created");
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
        @Override
    public List<Flight> findall() {
        return dbClient.selectForFlightList(SELECT_ALL);
    }
    @Override
    public Flight findById(int id) {
        Flight flight = dbClient.select(String.format(SELECT, id));

        if (flight != null) {
            System.out.println("Flight: Id " + id + ", found");
            return flight;
        } else {
            System.out.println("Flight: Id " + id + ", not found");
            return null;
        }
    }
//    FlightID = flightID;
//    Airline = airline;
//    Origin = origin;
//    Destination = destination;
//    DepartureTime = departureTime;
//    ArrivalTime = arrivalTime;
//    Price = price;
//    SeatsAvailable = seatsAvailable;

    @Override
    public void add(Flight flight) {
        if (dbClient != null) {
            String insertQuery = "INSERT INTO Flight VALUES (?,?,?,?,?,?,?,?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, flight.getFlightID());
                preparedStatement.setString(2, flight.getAirline());
                preparedStatement.setString(3, flight.getOrigin());
                preparedStatement.setString(4, flight.getDestination());
                preparedStatement.setString(5, flight.getDepartureTime());
                preparedStatement.setString(6, flight.getArrivalTime());
                preparedStatement.setBigDecimal(7, BigDecimal.valueOf(flight.getPrice()));
                preparedStatement.setInt(8, flight.getSeatsAvailable());

                preparedStatement.executeUpdate();

                System.out.println("Flight added successfully");
            } catch (SQLException e) {
                throw new RuntimeException("Error executing SQL query", e);
            }
        } else {
            System.out.println("DbClient is null. Check initialization.");
        }
    }
    @Override
    public void update(Flight flight) {
        dbClient.run(String.format(UPDATE_DATA,
                flight.getFlightID(),
                flight.getAirline(), flight.getOrigin(), flight.getDestination(),
                flight.getDepartureTime(), flight.getArrivalTime(),
                flight.getPrice(), flight.getSeatsAvailable()));
        System.out.println("Flight updated");
    }

    @Override
    public void deleteById(int id) {
        dbClient.run(String.format(DELETE_DATA, id));
        System.out.println("Flight: Id " + id + " , deleted");
    }
}
