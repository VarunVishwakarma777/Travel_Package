package test.java;

import main.java.model.Activity;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ActivityTest {
    @Test
    public void testReduceCapacity() {
        //Arrange
        Activity activity = new Activity("Test Activity", "Description", 20.0, 5);

        //Act
        activity.reduceCapacity();
        activity.reduceCapacity();
        //Assert
        assertEquals(3, activity.getCapacity());
    }
}
