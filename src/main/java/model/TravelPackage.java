package main.java.model;

import java.util.ArrayList;
import java.util.List;

public class TravelPackage implements Printable {

    private String packageName;

    private int passengerCapacity;

    private List<Destination> itinerary;

    private List<Passenger> passengers;


    public  TravelPackage(String packageName, int passengerCapacity,List<Destination> itinerary)
    {
        this.packageName=packageName;
        this.passengerCapacity=passengerCapacity;
        this.itinerary=itinerary;
        this.passengers=new ArrayList<>();
    }

    public String getPackageName() {
        return packageName;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public List<Destination> getItinerary() {
        return itinerary;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void addPassenger(Passenger passenger)
    {
        passengers.add(passenger);
    }

    @Override
    public void printDetails() {
        System.out.println("Travel Package: " + packageName);
        System.out.println("Passenger Capacity: " + passengerCapacity);
        System.out.println("No of Passengers: "+passengers.size());

        for(Passenger p: passengers)
        {
            System.out.println("Passenger name="+p.getPassengerName());
            System.out.println("Passenger number="+p.getPassengerNumber());
        }
    }


}
