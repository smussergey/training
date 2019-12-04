package ua.training.inheritance.override1animal;

public class AnimalApp {
    public static void main(String[] args) {
        Animal catByAnimalReference = new Cat();
        Cat catByCatReference = new Cat();

        System.out.println("Cat by Animal reference:");
        System.out.println(catByAnimalReference.type);
        catByAnimalReference.say();
        System.out.println("");

        System.out.println("Cat by CAt reference:");
        System.out.println(catByCatReference.type);
        catByCatReference.say();
        System.out.println("");

        System.out.println("catByAnimalReference instanceof Animal = " + (catByAnimalReference instanceof Animal));
        System.out.println("catByAnimalReference instanceof Cat = " + (catByAnimalReference instanceof Cat));

        System.out.println("catByAnimalReference.getClass()) = " + (catByAnimalReference.getClass()));
        System.out.println("catByCatReference.getClass()) = " + (catByCatReference.getClass()));

    }
}
