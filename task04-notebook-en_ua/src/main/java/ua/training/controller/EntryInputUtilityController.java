package ua.training.controller;

import ua.training.view.View;
import ua.training.view.TextConstant;

import java.util.Scanner;

public class EntryInputUtilityController {
    private Scanner scanner;
    private View view;

    public EntryInputUtilityController(Scanner scanner, View view) {
        this.scanner = scanner;
        this.view = view;
    }

    public String processInputWithScanner(String inputMessage, String regex) {
        String result;
        view.printMessage(inputMessage);

        while (!(scanner.hasNext() &&
                (result = scanner.next()).matches(regex))) {
            view.printWrongInputMessage(inputMessage);
        }

        return result;
    }
}
