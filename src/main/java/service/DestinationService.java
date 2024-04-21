package main.java.service;

import main.java.model.Destination;
import main.java.repositories.Repository;

import java.util.List;

public class DestinationService implements Printable {

    private final Repository destinationRepository;

    public DestinationService(Repository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    public void addDestination(Destination destination) {
       destinationRepository.add(destination);
    }

    public List<Destination> getAllDestinations() {
        return destinationRepository.getAll();
    }

    @Override
    public void printDetails() {
        List<Destination> destinations=destinationRepository.getAll();
        for (Destination destination : destinations) {
            destination.printDetails();
        }
    }

}
