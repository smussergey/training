package ua.training.controller;

import ua.training.model.Entry;
import ua.training.model.Notebook;
import ua.training.view.View;

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
        System.out.println("You entered: \n" + notebook.getEntries().get(0).toString());
    }

}
