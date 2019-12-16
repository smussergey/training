package model.entity;

import java.util.Map;

public class PassengerAircraftImpl implements Aircraft {
    private String manufacturer;
    private String model; // TODO use Enum, property
    private int maximumRangeInKm;
    private double fuelConsumptionInLitersPerKm; //TODO do not use double, use BigDecimal
    private int cargoCapacityInKilos;
    private Map<PassengerClass, Integer> seatsByClass;


    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getMaximumRangeInKm() {
        return maximumRangeInKm;
    }

    @Override
    public double getFuelConsumptionInLitersPerKm() {
        return fuelConsumptionInLitersPerKm;
    }

    @Override
    public int getCargoCapacityInKilos() {
        return cargoCapacityInKilos;
    }

    @Override
    public int getSeatingCapacity() {
        int seatingCapacity = seatsByClass.values()
                .stream()
                .reduce(0, Integer::sum);
        return seatingCapacity;
    }

    public Map<PassengerClass, Integer> getSeatsByClass() {
        return seatsByClass;
    }

    public PassengerAircraftImpl(String manufacturer, String model,
                                 int maximumRangeInKm,
                                 double fuelConsumptionInLitersPerKm,
                                 int cargoCapacityInKilos,
                                 Map<PassengerClass, Integer> seatsByClass) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.maximumRangeInKm = maximumRangeInKm;
        this.fuelConsumptionInLitersPerKm = fuelConsumptionInLitersPerKm;
        this.cargoCapacityInKilos = cargoCapacityInKilos;
        this.seatsByClass = seatsByClass;
    }
}
