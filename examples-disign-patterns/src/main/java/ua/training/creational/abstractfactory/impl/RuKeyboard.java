package ua.training.creational.abstractfactory.impl;

import ua.training.creational.abstractfactory.Keyboard;

public class RuKeyboard implements Keyboard {
    @Override
    public void print() {
        System.out.println("Ru print");
    }

    @Override
    public void println() {
        System.out.println("Ru println");
    }
}
