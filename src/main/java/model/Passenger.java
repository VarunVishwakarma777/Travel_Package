package main.java.model;

import main.java.service.Printable;

import java.util.ArrayList;
import java.util.List;

public class Passenger implements Printable {

    private String passengerName;

    private int passengerNumber;

    private PassengerType passengerType;

    private double balance;

    private List<Activity> signedUpActivities;

    public Passenger(String passengerName, int passengerNumber, PassengerType passengerType, double balance) {
        this.passengerName = passengerName;
        this.passengerNumber = passengerNumber;
        this.passengerType = passengerType;
        this.balance = balance;
        this.signedUpActivities = new ArrayList<>();
    }

    public String getPassengerName() {
        return passengerName;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public double getBalance() {
        return balance;
    }

    public List<Activity> getSignedUpActivities() {
        return signedUpActivities;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addActivityToSignedUpActivities(Activity activity) {
        signedUpActivities.add(activity);
    }

    @Override
    public void printDetails() {

        System.out.println("Passenger: " + passengerName);
        System.out.println("Passenger Number: " + passengerNumber);
        System.out.println("Passenger Type: " + passengerType);
        if (passengerType != PassengerType.PREMIUM) {
            System.out.println("Balance: " + balance);
        }
        System.out.println("Signed Up Activities:");
        for (Activity activity : signedUpActivities) {
            activity.printDetails();
        }
    }



}
