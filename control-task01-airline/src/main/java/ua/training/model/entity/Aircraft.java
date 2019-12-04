package ua.training.model.entity;

public abstract class Aircraft {
    private String manufacturer;
    private String model;
    private int maximumRangeInKm;
    private double fuelConsumptionInLiterPerKm;
    private int cargoCapacityInKilo;

    public Aircraft(String manufacturer, String model, int maximumRangeInKm,
                    double fuelConsumptionInLiterPerKm, int cargoCapacityInKilo) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.maximumRangeInKm = maximumRangeInKm;
        this.fuelConsumptionInLiterPerKm = fuelConsumptionInLiterPerKm;
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

    public double getFuelConsumptionInLiterPerKm() {
        return fuelConsumptionInLiterPerKm;
    }

    public int getCargoCapacityInKilo() {
        return cargoCapacityInKilo;
    }

    public abstract int getSeatingCapacity();

    @Override
    public String toString() {
        return "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", maximumRangeInKm=" + maximumRangeInKm +
                ", fuelConsumptionInLiterPerKm=" + fuelConsumptionInLiterPerKm +
                ", cargoCapacityInKilo=" + cargoCapacityInKilo;
    }
}
