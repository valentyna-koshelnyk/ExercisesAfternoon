package org.example.flight;

import java.util.List;

public interface FlightDAO {
    List<Flight> findall();
    Flight findById(int id);
    void add(Flight flight);
    void update(Flight flight);
    void deleteById(int id);

}
