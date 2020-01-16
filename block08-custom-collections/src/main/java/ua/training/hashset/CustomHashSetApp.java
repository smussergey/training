package ua.training.hashset;

import java.util.Iterator;

public class CustomHashSetApp {
    public static void main(String[] args) {
        CustomHashSet<Integer> setOfIntegers = new CustomHashSet<>();
        System.out.println("Set size: " + setOfIntegers.size());
        setOfIntegers.add(5);
        setOfIntegers.add(10);
        System.out.println("Set after add: " + setOfIntegers.size());
        setOfIntegers.add(5);
        System.out.println("Set after add duplicate value: " + setOfIntegers.size());

        Iterator iterator = setOfIntegers.iterator();

        while (iterator.hasNext()) {
            System.out.println("Value: " + iterator.next());
        }

    }
}
