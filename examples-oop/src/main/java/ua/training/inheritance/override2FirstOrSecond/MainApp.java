package ua.training.inheritance.override2FirstOrSecond;

public class MainApp {
    public static void main(String[] args) {
        First f = new Second();
        f.addFive();
        System.out.println(f.value);
    }
}
