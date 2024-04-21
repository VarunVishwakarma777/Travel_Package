package main.java.repositories;

import main.java.model.Destination;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDestinationRepository implements Repository<Destination>{
    private final List<Destination> destinations;

    public InMemoryDestinationRepository() {
        this.destinations = new ArrayList<>();
    }

    @Override
    public void add(Destination destination) {
        destinations.add(destination);
    }

    @Override
    public List<Destination> getAll() {
        return destinations;
    }
}
