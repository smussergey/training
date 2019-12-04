package ua.training.inheritance.override2FirstOrSecond;

public class Second extends First {
    int value = 2;

    void addFive() {
        value += 5;
        System.out.println("second ");
        System.out.println("second value = " + value);
    }
}
