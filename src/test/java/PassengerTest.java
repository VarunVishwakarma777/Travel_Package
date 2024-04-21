package test.java;
import main.java.model.Activity;
import main.java.model.Passenger;
import main.java.model.PassengerType;
import main.java.repositories.InMemoryPassengerRepository;
import main.java.repositories.Repository;
import main.java.service.PassengerService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class PassengerTest {
    @Test
   public void testSignUpForActivity() {
        final Repository passengerRepository         = new InMemoryPassengerRepository();
        PassengerService passengerService=new PassengerService(passengerRepository);
        //Arrange
        Passenger passenger = new Passenger("John Doe", 1, PassengerType.STANDARD, 100.0);
        Activity activity = new Activity("Test Activity", "Description", 20.0, 5);
        //Act
        passengerService.signUpForActivity(passenger,activity);
        //Assert
        assertEquals(1, passenger.getSignedUpActivities().size());
    }
}
