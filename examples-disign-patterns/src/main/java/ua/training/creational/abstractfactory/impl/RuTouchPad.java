package ua.training.creational.abstractfactory.impl;

import ua.training.creational.abstractfactory.TouchPad;

public class RuTouchPad implements TouchPad {
    @Override
    public void track(int dletaX, int deltaY) {
        System.out.println("Ru moved " + (dletaX +deltaY));
    }
}
