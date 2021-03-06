package ua.training.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.training.model.entity.Aircraft;
import ua.training.model.entity.FreighterAircraft;
import ua.training.model.entity.PassengerAircraft;
import ua.training.model.entity.PassengerClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AirlineTest {
    private Airline airline = new Airline();

    @Before
    public void setUp() {
        List<Aircraft> aircrafts = new ArrayList<>();

        FreighterAircraft mriya = new FreighterAircraft("Antonov", "An-225 Mriya", 4000,
                31.00, 250000, 1000, 45);

        Map<PassengerClass, Integer> boeing777SeatsByClass = new HashMap<>();
        boeing777SeatsByClass.put(PassengerClass.BUSINESS, 87);
        boeing777SeatsByClass.put(PassengerClass.ECONOMY, 148);
        PassengerAircraft boeing777 = new PassengerAircraft("Boeing", "Boeing 777", 10300,
                12.30, 20000, boeing777SeatsByClass);

        Map<PassengerClass, Integer> airbusA320SeatsByClass = new HashMap<>();
        airbusA320SeatsByClass.put(PassengerClass.BUSINESS, 12);
        airbusA320SeatsByClass.put(PassengerClass.ECONOMY, 120);
        PassengerAircraft airbusA320 = new PassengerAircraft("Airbus", "Airbus A320", 6125,
                3.20, 2000, airbusA320SeatsByClass);


        aircrafts.add(mriya);
        aircrafts.add(boeing777);
        aircrafts.add(airbusA320);

        airline.setAircrafts(aircrafts);
    }

    @Test
    public void testGetTotalSeatingCapacity() {
        Assert.assertEquals(412, airline.getTotalSeatingCapacity(airline.getAircrafts()));
    }

    @Test
    public void testGetTotalCargoCapacityInKg() {
        Assert.assertEquals(272000, airline.getTotalCargoCapacityInKg(airline.getAircrafts()));
    }

    @Test
    public void testSortAircraftsByMaximumRangeInKm() {
        List<Aircraft> sortedAircrafts = airline.SortAircraftsByMaximumRangeInKm(airline.getAircrafts());

        for (int i = 0; i < sortedAircrafts.size() - 1; i++) {
            Assert.assertTrue(sortedAircrafts.get(i).getMaximumRangeInKm() <= sortedAircrafts.get(i + 1).getMaximumRangeInKm());
        }
    }

    @Test
    public void testFindAircraftByAverageFuelConsumptionLiterPerKmInclusively() {
        List<Aircraft> aircraftsToProcess = airline.getAircrafts();
        List<Aircraft> aircrafts = airline.findAircraftsByFuelConsumptionInLitersPer1Kilometre(aircraftsToProcess, 5.00, 15.00);
        Assert.assertEquals(1, aircrafts.size());
        Assert.assertTrue(aircrafts.get(0).getModel().equals("Boeing 777"));
    }
}