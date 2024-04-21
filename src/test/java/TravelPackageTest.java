package test.java;

import main.java.model.Passenger;
import main.java.model.PassengerType;
import main.java.model.TravelPackage;
import main.java.repositories.InMemoryTravelPackageRepository;
import main.java.repositories.Repository;
import main.java.service.TravelPackageService;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TravelPackageTest {

    @Test
   public void testAddPassenger() {
        final Repository travelPackageRepository = new InMemoryTravelPackageRepository();

        //Arrange
        TravelPackage travelPackage = new TravelPackage("Test Package", 5, null);
        Passenger passenger = new Passenger("John Doe", 1, PassengerType.STANDARD, 100.0);
        //Act
        TravelPackageService travelPackageService=new TravelPackageService(travelPackageRepository);
        travelPackageService.addPassengerToTravelPackage( travelPackage,passenger);
        //Assert
        assertEquals(1, travelPackage.getPassengers().size());
    }
}
