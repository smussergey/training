package ua.training.model;

import ua.training.model.entity.Aircraft;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Airline {
    private String name;
    private List<Aircraft> aircrafts;

    public Airline(String name, List<Aircraft> aircrafts) {
        this.name = name;
        this.aircrafts = aircrafts;
    }

    public int getTotalSeatingCapacity() {
        int totalSeatingCapacity = 0;

        for (Aircraft aircraft : this.aircrafts) {
            totalSeatingCapacity = totalSeatingCapacity + aircraft.getSeatingCapacity();
        }
        return totalSeatingCapacity;
    }

    public int getTotalCargoCapacityInKg() {
        int totalCargoCapacityInKg = 0;

        for (Aircraft aircraft : this.aircrafts) {
            totalCargoCapacityInKg = totalCargoCapacityInKg + aircraft.getCargoCapacityInKilo();
        }
        return totalCargoCapacityInKg;
    }

    public List<Aircraft> SortAircraftsByMaximumRangeInKm() {
        return this.aircrafts
                .stream()
                .sorted(Comparator.comparing(Aircraft::getMaximumRangeInKm))
                .collect(Collectors.toList());
    }

    public List<Aircraft> findAircraftByAverageFuelConsumptionLiterPerKm(double min, double max) {
        List<Aircraft> result = new ArrayList<>();

        for (Aircraft aircraft : this.aircrafts) {
            if (aircraft.getAverageFuelConsumptionInLiterPerKm() >= min
                    && aircraft.getAverageFuelConsumptionInLiterPerKm() <= max) {
                result.add(aircraft);
            }
        }
        return result;
    }

    public List<Aircraft> getAircrafts() {
        return aircrafts;
    }
}
