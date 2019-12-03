package ua.training.util;

import ua.training.model.entity.FreighterAircraft;
import ua.training.model.entity.PassengerAircraft;
import ua.training.model.entity.PassengerClass;

import java.util.HashMap;
import java.util.Map;

public class DataGenerator {

    public void getData() {
        FreighterAircraft mriya = new FreighterAircraft("Antonov", "An-225 Mriya", 11111.00,
                111, 250000.00, 1000.00, 11);

        FreighterAircraft ruslan = new FreighterAircraft("Antonov", "An-124 Ruslan", 22222.00,
                222, 120000.00, 900.00, 22);

        FreighterAircraft boeing737 = new FreighterAircraft("Boeing ", "Boeing 737", 33333.00,
                333, 15000.00, 100.00, 44);

        Map<PassengerClass, Integer> airbusA320SeatsByClass = new HashMap<>();
        airbusA320SeatsByClass.put(PassengerClass.BUSINESS, 12);
        airbusA320SeatsByClass.put(PassengerClass.ECONOMY, 120);
        PassengerAircraft airbusA320 = new PassengerAircraft("Airbus", "Airbus A320", 3717.00,
                44.00, 2000.00, airbusA320SeatsByClass);

        Map<PassengerClass, Integer> boeing737_700SeatsByClass = new HashMap<>();
        airbusA320SeatsByClass.put(PassengerClass.BUSINESS, 0);
        airbusA320SeatsByClass.put(PassengerClass.ECONOMY, 140);
        PassengerAircraft boeing737_700 = new PassengerAircraft("Boeing", "Boeing 737-700", 2518.00,
                55.00, 2400.00, boeing737_700SeatsByClass);

        Map<PassengerClass, Integer> boeing777SeatsByClass = new HashMap<>();
        airbusA320SeatsByClass.put(PassengerClass.BUSINESS, 87);
        airbusA320SeatsByClass.put(PassengerClass.ECONOMY, 148);
        PassengerAircraft boeing777 = new PassengerAircraft("Boeing", "Boeing 777", 7406.00,
                66.00, 20000.00, boeing777SeatsByClass);
    }
}
