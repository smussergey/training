package ua.training.arraylist;

import java.util.Arrays;

public class CustomArrayListApp {

    public static void main(String[] args) {
        CustomArrayList<String> str = new CustomArrayListImpl<>();
        str.add("first");
        str.add("second");
        str.add("third");
        str.add("forth");

        System.out.println("Initial values:");
        for (String v : str) {
            System.out.println(v);
        }
        System.out.println("size = " + str.size());
        System.out.println();

        System.out.println("After updated value:");
        str.update(2, "thirdNew");
        for (String v : str) {
            System.out.println(v);
        }
        System.out.println("size = " + str.size());
        System.out.println();

        System.out.println("After deletion value /'thirdNew/':");
        str.delete(2);
        for (String v : str) {
            System.out.println(v);
        }
        System.out.println("size = " + str.size());
    }
}
