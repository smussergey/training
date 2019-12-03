package ua.training.model.entity;

import ua.training.model.entity.Aircraft;

public class FreighterAircraft extends Aircraft {
    private double cargoCompartmentInCubicMetre;
    private int seatingCapacity;

    public FreighterAircraft(String manufacturer, String model, double maximumRangeInKm,
                             double averageFuelConsumptionLiterPerKm, double cargoCapacityInKg,
                             double cargoCompartmentInCubicMetre, int seatingCapacity) {
        super(manufacturer, model, maximumRangeInKm, averageFuelConsumptionLiterPerKm, cargoCapacityInKg);
        this.cargoCompartmentInCubicMetre = cargoCompartmentInCubicMetre;
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public int getSeatingCapacity() {
        System.out.println("seatingCapacity:" + this.seatingCapacity);
        return this.seatingCapacity;
    }
}
