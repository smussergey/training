package ua.training.creational.abstractfactory;

public interface DeviceFactory {
    Mouse getMouse();

    Keyboard getKeyboard();

    TouchPad getTouchPad();
}
