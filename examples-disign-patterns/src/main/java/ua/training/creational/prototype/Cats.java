package ua.training.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class Cats implements Cloneable {
    private List<String> cats;

    public Cats() {
        cats = new ArrayList<>();
    }

    public Cats(List<String> cats) {
        this.cats = cats;
    }

    public void loaddata() {
        cats.add("Asya");
        cats.add("Vasya");
        cats.add("Murka");

    }

    public List<String> getCats() {
        return cats;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        List<String> temp = new ArrayList<>();
        temp.addAll(this.getCats());
        return new Cats(temp);
    }
}
