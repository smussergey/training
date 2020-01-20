package ua.training.creational.abstractfactory;

import ua.training.creational.abstractfactory.impl.EnDeviseFactory;
import ua.training.creational.abstractfactory.impl.RuDeviseFactoty;

public class AbstractFactoryApp {
    public static void main(String[] args) {

        DeviceFactory deviceFactory = getFactoryByCountryCode("EN");
        Keyboard keyboard = deviceFactory.getKeyboard();
        Mouse mouse = deviceFactory.getMouse();
        TouchPad touchPad = deviceFactory.getTouchPad();

        keyboard.print();
        mouse.dbclick();
        touchPad.track(5, 9);
    }

    private static DeviceFactory getFactoryByCountryCode(String lang) {
        switch (lang) {
            case ("RU"):
                return new RuDeviseFactoty();
            case ("EN"):
                return new EnDeviseFactory();
            default:
                throw new RuntimeException("unsuppoted code: " + lang);
        }
    }
}
