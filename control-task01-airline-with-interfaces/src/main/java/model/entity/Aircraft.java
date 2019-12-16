package model.entity;

public interface Aircraft {

    public String getManufacturer();

    public String getModel();

    public int getMaximumRangeInKm();

    public double getFuelConsumptionInLitersPerKm();

    public int getCargoCapacityInKilos();

    public abstract int getSeatingCapacity();


}
