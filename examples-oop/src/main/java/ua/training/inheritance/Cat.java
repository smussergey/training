package ua.training.inheritance;

public class Cat extends Animal {
    public String type = "Cat type object field";

    @Override
    public void say() {
        System.out.println("I am a cat");
    }
}

