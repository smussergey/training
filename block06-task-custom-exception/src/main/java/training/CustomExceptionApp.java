package training;

import training.controller.NotebookController;
import training.model.Notebook;
import training.view.View;

public class CustomExceptionApp {

    public static void main(String[] args) {
        Notebook notebook = new Notebook();
        View view = new View();
        NotebookController controller = new NotebookController(notebook, view);

        controller.processUser();
    }
}
