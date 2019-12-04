package ua.training.inheritance;

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
    }
}
