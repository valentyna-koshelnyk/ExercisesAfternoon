package org.example.flight;

import java.util.List;

public class DBFlightDAO implements FlightDAO{
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/ATReservation";
    private static final String SELECT_ALL = "SELECT * FROM Flight";
    private static final String SELECT = "SELECT * FROM Flight WHERE id = %d";
    private static final String INSERT_DATA = "INSERT INTO Flight VALUES (%d , '%s', '%s', )";




    @Override
    public List<Flight> findall() {
        return null;
    }

    @Override
    public Flight findById(int id) {
        return null;
    }

    @Override
    public void add(Flight flight) {

    }

    @Override
    public void update(Flight flight) {

    }

    @Override
    public void deleteById(int id) {

    }
}
