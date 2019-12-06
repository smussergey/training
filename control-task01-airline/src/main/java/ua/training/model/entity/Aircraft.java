package ua.training.model.entity;

import java.util.Objects;

public abstract class Aircraft {
    private String manufacturer;
    private String model;
    private int maximumRangeInKm;
    private double fuelConsumptionInLitersPerKm;
    private int cargoCapacityInKilos;

    public Aircraft(String manufacturer, String model, int maximumRangeInKm,
                    double fuelConsumptionInLitersPerKm, int cargoCapacityInKilos) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.maximumRangeInKm = maximumRangeInKm;
        this.fuelConsumptionInLitersPerKm = fuelConsumptionInLitersPerKm;
        this.cargoCapacityInKilos = cargoCapacityInKilos;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getMaximumRangeInKm() {
        return maximumRangeInKm;
    }

    public double getFuelConsumptionInLitersPerKm() {
        return fuelConsumptionInLitersPerKm;
    }

    public int getCargoCapacityInKilos() {
        return cargoCapacityInKilos;
    }

    public abstract int getSeatingCapacity();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aircraft)) return false;
        Aircraft aircraft = (Aircraft) o;
        return manufacturer.equals(aircraft.manufacturer) &&
                model.equals(aircraft.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, model);
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
