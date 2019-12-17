package ua.training.model.entity;

import java.util.Map;

public class PassengerAircraft extends AircraftImpl {
    private Map<PassengerClass, Integer> seatsByClass;


    public PassengerAircraft(String manufacturer, String model, int maximumRangeInKm,
                             double averageFuelConsumptionLiterPerKm, int cargoCapacityInKilo,
                             Map<PassengerClass, Integer> seatsByClass) {
        super(manufacturer, model, maximumRangeInKm, averageFuelConsumptionLiterPerKm, cargoCapacityInKilo);
        this.seatsByClass = seatsByClass;
    }

    @Override
    public int getSeatingCapacity() {
        int seatingCapacity = seatsByClass.values()
                .stream()
                .reduce(0, Integer::sum);
        return seatingCapacity;
    }

    public Map<PassengerClass, Integer> getSeatsByClass() {
        return seatsByClass;
    }
}
