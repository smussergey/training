package ua.training.creational.builder;

public class BuilderApp {
    public static void main(String[] args) {
        Cat asya = new Cat.CatBuilder("Asya", 1)
                .setStriped(false)
                .build();

        System.out.println(asya.toString());
    }
}
