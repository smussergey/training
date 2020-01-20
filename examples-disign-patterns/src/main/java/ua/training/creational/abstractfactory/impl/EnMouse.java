package ua.training.creational.abstractfactory.impl;

import ua.training.creational.abstractfactory.Mouse;

public class EnMouse  implements Mouse {
    @Override
    public void click() {
        System.out.println("En Click");
    }

    @Override
    public void dbclick() {
        System.out.println("En DbClick");
    }

    @Override
    public void scroll(int dirction) {
        System.out.println("En Move " + dirction);
    }
}
