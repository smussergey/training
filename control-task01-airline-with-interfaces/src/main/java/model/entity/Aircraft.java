package model.entity;

public interface Aircraft {

    String getManufacturer();

    String getModel();

    int getMaximumRangeInKm();

    double getFuelConsumptionInLitersPerKm();

    int getCargoCapacityInKilos();

    int getSeatingCapacity();


}
