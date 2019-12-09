package training.controller;

import training.model.DuplicateLoginException;
import training.model.Entry;
import training.view.TextConstant;
import training.view.View;

import java.util.Scanner;

public class EntryController {
    private View view;

    public EntryController(View view) {
        this.view = view;
    }

    public void processUser() {
        Scanner scanner = new Scanner(System.in);
        EntryInputController entryInputController = new EntryInputController(scanner, view);
        Entry newEntry = null;

        try {
            newEntry = entryInputController.processEntryInput();
        } catch (DuplicateLoginException ex) {
            view.printMessages(view.getBundleMessage(TextConstant.WRONG_INPUT),
                    ex.getMessage(),
                    TextConstant.SPACE_SING,
                    view.getBundleMessage(TextConstant.SUCH_LOGIN_ALREADY_EXISTS));
            processUser();
        }

        view.printMessages(view.getBundleMessage(TextConstant.ENTERED_ENTRY), newEntry.toString());
    }
}
