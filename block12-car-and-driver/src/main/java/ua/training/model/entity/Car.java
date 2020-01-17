package ua.training.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private int idCar;
    private String name;
    private String number;

    private List<Driver> drivers = new ArrayList<>();

    public Car() {
    }
    public Car(int idCar, String name, String nomer, List<Driver> drivers) {
        this.idCar = idCar;
        this.name = name;
        this.number = nomer;
        this.drivers = drivers;
    }

    public int getIdCar() {
        return idCar;
    }
    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public List<Driver> getDrivers() {
        return drivers;
    }
    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    @Override
    public String toString() {
        return "Car{" +
                System.identityHashCode(this)+
                ", idCar=" + idCar +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}' + '\n';
    }

/*    @Override
    public String toString() {
        return "Car{" +
                "idCar=" + idCar +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                // !!!!!!!!!  ", drivers=" + drivers +
                '}';
    }*/
}
