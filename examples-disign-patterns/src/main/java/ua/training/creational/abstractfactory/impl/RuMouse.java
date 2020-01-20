package ua.training.creational.abstractfactory.impl;

import ua.training.creational.abstractfactory.Mouse;

public class RuMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("Ru Click");
    }

    @Override
    public void dbclick() {
        System.out.println("Ru DbClick");
    }

    @Override
    public void scroll(int dirction) {
        System.out.println("Ru Move " + dirction);
    }
}
