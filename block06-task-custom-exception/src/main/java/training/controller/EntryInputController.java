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
        Entry entry = new Entry();
        EntryInputUtilityController eiuc = new EntryInputUtilityController(scanner, view);
        String inputMessage;
        String inputRegex;

        inputMessage = view.concatenateBundleStrings(TextConstant.INPUT_DATA, TextConstant.LAST_NAME);
        inputRegex = (String.valueOf(View.bundle.getLocale()).equals("ua"))
                ? REGEX_LAST_NAME_UKR : REGEX_LAST_NAME_LAT;
        entry.setLastName(eiuc.processInputWithScanner(inputMessage, inputRegex));

        inputMessage = view.concatenateBundleStrings(TextConstant.INPUT_DATA, TextConstant.NICKNAME);
        inputRegex = REGEX_NICKNAME;
        entry.setNickName(eiuc.processInputWithScanner(inputMessage, inputRegex));

        return entry;
    }
}
