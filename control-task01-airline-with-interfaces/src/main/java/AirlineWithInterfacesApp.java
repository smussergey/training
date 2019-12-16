import controller.Controller;
import model.Airline;
import util.DataGenerator;
import view.View;

public class AirlineWithInterfacesApp {
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
