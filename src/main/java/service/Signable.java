package main.java.service;

import main.java.model.Activity;
import main.java.model.Passenger;

public interface Signable {

    void signUpForActivity(Passenger passenger,Activity activity);
}
