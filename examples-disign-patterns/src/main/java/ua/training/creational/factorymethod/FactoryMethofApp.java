package ua.training.creational.factorymethod;

public class FactoryMethofApp {
    public static void main(String[] args) {
        WatchMaker watchMaker = new DigitalWatchMaker();
        Watch watch = watchMaker.createWatch();
        watch.showTime();

        getMakerByName("Rome").createWatch().showTime();

        getMakerByName("dwcewc");
    }

    private static WatchMaker getMakerByName(String maker) {
        if (maker.equals("Digital")) {
            return new DigitalWatchMaker();
        } else if (maker.equals("Rome")) {
            return new RomeWatchMaker();
        }
        throw new RuntimeException("Production line in not functioning for watch " + maker);
    }
}