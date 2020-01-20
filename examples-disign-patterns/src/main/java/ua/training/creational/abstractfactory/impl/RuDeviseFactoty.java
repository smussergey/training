package ua.training.creational.abstractfactory.impl;

import ua.training.creational.abstractfactory.DeviceFactory;
import ua.training.creational.abstractfactory.Keyboard;
import ua.training.creational.abstractfactory.Mouse;
import ua.training.creational.abstractfactory.TouchPad;

public class RuDeviseFactoty implements DeviceFactory {
    @Override
    public Mouse getMouse() {
        return new RuMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new RuKeyboard();
    }

    @Override
    public TouchPad getTouchPad() {
        return new RuTouchPad();
    }
}