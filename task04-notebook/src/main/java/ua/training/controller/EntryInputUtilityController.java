package ua.training.controller;

import ua.training.view.TextConstant;
import ua.training.view.View;
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
            view.printMessage(view.concatenateStrings(TextConstant.INCORRECT_INPUT_DATA,
                    inputMessage));
        }

        return result;
    }
}
