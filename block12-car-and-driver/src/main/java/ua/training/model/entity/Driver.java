package ua.training.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    private int iddriver;
    private String name;
    private String telephone;

    private List<Car> cars = new ArrayList<>();

    public Driver() {
    }
    public Driver(int iddriver, String name, String telephone, List<Car> cars) {
        this.iddriver = iddriver;
        this.name = name;
        this.telephone = telephone;
        this.cars = cars;
    }

    public int getIddriver() {
        return iddriver;
    }
    public void setIddriver(int iddriver) {
        this.iddriver = iddriver;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public List<Car> getCars() {
        return cars;
    }
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Driver{" +
                System.identityHashCode(this)+
                ", iddriver=" + iddriver +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
