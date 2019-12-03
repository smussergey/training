package ua.training.model;

import ua.training.model.entity.Aircraft;

import java.util.List;

public class Airline {
    private String name;
    public List<Aircraft> aircrafts;

    public Airline(String name, List<Aircraft> aircrafts) {
        this.name = name;
        this.aircrafts = aircrafts;
    }

    public int getTotalSeatingCapacity() {
        int totalSeatingCapacity = 0;

        for (Aircraft aircraft : this.aircrafts) {
            totalSeatingCapacity = totalSeatingCapacity + aircraft.getSeatingCapacity();
        }
        return totalSeatingCapacity;
    }
}
