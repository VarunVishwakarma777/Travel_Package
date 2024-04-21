package test.java;

import main.java.model.Activity;
import main.java.model.Destination;
import main.java.repositories.InMemoryActivityRepository;
import main.java.repositories.InMemoryDestinationRepository;
import main.java.repositories.InMemoryPassengerRepository;
import main.java.repositories.Repository;
import main.java.service.ActivityService;
import main.java.service.DestinationService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DestinationTest {
    @Test
   public void testAddActivity() {
        final Repository destinationRepository = new InMemoryDestinationRepository();
        //Arrange
        Activity activity = new Activity("Test Activity", "Description", 20.0, 10);
        List<Activity> activities=new ArrayList<>();
        activities.add(activity);
        Destination destination = new Destination("Test Destination", activities);
        //Act
        DestinationService destinationService=new DestinationService(destinationRepository);
        destinationService.addDestination(destination);
        //Assert
        assertEquals(1, destination.getActivities().size());
    }
}
