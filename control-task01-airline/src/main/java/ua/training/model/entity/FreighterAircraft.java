package ua.training.model.entity;

import ua.training.model.entity.Aircraft;

public class FreighterAircraft extends Aircraft {
    private int cargoCompartmentInCubicMetre;
    private int seatingCapacity;

    public FreighterAircraft(String manufacturer, String model, int maximumRangeInKm,
                             double averageFuelConsumptionLiterPerKm, int cargoCapacityInKg,
                             int cargoCompartmentInCubicMetre, int seatingCapacity) {
        super(manufacturer, model, maximumRangeInKm, averageFuelConsumptionLiterPerKm, cargoCapacityInKg);
        this.cargoCompartmentInCubicMetre = cargoCompartmentInCubicMetre;
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public int getSeatingCapacity() {
        return this.seatingCapacity;
    }

    @Override
    public String toString() {
        return "FreighterAircraft{" +
                super.toString() +
                ", cargoCompartmentInCubicMetre=" + cargoCompartmentInCubicMetre +
                ", seatingCapacity=" + seatingCapacity +
                '}';
    }
}
