/*
 *This program is developed for educational purposes.
 */

package ua.training.model;

import ua.training.model.entity.Aircraft;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class contains information about airline company, its aircrafts and
 * actions which can be applied to them
 *
 * @author Sergey Smus
 * @version 1.01 05 December 2019
 */
public class Airline {
    /**
     * It is a list of all aircrafts, which belong to airline
     */
    private List<Aircraft> aircrafts;

    /**
     * This method calculates total seating capacity of a given aircrafts
     *
     * @param aircraftList the list of aircrafts to calculate total seating capacity
     * @return total seating capacity of all aircrafts in the given list
     */
    public int getTotalSeatingCapacity(List<Aircraft> aircraftList) {
        int totalSeatingCapacity = 0;

        for (Aircraft aircraft : aircraftList) {
            totalSeatingCapacity = totalSeatingCapacity + aircraft.getSeatingCapacity();
        }
        return totalSeatingCapacity;
    }

    /**
     * This method calculates total cargo capacity of a given aircrafts in kilos
     *
     * @param aircraftList the list of aircrafts to calculate total cargo capacity
     * @return total cargo capacity of all aircrafts in the given list
     */
    public int getTotalCargoCapacityInKg(List<Aircraft> aircraftList) {
        int totalCargoCapacityInKg = 0;

        for (Aircraft aircraft : aircraftList) {
            totalCargoCapacityInKg = totalCargoCapacityInKg + aircraft.getCargoCapacityInKilos();
        }
        return totalCargoCapacityInKg;
    }

    /**
     * This method sorts the given list of aircrafts by their range in kilometre
     *
     * @param aircraftList the list of aircrafts to sort
     * @return sorted list of aircrafts
     */
    public List<Aircraft> SortAircraftsByMaximumRangeInKm(List<Aircraft> aircraftList) {
        return aircraftList
                .stream()
                .sorted(Comparator.comparing(Aircraft::getMaximumRangeInKm))
                .collect(Collectors.toList());
    }

    /**
     * This method finds aircrafts in the given list, which have fuel consumption in the given range
     *
     * @param aircraftList the list of aircrafts to process
     * @param minInclusive minimum value of the range
     * @param maxInclusive maximum value of the range
     * @return aircrafts, which have fuel consumption in the given range
     */
    public List<Aircraft> findAircraftsByFuelConsumptionInLitersPer1Kilometre(List<Aircraft> aircraftList, double minInclusive, double maxInclusive) {
        List<Aircraft> result = new ArrayList<>();

        for (Aircraft aircraft : aircraftList) {
            if (aircraft.getFuelConsumptionInLitersPerKm() >= minInclusive
                    && aircraft.getFuelConsumptionInLitersPerKm() <= maxInclusive) {
                result.add(aircraft);
            }
        }
        return result;
    }

    /**
     * This method simply returns all aircrafts of the airline
     *
     * @return the list of all aircrafts of the airline
     */
    public List<Aircraft> getAircrafts() {
        return aircrafts;
    }

    /**
     * This method sets the list of aircrafts to the airline.
     * Note that if the airline contains aircrafts this method will
     * set new value - the previous value will be overridden
     *
     * @param aircrafts the list of aircrafts to be set to the airline
     */
    public void setAircrafts(List<Aircraft> aircrafts) {
        this.aircrafts = aircrafts;
    }
}
