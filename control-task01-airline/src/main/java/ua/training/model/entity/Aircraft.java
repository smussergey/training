package ua.training.model.entity;

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
}
