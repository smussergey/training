package ua.training.creational.prototype;

import java.util.List;

public class CatsApp {
    public static void main(String[] args) throws CloneNotSupportedException {
        Cats cats = new Cats();
        cats.loaddata();

        Cats catsNew1 = (Cats) cats.clone();
        Cats catsNew2 = (Cats) cats.clone();
        List<String> catsList1 = catsNew1.getCats();
        catsList1.add("Petya");
        List<String> catsList2 = catsNew2.getCats();
        catsList2.remove("Vasya");

        System.out.println("cats list original: " + cats.getCats());
        System.out.println("cats list 1: " + catsList1);
        System.out.println("cats list 2: " + catsList2);
    }
}
