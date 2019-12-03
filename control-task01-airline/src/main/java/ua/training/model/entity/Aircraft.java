package ua.training.model.entity;

public abstract class Aircraft {
    private String manufacturer;
    private String model;
    private double maximumRangeInKm;
    private double averageFuelConsumptionInLiterPerKm;
    private double cargoCapacityInKilo;

    public Aircraft(String manufacturer, String model, double maximumRangeInKm,
                    double averageFuelConsumptionInLiterPerKm, double cargoCapacityInKilo) {
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

    public double getMaximumRangeInKm() {
        return maximumRangeInKm;
    }

    public double getAverageFuelConsumptionInLiterPerKm() {
        return averageFuelConsumptionInLiterPerKm;
    }

    public double getCargoCapacityInKilo() {
        return cargoCapacityInKilo;
    }

    public abstract int getSeatingCapacity();
}
