package ua.training.model;

public abstract class Aircraft {
    public int flightCrewVolume;
    public int passengersVolume; // TODO not applicable for all planes
    public int cargoCapacityInKg;
    public double maximumTakeoffWeightInKg;
    public double maximumFlightLengthInKm;
    public double averageFuelConsumptionPerKm;
    public double averageFuelPerPerson;
    public double averageFuelPerHour;
}
