package main.java.service;

import main.java.model.Destination;
import main.java.model.Passenger;
import main.java.model.TravelPackage;
import main.java.repositories.Repository;

import java.util.List;

public class TravelPackageService implements Printable {

   private final Repository travelPackageRepository;

   public TravelPackageService(Repository travelPackageRepository)
   {
       this.travelPackageRepository=travelPackageRepository;
   }


    public void addTravelPackage(TravelPackage travelPackage) {
       travelPackageRepository.add(travelPackage);
    }

    public List<TravelPackage> getAllTravelPackages() {
        return travelPackageRepository.getAll();
    }

    public void addPassengerToTravelPackage(TravelPackage travelPackage, Passenger passenger) {
        if (travelPackage.getPassengers().size() < travelPackage.getPassengerCapacity()) {
            travelPackage.addPassenger(passenger);
           // travelPackageRepository.add(travelPackage);
        } else {
            System.out.println("Travel package is full. Cannot add more passengers.");
        }
    }
    @Override
    public void printDetails() {
       List<TravelPackage> travelPackages=travelPackageRepository.getAll();
        for (TravelPackage travelPackage : travelPackages) {
            travelPackage.printDetails();
        }
    }

    public void printItineraryforTravelPackage(){
        List<TravelPackage> travelPackages=travelPackageRepository.getAll();

        for (TravelPackage travelPackage : travelPackages) {
          List<Destination> itinerary= travelPackage.getItinerary();
            for(Destination d: itinerary)
            {System.out.println("Travel Package= "+travelPackage.getPackageName());
                d.printDetails();
            }
        }
    }

}
