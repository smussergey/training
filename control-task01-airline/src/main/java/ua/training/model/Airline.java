package ua.training.model;

import ua.training.model.entity.Aircraft;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Airline {
    private List<Aircraft> aircrafts;

    public Airline(List<Aircraft> aircrafts) {
        this.aircrafts = aircrafts;
    }

    public int getTotalSeatingCapacity(List<Aircraft> aircraftList) {
        int totalSeatingCapacity = 0;

        for (Aircraft aircraft : aircraftList) {
            totalSeatingCapacity = totalSeatingCapacity + aircraft.getSeatingCapacity();
        }
        return totalSeatingCapacity;
    }

    public int getTotalCargoCapacityInKg(List<Aircraft> aircraftList) {
        int totalCargoCapacityInKg = 0;

        for (Aircraft aircraft : aircraftList) {
            totalCargoCapacityInKg = totalCargoCapacityInKg + aircraft.getCargoCapacityInKilo();
        }
        return totalCargoCapacityInKg;
    }

    public List<Aircraft> SortAircraftsByMaximumRangeInKm(List<Aircraft> aircraftList) {
        return aircraftList
                .stream()
                .sorted(Comparator.comparing(Aircraft::getMaximumRangeInKm))
                .collect(Collectors.toList());
    }

    public List<Aircraft> findAircraftsByAverageFuelConsumptionLiterPerKmInclusively(List<Aircraft> aircraftList, double min, double max) {
        List<Aircraft> result = new ArrayList<>();

        for (Aircraft aircraft : aircraftList) {
            if (aircraft.getFuelConsumptionInLiterPerKm() >= min
                    && aircraft.getFuelConsumptionInLiterPerKm() <= max) {
                result.add(aircraft);
            }
        }
        return result;
    }

    public List<Aircraft> getAircrafts() {
        return aircrafts;
    }
}
