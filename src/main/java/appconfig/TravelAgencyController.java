package main.java.appconfig;

import main.java.model.Activity;
import main.java.model.Destination;
import main.java.model.Passenger;
import main.java.model.TravelPackage;
import main.java.service.ActivityService;
import main.java.service.DestinationService;
import main.java.service.PassengerService;
import main.java.service.TravelPackageService;

import java.util.List;

public class TravelAgencyController {
    private final TravelPackageService travelPackageService;
    private final DestinationService destinationService;
    private final ActivityService activityService;
    private final PassengerService passengerService;

    public TravelAgencyController(TravelPackageService travelPackageService, DestinationService destinationService,
                                  ActivityService activityService, PassengerService passengerService) {
        this.travelPackageService = travelPackageService;
        this.destinationService = destinationService;
        this.activityService = activityService;
        this.passengerService = passengerService;
    }



    public List<TravelPackage> getAllTravelPackages() {
        return travelPackageService.getAllTravelPackages();
    }

    public List<Destination> getAllDestinations() {
        return destinationService.getAllDestinations();
    }

    public List<Activity> getAllActivities() {
        return activityService.getAllActivities();
    }

    public List<Passenger> getAllPassengers() {
        return passengerService.getAllPassengers();
    }

    public void addPassengerToTravelPackage(TravelPackage travelPackage, Passenger passenger) {
        if (travelPackage.getPassengers().size() < travelPackage.getPassengerCapacity()) {
            travelPackage.addPassenger(passenger);
        } else {
            System.out.println("Travel package is full. Cannot add more passengers.");
        }
    }
}
