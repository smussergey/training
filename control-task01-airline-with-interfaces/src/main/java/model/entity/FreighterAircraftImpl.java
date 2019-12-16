package model.entity;

public class FreighterAircraftImpl implements Aircraft {
    private String manufacturer;
    private String model; //TODO use Enum, property
    private int maximumRangeInKm;
    private double fuelConsumptionInLitersPerKm; //TODO do not use double, use BigDecimal
    private int cargoCapacityInKilos;
    private int cargoCompartmentInCubicMetres;
    private int seatingCapacity;

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
        return seatingCapacity;
    }

    public int getCargoCompartmentInCubicMetres() {
        return cargoCompartmentInCubicMetres;
    }

    public FreighterAircraftImpl(String manufacturer,
                                 String model,
                                 int maximumRangeInKm,
                                 double fuelConsumptionInLitersPerKm,
                                 int cargoCapacityInKilos,
                                 int cargoCompartmentInCubicMetres,
                                 int seatingCapacity) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.maximumRangeInKm = maximumRangeInKm;
        this.fuelConsumptionInLitersPerKm = fuelConsumptionInLitersPerKm;
        this.cargoCapacityInKilos = cargoCapacityInKilos;
        this.cargoCompartmentInCubicMetres = cargoCompartmentInCubicMetres;
        this.seatingCapacity = seatingCapacity;
    }
}
