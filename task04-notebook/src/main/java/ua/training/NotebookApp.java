package ua.training;

import ua.training.controller.NotebookController;
import ua.training.model.Notebook;
import ua.training.view.View;

public class NotebookApp {

    public static void main(String[] args) {
        Notebook notebook = new Notebook();
        View view = new View();
        NotebookController controller = new NotebookController(notebook, view);

        controller.processUser();
    }
}
