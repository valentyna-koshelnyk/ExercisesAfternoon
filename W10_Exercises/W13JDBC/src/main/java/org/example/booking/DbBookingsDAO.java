package org.example.booking;

import org.example.Main;
import org.example.customers.Customers;
import org.example.flight.DbClient;
import org.example.flight.Flight;
import org.example.persistence.util.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class DbBookingsDAO implements DAO<Bookings> {
    private static final String CREATE_DB = "CREATE TABLE IF NOT EXISTS BOOKINGS(" +
            "BookingID INT PRIMARY KEY," +
        	  "CustomerID INT," +
	  "FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)," +
            "FlightID INT," +
	  "FOREIGN KEY (FlightID) REFERENCES Flight(FlightID)," +
            "BookingDate DATETIME," +
	  "NumberOfPassengers INT, " +
	 "Status VARCHAR(50) " +
            ");";

    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/ATReservation";
    private static final String SELECT_ALL = "SELECT * FROM Bookings";
    private static final String SELECT = "SELECT * FROM Bookings WHERE id = %d";
    private static final String INSERT_DATA = "INSERT INTO Bookings VALUES (?,?,?,?,?,?,?,?)";

    private static final String UPDATE_DATA = "UPDATE Bookings SET " +
            "CustomerId = ?, FlightId = ?, BookingDate = ?, " +
            "NumberOfPassengers = ?, Status = ? " +
            "WHERE BookingId = ?";

    private static final String DELETE_DATA = "DELETE FROM Bookings WHERE BookingId = ?";

    private final DbClientBooking dbClient;
    private final Connection connection;

    public DbBookingsDAO() {
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
            this.dbClient = new DbClientBooking(connection);
            dbClient.run(CREATE_DB);
            System.out.println("Bookings data structure created");
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Bookings> findall() {
        return dbClient.selectForBookingsList(SELECT_ALL);
    }

    @Override
    public Bookings findById(int id) {
     //   Bookings bookings = dbClient.select(String.format(SELECT, id));
        Bookings bookings = dbClient.select(String.format(SELECT, id));

        if (bookings != null) {
            System.out.println("Booking: Id " + id + ", found");
            return bookings;
        } else {
            System.out.println("Booking: Id " + id + ", not found");
            return null;
        }
    }


    @Override
    public void add(Bookings bookings) {
        if (dbClient != null) {
            String insertQuery = "INSERT INTO Bookings VALUES (?,?,?,?,?,?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, bookings.getBookingID());
                preparedStatement.setInt(2, bookings.getCustomerID());
                preparedStatement.setInt(3, bookings.getFlightID());
                preparedStatement.setDate(4, bookings.getBookingDate());
                preparedStatement.setInt(5, bookings.getNumberOfPassengers());
                preparedStatement.setString(6, bookings.getStatus());

                preparedStatement.executeUpdate();

                System.out.println("Booking added successfully");
            } catch (SQLException e) {
                throw new RuntimeException("Error executing SQL query", e);
            }
        } else {
            System.out.println("DbClient is null. Check initialization.");
        }
    }


    @Override
    public void update(Bookings bookings) {
        dbClient.run(String.format(UPDATE_DATA,
                bookings.getCustomerID(),
                bookings.getFlightID(), bookings.getBookingDate(), bookings.getNumberOfPassengers(),
                bookings.getStatus()));
        System.out.println("Bookings updated");
    }



    @Override
    public void deleteById(int id) {
        dbClient.run(String.format(DELETE_DATA, id));
        System.out.println("Booking: Id " + id + " , deleted");

    }
}
