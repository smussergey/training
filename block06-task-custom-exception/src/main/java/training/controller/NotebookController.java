package training.controller;

import training.model.Notebook;
import training.view.TextConstant;
import training.view.View;

import java.util.Scanner;

public class NotebookController {
    private Notebook notebook;
    private View view;

    public NotebookController(Notebook notebook, View view) {
        this.notebook = notebook;
        this.view = view;
    }

    public void processUser() {
        Scanner scanner = new Scanner(System.in);

        EntryInputController entryInputController = new EntryInputController(scanner, view);
        notebook.addEntry(entryInputController.processEntryInput());

        view.printMessage(view.concatenateBundleStrings(TextConstant.SAVED_ENTRY)
                + notebook.getEntries().get(0).toString());
    }

}
