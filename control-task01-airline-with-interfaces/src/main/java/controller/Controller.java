package controller;

import model.Airline;
import model.entity.Aircraft;
import model.entity.FreighterAircraftImpl;
import model.entity.PassengerAircraftImpl;
import model.entity.PassengerClass;
import view.View;
import view.util.TextConstant;

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
        getAircraftsByFuelConsumptionLiterPerKmInclusively(2.00, 5.00);
    }

    private void getTotalListOfAircrafts() {
        view.printMessages(view.getBundleString(TextConstant.AIRCRAFTS_LIST), TextConstant.COLON_SING);
        List<Aircraft> aircrafts = airline.getAircrafts();

        for (Aircraft aircraft : aircrafts) {
            String aircraftType = "";
            String specialCharacteristics = "";

            if (aircraft instanceof FreighterAircraftImpl) {
                FreighterAircraftImpl freighterAircraftImpl = (FreighterAircraftImpl) aircraft;
                aircraftType = (view.getBundleString(TextConstant.FREIGHTER_AIRCRAFT));
                specialCharacteristics = view.concatenateStrings(view.getBundleString(TextConstant.CARGO_COMPARTMENT_IN_CUBIC_METRES),
                        TextConstant.COLON_SING, String.valueOf(freighterAircraftImpl.getCargoCompartmentInCubicMetres()), TextConstant.COMMA_SING, TextConstant.SPACE_SING,
                        view.getBundleString(TextConstant.SEATING_CAPACITY),
                        TextConstant.COLON_SING, String.valueOf(freighterAircraftImpl.getSeatingCapacity()));
            } else if (aircraft instanceof PassengerAircraftImpl) {
                PassengerAircraftImpl passengerAircraftImpl = (PassengerAircraftImpl) aircraft;
                aircraftType = (view.getBundleString(TextConstant.PASSENGER_AIRCRAFT));
                specialCharacteristics = view.concatenateStrings(view.getBundleString(TextConstant.SEATING_CAPACITY),
                        TextConstant.COLON_SING, TextConstant.SPACE_SING,
                        (view.getBundleString(TextConstant.BUSINESS_CLASS)),
                        TextConstant.COLON_SING, TextConstant.SPACE_SING, String.valueOf(passengerAircraftImpl.getSeatsByClass().get(PassengerClass.BUSINESS)),
                        TextConstant.COMMA_SING, TextConstant.SPACE_SING,
                        (view.getBundleString(TextConstant.ECONOMY_CLASS)),
                        TextConstant.COLON_SING, TextConstant.SPACE_SING, String.valueOf(passengerAircraftImpl.getSeatsByClass().get(PassengerClass.ECONOMY)));
            }


            view.printMessages(view.concatenateStrings(aircraftType, TextConstant.COLON_SING, TextConstant.SPACE_SING,
                    view.getBundleString(TextConstant.MANUFACTURE),
                    TextConstant.COLON_SING, aircraft.getManufacturer(), TextConstant.COMMA_SING, TextConstant.SPACE_SING,
                    view.getBundleString(TextConstant.MODEL),
                    TextConstant.COLON_SING, aircraft.getModel(), TextConstant.COMMA_SING, TextConstant.SPACE_SING,
                    view.getBundleString(TextConstant.MAXIMUM_RANGE_IN_KILOMETRES),
                    TextConstant.COLON_SING, String.valueOf(aircraft.getMaximumRangeInKm()), TextConstant.COMMA_SING, TextConstant.SPACE_SING,
                    view.getBundleString(TextConstant.FUEL_CONSUMPTION_IN_LITERS_PER_1_KILOMETRE),
                    TextConstant.COLON_SING, String.valueOf(aircraft.getFuelConsumptionInLitersPerKm()), TextConstant.COMMA_SING, TextConstant.SPACE_SING,
                    view.getBundleString(TextConstant.CARGO_CAPACITY_IN_KILOS),
                    TextConstant.COLON_SING, String.valueOf(aircraft.getCargoCapacityInKilos()), TextConstant.COMMA_SING, TextConstant.SPACE_SING,
                    specialCharacteristics));
        }
    }

    private void getTotalSeatingCapacity() {
        List<Aircraft> aircrafts = airline.getAircrafts();
        view.printMessages(TextConstant.NEW_LINE_SING,
                view.getBundleString(TextConstant.TOTAL_SEATING_CAPACITY),
                TextConstant.COLON_SING, TextConstant.SPACE_SING,
                String.valueOf(airline.getTotalSeatingCapacity(aircrafts)));
    }

    private void getTotalCargoCapacity() {
        List<Aircraft> aircrafts = airline.getAircrafts();
        view.printMessages(TextConstant.NEW_LINE_SING,
                view.getBundleString(TextConstant.TOTAL_CARGO_CAPACITY_IN_KILOS),
                TextConstant.COLON_SING, TextConstant.SPACE_SING,
                String.valueOf(airline.getTotalCargoCapacityInKg(aircrafts)));
    }

    private void getSortedAircraftsByMaximumRangeInKm() {
        List<Aircraft> aircrafts = airline.getAircrafts();
        List<Aircraft> sortedAircrafts = airline.SortAircraftsByMaximumRangeInKm(aircrafts);

        view.printMessages(TextConstant.NEW_LINE_SING, view.getBundleString(TextConstant.SORTED_AIRCRAFTS),
                TextConstant.SPACE_SING,
                view.getBundleString(TextConstant.BY_MAXIMUM_RANGE_IN_KILOMETRES),
                TextConstant.COLON_SING);

        for (Aircraft aircraft : sortedAircrafts) {
            view.printMessages(TextConstant.TAB_SING,
                    aircraft.getModel(),
                    TextConstant.COLON_SING,
                    TextConstant.SPACE_SING,
                    String.valueOf(aircraft.getMaximumRangeInKm()));
        }
    }

    private void getAircraftsByFuelConsumptionLiterPerKmInclusively(Double min, Double max) {
        List<Aircraft> aircrafts = airline.getAircrafts();
        List<Aircraft> resultAircrafts = airline.findAircraftsByFuelConsumptionInLitersPer1Kilometre(aircrafts, min, max);
        int resultQuantity = resultAircrafts.size();

        String message = view.concatenateStrings(TextConstant.NEW_LINE_SING,
                view.getBundleString(TextConstant.WITH_A_GIVEN_FUEL_CONSUMPTION_RANGE_FROM),
                TextConstant.SPACE_SING, String.valueOf(min), TextConstant.SPACE_SING,
                view.getBundleString(TextConstant.TO),
                TextConstant.SPACE_SING, String.valueOf(max), TextConstant.SPACE_SING,
                view.getBundleString(TextConstant.LITRES_PER_1_KILOMETRE_INCLUSIVELY_WAS_FOUND),
                TextConstant.SPACE_SING, String.valueOf(resultQuantity), TextConstant.SPACE_SING,
                view.getBundleString(TextConstant.AIRCRAFT),
                TextConstant.COLON_SING);
        view.printMessages(message);

        for (Aircraft aircraft : resultAircrafts) {
            view.printMessages(TextConstant.TAB_SING,
                    aircraft.getModel(),
                    TextConstant.COLON_SING,
                    TextConstant.SPACE_SING,
                    String.valueOf(aircraft.getFuelConsumptionInLitersPerKm()));
        }
    }
}