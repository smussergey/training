package util;

import model.entity.Aircraft;
import model.entity.FreighterAircraftImpl;
import model.entity.PassengerAircraftImpl;
import model.entity.PassengerClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataGenerator {

    public static List<Aircraft> getInitialDataEn() {
        List<Aircraft> aircrafts = new ArrayList<>();

        FreighterAircraftImpl mriya = new FreighterAircraftImpl("Antonov", "An-225 Mriya", 4000,
                31.00, 250000, 1000, 45);

        FreighterAircraftImpl ruslan = new FreighterAircraftImpl("Antonov", "An-124 Ruslan", 4800,
                28, 120000, 900, 36);

        FreighterAircraftImpl boeing737 = new FreighterAircraftImpl("Boeing", "Boeing 737-200С", 4300,
                3.9, 15000, 100, 22);

        Map<PassengerClass, Integer> boeing777SeatsByClass = new HashMap<>();
        boeing777SeatsByClass.put(PassengerClass.BUSINESS, 87);
        boeing777SeatsByClass.put(PassengerClass.ECONOMY, 148);
        PassengerAircraftImpl boeing777 = new PassengerAircraftImpl("Boeing", "Boeing 777", 10300,
                12.30, 20000, boeing777SeatsByClass);

        Map<PassengerClass, Integer> airbusA320SeatsByClass = new HashMap<>();
        airbusA320SeatsByClass.put(PassengerClass.BUSINESS, 12);
        airbusA320SeatsByClass.put(PassengerClass.ECONOMY, 120);
        PassengerAircraftImpl airbusA320 = new PassengerAircraftImpl("Airbus", "Airbus A320", 6125,
                3.20, 2000, airbusA320SeatsByClass);

        Map<PassengerClass, Integer> boeing737_700SeatsByClass = new HashMap<>();
        boeing737_700SeatsByClass.put(PassengerClass.BUSINESS, 0);
        boeing737_700SeatsByClass.put(PassengerClass.ECONOMY, 140);
        PassengerAircraftImpl boeing737_700 = new PassengerAircraftImpl("Boeing", "Boeing 737-700", 6230,
                3.30, 2400, boeing737_700SeatsByClass);

        aircrafts.add(mriya);
        aircrafts.add(ruslan);
        aircrafts.add(boeing737);
        aircrafts.add(boeing777);
        aircrafts.add(airbusA320);
        aircrafts.add(boeing737_700);

        return aircrafts;
    }

    public static List<Aircraft> getInitialDataUa() {
        List<Aircraft> aircrafts = new ArrayList<>();

        FreighterAircraftImpl mriya = new FreighterAircraftImpl("Антонов", "Ан-225 Мрія", 4000,
                31.00, 250000, 1000, 45);

        FreighterAircraftImpl ruslan = new FreighterAircraftImpl("Антонов", "Ан-124 Руслан", 4800,
                28, 120000, 900, 36);

        FreighterAircraftImpl boeing737 = new FreighterAircraftImpl("Боїнг", "Боїнг 737-200С", 4300,
                3.9, 15000, 100, 22);

        Map<PassengerClass, Integer> boeing777SeatsByClass = new HashMap<>();
        boeing777SeatsByClass.put(PassengerClass.BUSINESS, 87);
        boeing777SeatsByClass.put(PassengerClass.ECONOMY, 148);
        PassengerAircraftImpl boeing777 = new PassengerAircraftImpl("Боїнг", "Боїнг 777", 10300,
                12.30, 20000, boeing777SeatsByClass);

        Map<PassengerClass, Integer> airbusA320SeatsByClass = new HashMap<>();
        airbusA320SeatsByClass.put(PassengerClass.BUSINESS, 12);
        airbusA320SeatsByClass.put(PassengerClass.ECONOMY, 120);
        PassengerAircraftImpl airbusA320 = new PassengerAircraftImpl("Аербас", "Аербас A320", 6125,
                3.20, 2000, airbusA320SeatsByClass);

        Map<PassengerClass, Integer> boeing737_700SeatsByClass = new HashMap<>();
        boeing737_700SeatsByClass.put(PassengerClass.BUSINESS, 0);
        boeing737_700SeatsByClass.put(PassengerClass.ECONOMY, 140);
        PassengerAircraftImpl boeing737_700 = new PassengerAircraftImpl("Боїнг", "Боїнг 737-700", 6230,
                3.30, 2400, boeing737_700SeatsByClass);

        aircrafts.add(mriya);
        aircrafts.add(ruslan);
        aircrafts.add(boeing737);
        aircrafts.add(boeing777);
        aircrafts.add(airbusA320);
        aircrafts.add(boeing737_700);

        return aircrafts;
    }
}
