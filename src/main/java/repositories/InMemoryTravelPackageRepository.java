package main.java.repositories;
import main.java.model.TravelPackage;

import java.util.ArrayList;
import java.util.List;
public class InMemoryTravelPackageRepository implements Repository<TravelPackage> {
    private final List<TravelPackage> travelPackages;

    public InMemoryTravelPackageRepository() {
        this.travelPackages = new ArrayList<>();
    }



    public void add(TravelPackage travelPackage) {
        travelPackages.add(travelPackage);
    }

    public List<TravelPackage> getAll() {
        return travelPackages;
    }



}
