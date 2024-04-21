package main.java.repositories;

import main.java.model.Passenger;

import java.util.ArrayList;
import java.util.List;

public class InMemoryPassengerRepository implements Repository<Passenger>{
    private final List<Passenger> passengers;

    public InMemoryPassengerRepository() {
        this.passengers = new ArrayList<>();
    }

    public void add(Passenger passenger) {
        passengers.add(passenger);
    }

    public List<Passenger> getAll() {
        return passengers;
    }
}
