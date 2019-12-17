package ua.training.model;

import ua.training.model.entity.Aircraft;

import java.util.Objects;

public abstract class AircraftImpl implements Aircraft {
    private String manufacturer;
    private String model; // use Enum, property
    private int maximumRangeInKm;
    private double fuelConsumptionInLitersPerKm; //do not use double, use BigDecimal
    private int cargoCapacityInKilos;

    public AircraftImpl(String manufacturer, String model, int maximumRangeInKm,
                        double fuelConsumptionInLitersPerKm, int cargoCapacityInKilos) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.maximumRangeInKm = maximumRangeInKm;
        this.fuelConsumptionInLitersPerKm = fuelConsumptionInLitersPerKm;
        this.cargoCapacityInKilos = cargoCapacityInKilos;
    }

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
    public abstract int getSeatingCapacity();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AircraftImpl)) return false;
        AircraftImpl aircraft = (AircraftImpl) o;
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
