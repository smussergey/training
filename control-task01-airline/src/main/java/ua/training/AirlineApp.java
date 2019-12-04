package ua.training;

import ua.training.controller.Controller;
import ua.training.model.Airline;
import ua.training.util.DataGenerator;
import ua.training.view.View;

public class AirlineApp {
    public static void main(String[] args) {
        Airline airline = new Airline("KPIAvia", DataGenerator.getInitialData());
        View view = new View();

        Controller controller = new Controller(airline, view);
        controller.startApplication();
    }
}
