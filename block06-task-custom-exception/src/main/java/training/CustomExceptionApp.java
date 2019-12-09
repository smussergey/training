package training;

import training.controller.EntryController;
import training.view.View;

public class CustomExceptionApp {

    public static void main(String[] args) {
        View view = new View();
        EntryController controller = new EntryController(view);

        controller.processUser();
    }
}
