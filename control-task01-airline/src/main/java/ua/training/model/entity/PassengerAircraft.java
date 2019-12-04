package ua.training.model.entity;

import java.util.HashMap;
import java.util.Map;

public class PassengerAircraft extends Aircraft {
    private Map<PassengerClass, Integer> seatsByClass = new HashMap<>();


    public PassengerAircraft(String manufacturer, String model, int maximumRangeInKm,
                             double averageFuelConsumptionLiterPerKm, int cargoCapacityInKilo,
                             Map<PassengerClass, Integer> seatsByClass) {
        super(manufacturer, model, maximumRangeInKm, averageFuelConsumptionLiterPerKm, cargoCapacityInKilo);
        this.seatsByClass = seatsByClass;
    }

    public void addSeatsByClass(PassengerClass passengerClass, int seatsCapacity) {
        seatsByClass.put(passengerClass, seatsCapacity);
    }

    @Override
    public int getSeatingCapacity() {
        int seatingCapacity = seatsByClass.values()
                .stream()
                .reduce(0, Integer::sum);
        return seatingCapacity;
    }

    @Override
    public String toString() {
        return "\n" + "PassengerAircraft{" +
                super.toString() +
                "seatsByClass=" + seatsByClass +
                '}';
    }
}
