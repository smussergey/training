package ua.training.creational.abstractfactory.impl;

import ua.training.creational.abstractfactory.Keyboard;

public class EnKeyboard implements Keyboard {
    @Override
    public void print() {
        System.out.println("En print");
    }

    @Override
    public void println() {
        System.out.println("En println");
    }
}
