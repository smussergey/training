package ua.training.controller;

import ua.training.model.Entry;
import ua.training.view.TextConstant;
import ua.training.view.View;

import java.util.Scanner;

public class EntryInputController {
    private Scanner scanner;
    private View view;

    public EntryInputController(Scanner scanner, View view) {
        this.scanner = scanner;
        this.view = view;
    }

    public Entry processEntryInput() {
        Entry entry = new Entry();
        EntryInputUtilityController eiuc = new EntryInputUtilityController(scanner, view);
        String inputMessage;

        inputMessage = view.concatenateStrings(TextConstant.INPUT_DATA, TextConstant.LAST_NAME);
        entry.setLastName(eiuc.processInputWithScanner(inputMessage, Regex.REGEX_LAST_NAME));

        inputMessage = view.concatenateStrings(TextConstant.INPUT_DATA, TextConstant.FIRST_NAME);
        entry.setFirstName(eiuc.processInputWithScanner(inputMessage, Regex.REGEX_FIRST_NAME));

        inputMessage = view.concatenateStrings(TextConstant.INPUT_DATA, TextConstant.MIDDLE_NAME);
        entry.setMiddleName(eiuc.processInputWithScanner(inputMessage, Regex.REGEX_MIDDLE_NAME));
        System.out.println("you entered: " + entry.getLastName());

        return entry;
    }
}
