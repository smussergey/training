package ua.training.model.entity;

import java.util.HashMap;
import java.util.Map;

public class PassengerAircraft extends Aircraft {
    private Map<PassengerClass, Integer> seatsByClass = new HashMap<>();

    public void addSeatsByClass(PassengerClass passengerClass, int seatsCapacity) {
        seatsByClass.put(passengerClass, seatsCapacity);
    }

//    public int getTotalSeatsCapacity() {
//        return ;
//    }
}
