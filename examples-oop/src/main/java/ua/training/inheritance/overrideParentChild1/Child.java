package ua.training.inheritance.overrideParentChild1;

public class Child extends Parent {
    int x = 3;

    void print(int x) {
        System.out.println(x);
        System.out.println(this.x);
        System.out.println(super.x);
    }
}