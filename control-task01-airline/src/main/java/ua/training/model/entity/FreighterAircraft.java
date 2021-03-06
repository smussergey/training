package ua.training.model.entity;

public class FreighterAircraft extends Aircraft {
    private int cargoCompartmentInCubicMetres;
    private int seatingCapacity;

    public FreighterAircraft(String manufacturer, String model, int maximumRangeInKm,
                             double averageFuelConsumptionLiterPerKm, int cargoCapacityInKg,
                             int cargoCompartmentInCubicMetres, int seatingCapacity) {
        super(manufacturer, model, maximumRangeInKm, averageFuelConsumptionLiterPerKm, cargoCapacityInKg);
        this.cargoCompartmentInCubicMetres = cargoCompartmentInCubicMetres;
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public int getSeatingCapacity() {
        return this.seatingCapacity;
    }

    public int getCargoCompartmentInCubicMetres() {
        return cargoCompartmentInCubicMetres;
    }
}
