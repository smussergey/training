package training.controller;

import training.view.TextConstant;
import training.view.View;

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
        view.printMessages(inputMessage);

        while (!(scanner.hasNext() &&
                (result = scanner.next()).matches(regex))) {
            view.printMessages(view.getBundleMessage(TextConstant.WRONG_INPUT),
                    inputMessage);
        }

        return result;
    }
}
