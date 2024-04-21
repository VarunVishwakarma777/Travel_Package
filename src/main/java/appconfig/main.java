package main.java.appconfig;


import main.java.model.*;
import main.java.repositories.*;
import main.java.service.ActivityService;
import main.java.service.DestinationService;
import main.java.service.PassengerService;
import main.java.service.TravelPackageService;

import java.util.ArrayList;
import java.util.List;

public class main {


    public static void main(String[] args) {
        // Create repositories
        final Repository travelPackageRepository = new InMemoryTravelPackageRepository();
        final Repository passengerRepository         = new InMemoryPassengerRepository();
        final Repository destinationRepository = new InMemoryDestinationRepository();
        final Repository activityRepository = new InMemoryActivityRepository();

        // Create service instance
        final TravelPackageService travelPackageService=new TravelPackageService(travelPackageRepository);
        final PassengerService passengerService= new PassengerService(passengerRepository);
        final DestinationService destinationService = new DestinationService(destinationRepository);
        final ActivityService activityService = new ActivityService(activityRepository);

        // Create controller
        TravelAgencyController controller = new TravelAgencyController(travelPackageService, destinationService,
                activityService, passengerService);

        // Perform operations using controller methods
        List<TravelPackage> travelPackages = controller.getAllTravelPackages();
        List<Destination> destinations = controller.getAllDestinations();
        List<Activity> activities = controller.getAllActivities();
        List<Passenger> passengers = controller.getAllPassengers();

        // Create activities
        Activity hiking = new Activity("Hiking", "Enjoy a scenic hike", 20.0, 10);
        Activity snorkeling = new Activity("Snorkeling", "Explore underwater life", 30.0, 8);

        activityService.addActivity(hiking);
        activityService.addActivity(snorkeling);

        // Create destinations
        List<Activity> baliActivities = new ArrayList<>();
        baliActivities.add(hiking);
        baliActivities.add(snorkeling);
        Destination bali = new Destination("Bali", baliActivities);

        destinationService.addDestination(bali);

        // Create travel package
        List<Destination> itinerary = new ArrayList<>();
        itinerary.add(bali);
        TravelPackage package1 = new TravelPackage("Relaxing Bali Trip", 20, itinerary);

        travelPackageService.addTravelPackage(package1);
        // Create passengers
        Passenger passenger1 = new Passenger("Tom cruise", 1, PassengerType.STANDARD, 100.0);
        Passenger passenger2 = new Passenger("Chris hemsworth", 2, PassengerType.GOLD, 150.0);

        passengerService.addPassenger(passenger1);
        passengerService.addPassenger(passenger2);

        //Adding Passengers to travel package;
        travelPackageService.addPassengerToTravelPackage(package1,passenger1);
        travelPackageService.addPassengerToTravelPackage(package1,passenger2);


        //Signing Up Paasengers for different activities
        passengerService.signUpForActivity(passenger1,hiking);
        passengerService.signUpForActivity(passenger2,snorkeling);


        // Print details using services
        // printed in same order as given in task
        System.out.println("-1.Print itinerary of the travel package including");
        travelPackageService.printItineraryforTravelPackage();
        System.out.println("-----------------------------------------------------");
        System.out.println("-2.Print the passenger list of the travel package including-details in TASK");
        travelPackageService.printDetails();
        System.out.println("-----------------------------------------------------");
        System.out.println("3.Print the details of an individual passenger including their details given in TASK");
        passengerService.printDetails();
        System.out.println("-----------------------------------------------------");
        activityService.printDetails();
        System.out.println("-----------------------------------------------------");
        destinationService.printDetails();








    }
}
