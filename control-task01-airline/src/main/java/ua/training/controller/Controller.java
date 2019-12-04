package ua.training.controller;

import ua.training.model.Airline;
import ua.training.model.entity.Aircraft;
import ua.training.view.View;
import ua.training.view.TextConstant;

import java.util.List;

public class Controller {
    private Airline airline;
    private View view;

    public Controller(Airline airline, View view) {
        this.airline = airline;
        this.view = view;
    }

    public void startApplication() {
        getTotalListOfAircrafts();
        getTotalSeatingCapacity();
        getTotalCargoCapacity();
        getSortedAircraftsByMaximumRangeInKm();
        getAircraftsByAverageFuelConsumptionLiterPerKmInclusively(3.00, 5.00);
    }


    private void getTotalListOfAircrafts() {
        List<Aircraft> aircrafts = airline.getAircrafts();
        view.printMessages(view.concatenateBundleStrings(TextConstant.AIRCRAFTS_LIST));

        for (Aircraft aircraft : aircrafts) {
            view.printMessages(aircraft.toString());
        }
    }

    private void getTotalSeatingCapacity() {
        List<Aircraft> aircrafts = airline.getAircrafts();
        view.printMessages(TextConstant.NEW_LINE, view.concatenateBundleStrings(TextConstant.TOTAL_SEATING_CAPACITY),
                String.valueOf(airline.getTotalSeatingCapacity(aircrafts)));
    }

    private void getTotalCargoCapacity() {
        List<Aircraft> aircrafts = airline.getAircrafts();
        view.printMessages(TextConstant.NEW_LINE, view.concatenateBundleStrings(TextConstant.TOTAL_CARGO_CAPACITY_IN_KILO),
                String.valueOf(airline.getTotalCargoCapacityInKg(aircrafts)));
    }

    private void getSortedAircraftsByMaximumRangeInKm() {
        List<Aircraft> aircrafts = airline.getAircrafts();
        List<Aircraft> sortedAircrafts = airline.SortAircraftsByMaximumRangeInKm(aircrafts);

        view.printMessages(TextConstant.NEW_LINE, view.concatenateBundleStrings(TextConstant.SORTED_AIRCRAFTS_BY, TextConstant.MAXIMUM_RANGE_IN_KM));

        for (Aircraft aircraft : sortedAircrafts) {
            view.printMessages(TextConstant.TAB_SING,
                    aircraft.getModel(),
                    TextConstant.COLON_SING,
                    TextConstant.SPACE_SING,
                    String.valueOf(aircraft.getMaximumRangeInKm()));
        }
    }

    private void getAircraftsByAverageFuelConsumptionLiterPerKmInclusively(Double min, Double max) {
        List<Aircraft> aircrafts = airline.getAircrafts();
        List<Aircraft> resultAircrafts = airline.findAircraftsByAverageFuelConsumptionLiterPerKmInclusively(aircrafts, min, max);
        int resultQuantity = resultAircrafts.size();

        String message = view.concatenateStrings(TextConstant.NEW_LINE, view.concatenateBundleStrings(TextConstant.WITH_A_GIVEN_FUEL_CONSUMPTION_RANGE,
                TextConstant.FROM),
                TextConstant.SPACE_SING, String.valueOf(min), TextConstant.SPACE_SING,
                view.concatenateBundleStrings(TextConstant.TO),
                TextConstant.SPACE_SING, String.valueOf(max), TextConstant.SPACE_SING,
                view.concatenateBundleStrings(TextConstant.LITRES_PER_1_KILOMETRE, TextConstant.INCLUSIVELY, TextConstant.WAS_FOUND),
                TextConstant.SPACE_SING, String.valueOf(resultQuantity), TextConstant.SPACE_SING,
                view.concatenateBundleStrings(TextConstant.AIRCRAFT));
        view.printMessages(message);
    }
}