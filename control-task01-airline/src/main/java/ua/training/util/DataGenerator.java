package ua.training.util;

import ua.training.model.entity.Aircraft;
import ua.training.model.entity.FreighterAircraft;
import ua.training.model.entity.PassengerAircraft;
import ua.training.model.entity.PassengerClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataGenerator {

    public static List<Aircraft> getInitialData() {
        List<Aircraft> aircrafts = new ArrayList<>();

        FreighterAircraft mriya = new FreighterAircraft("Antonov", "An-225 Mriya", 4000.00,
                31.00, 250000.00, 1000.00, 45);

        FreighterAircraft ruslan = new FreighterAircraft("Antonov", "An-124 Ruslan", 4800.00,
                28, 120000.00, 900.00, 36);

        FreighterAircraft boeing737 = new FreighterAircraft("Boeing ", "Boeing 737", 4300.00,
                3.9, 15000.00, 100.00, 22);

        Map<PassengerClass, Integer> airbusA320SeatsByClass = new HashMap<>();
        airbusA320SeatsByClass.put(PassengerClass.BUSINESS, 12);
        airbusA320SeatsByClass.put(PassengerClass.ECONOMY, 120);
        PassengerAircraft airbusA320 = new PassengerAircraft("Airbus", "Airbus A320", 6125.00,
                3.20, 2000.00, airbusA320SeatsByClass);

        Map<PassengerClass, Integer> boeing737_700SeatsByClass = new HashMap<>();
        boeing737_700SeatsByClass.put(PassengerClass.BUSINESS, 0);
        boeing737_700SeatsByClass.put(PassengerClass.ECONOMY, 140);
        PassengerAircraft boeing737_700 = new PassengerAircraft("Boeing", "Boeing 737-700", 6230.00,
                3.30, 2400.00, boeing737_700SeatsByClass);

        Map<PassengerClass, Integer> boeing777SeatsByClass = new HashMap<>();
        boeing777SeatsByClass.put(PassengerClass.BUSINESS, 87);
        boeing777SeatsByClass.put(PassengerClass.ECONOMY, 148);
        PassengerAircraft boeing777 = new PassengerAircraft("Boeing", "Boeing 777", 10300.00,
                12.30, 20000.00, boeing777SeatsByClass);

        aircrafts.add(mriya);
        aircrafts.add(ruslan);
        aircrafts.add(boeing737);
        aircrafts.add(airbusA320);
        aircrafts.add(boeing737_700);
        aircrafts.add(boeing777);

        return aircrafts;
    }
}
