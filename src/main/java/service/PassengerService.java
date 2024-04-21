package main.java.service;

import main.java.model.Activity;
import main.java.model.Passenger;
import main.java.model.PassengerType;
import main.java.repositories.Repository;

import java.util.List;

public class PassengerService implements Signable,Printable {

    private final Repository passengerRepository;

    public PassengerService(Repository passengerRepository)
    {
        this.passengerRepository=passengerRepository;
    }

    public void addPassenger(Passenger passenger) {
       passengerRepository.add(passenger);
    }

    public List<Passenger> getAllPassengers() {
        return passengerRepository.getAll();
    }


    @Override
    public void printDetails() {
        List<Passenger> passengers=passengerRepository.getAll();
        for (Passenger passenger : passengers) {
            passenger.printDetails();
        }
    }
    public void signUpForActivity(Passenger passenger,Activity activity) {
        if (activity.getCapacity() > 0) {
            if (passenger.getPassengerType() == PassengerType.STANDARD) {
                if (passenger.getBalance() >= activity.getCost()) {
                  //  balance -= activity.getCost();
                    passenger.setBalance(passenger.getBalance()-activity.getCost());
                   // signedUpActivities.add(activity);
                    passenger.addActivityToSignedUpActivities(activity);

                    activity.reduceCapacity();
                } else {
                    System.out.println("Insufficient balance to sign up for activity.");
                }
            } else if (passenger.getPassengerType()  == PassengerType.GOLD) {
                double discountedCost = 0.9 * activity.getCost();
                if (passenger.getBalance() >= discountedCost) {
                    //balance -= discountedCost;
                    passenger.setBalance(passenger.getBalance()-discountedCost);
                   // signedUpActivities.add(activity);
                    passenger.addActivityToSignedUpActivities(activity);
                    activity.reduceCapacity();
                } else {
                    System.out.println("Insufficient balance to sign up for activity.");
                }
            } else if (passenger.getPassengerType() == PassengerType.PREMIUM) {
                //signedUpActivities.add(activity);
                passenger.addActivityToSignedUpActivities(activity);
                activity.reduceCapacity();
            }
        } else {
            System.out.println("Activity is already full. Cannot sign up.");
        }
    }


}
