package ua.training;

import ua.training.controller.Controller;
import ua.training.model.Airline;
import ua.training.util.DataGenerator;
import ua.training.view.View;

public class AirlineApp {
    public static void main(String[] args) {
        View view = new View();
        Airline airline = new Airline();

        if (View.getBundle().getLocale().getDisplayLanguage().equals(View.LOCALE_LANGUAGE_UA)) {
            airline.setAircrafts(DataGenerator.getInitialDataUa());
        } else airline.setAircrafts(DataGenerator.getInitialDataEn());

        Controller controller = new Controller(airline, view);
        controller.startApplication();
    }
}