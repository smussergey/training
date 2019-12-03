package ua.training.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.training.model.entity.Aircraft;
import ua.training.model.entity.FreighterAircraft;
import ua.training.model.entity.PassengerAircraft;
import ua.training.model.entity.PassengerClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class AirlineTest {
    private Airline airline;

    @Before
    public void setUp() {
        List<Aircraft> aircrafts = new ArrayList<>();

        FreighterAircraft mriya = new FreighterAircraft("Antonov", "An-225 Mriya", 4000.00,
                31.00, 250000.00, 1000.00, 45);

        Map<PassengerClass, Integer> airbusA320SeatsByClass = new HashMap<>();
        airbusA320SeatsByClass.put(PassengerClass.BUSINESS, 12);
        airbusA320SeatsByClass.put(PassengerClass.ECONOMY, 120);
        PassengerAircraft airbusA320 = new PassengerAircraft("Airbus", "Airbus A320", 6125.00,
                3.20, 2000.00, airbusA320SeatsByClass);

        Map<PassengerClass, Integer> boeing777SeatsByClass = new HashMap<>();
        boeing777SeatsByClass.put(PassengerClass.BUSINESS, 87);
        boeing777SeatsByClass.put(PassengerClass.ECONOMY, 148);
        PassengerAircraft boeing777 = new PassengerAircraft("Boeing", "Boeing 777", 10300.00,
                12.30, 20000.00, boeing777SeatsByClass);
        System.out.println("from before");

        aircrafts.add(mriya);
        aircrafts.add(airbusA320);
        aircrafts.add(boeing777);

        airline = new Airline("KiyAvia", aircrafts);
    }

    @Test
    public void testGetTotalSeatingCapacity() {
        System.out.println("size =" + airline.aircrafts.size());
        Assert.assertEquals(412, airline.getTotalSeatingCapacity());
    }

    @Test
    public void testGetTotalCargoCapacityInKg() {

    }

    @Test
    public void testSortAircraftsByMaximumRangeInKm() {

    }

    @Test
    public void testFindAircraftByAverageFuelConsumptionLiterPerKm() {

    }
}