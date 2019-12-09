package training.controller;

import training.model.Entry;
import training.view.TextConstant;
import training.view.View;

import java.util.Scanner;

import static training.controller.Regex.*;

public class EntryInputController {
    private Scanner scanner;
    private View view;

    public EntryInputController(Scanner scanner, View view) {
        this.scanner = scanner;
        this.view = view;
    }

    public Entry processEntryInput() {
        String name;
        String login;
        EntryInputUtilityController eiuc = new EntryInputUtilityController(scanner, view);
        String inputMessage;
        String inputRegex;

        inputMessage = view.concatenateStrings(view.getBundleMessage(TextConstant.INPUT_DATA),
                TextConstant.SPACE_SING,
                view.getBundleMessage(TextConstant.NAME));
        inputRegex = (String.valueOf(View.bundle.getLocale()).equals("ua"))
                ? NAME_UKR : NAME_LAT;
        name = eiuc.processInputWithScanner(inputMessage, inputRegex);

        inputMessage = view.concatenateStrings(view.getBundleMessage(TextConstant.INPUT_DATA),
                TextConstant.SPACE_SING,
                view.getBundleMessage(TextConstant.LOGIN));
        inputRegex = LOGIN;
        login = eiuc.processInputWithScanner(inputMessage, inputRegex);

        return new Entry(name, login);
    }
}
