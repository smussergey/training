package ua.training.model.entity;

public abstract class Aircraft {
    private String manufacturer;
    private String model;
    private int maximumRangeInKm;
    private double averageFuelConsumptionInLiterPerKm;
    private int cargoCapacityInKilo;

    public Aircraft(String manufacturer, String model, int maximumRangeInKm,
                    double averageFuelConsumptionInLiterPerKm, int cargoCapacityInKilo) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.maximumRangeInKm = maximumRangeInKm;
        this.averageFuelConsumptionInLiterPerKm = averageFuelConsumptionInLiterPerKm;
        this.cargoCapacityInKilo = cargoCapacityInKilo;
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

    public double getAverageFuelConsumptionInLiterPerKm() {
        return averageFuelConsumptionInLiterPerKm;
    }

    public int getCargoCapacityInKilo() {
        return cargoCapacityInKilo;
    }

    public abstract int getSeatingCapacity();
}
