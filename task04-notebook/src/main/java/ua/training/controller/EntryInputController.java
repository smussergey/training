package ua.training.controller;

import ua.training.model.Entry;
import ua.training.model.MaritalStatus;
import ua.training.view.TextConstant;
import ua.training.view.View;

import java.time.LocalDate;
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

        inputMessage = view.concatenateStrings(TextConstant.INPUT_DATA, TextConstant.NICKNAME);
        entry.setNickName(eiuc.processInputWithScanner(inputMessage, Regex.REGEX_NICKNAME));

        inputMessage = view.concatenateStrings(TextConstant.INPUT_DATA, TextConstant.COMMENT);
        entry.setComment(eiuc.processInputWithScanner(inputMessage, Regex.REGEX_COMMENT));

        inputMessage = view.concatenateStrings(TextConstant.INPUT_DATA, TextConstant.MARITAL_STATUS);
        entry.setMaritalStatus(MaritalStatus.valueOf(eiuc.processInputWithScanner(inputMessage, Regex.REGEX_MARITAL_STATUS)));

        inputMessage = view.concatenateStrings(TextConstant.INPUT_DATA, TextConstant.PHONE_NUMBER_HOME);
        entry.setPhoneNumberHome(eiuc.processInputWithScanner(inputMessage, Regex.REGEX_PHONE_NUMBER_HOME));

        inputMessage = view.concatenateStrings(TextConstant.INPUT_DATA, TextConstant.PHONE_NUMBER_MOBILE_MAIN);
        entry.setPhoneNumberMobileMain(eiuc.processInputWithScanner(inputMessage, Regex.REGEX_PHONE_NUMBER_MOBILE_MAIN));

        inputMessage = view.concatenateStrings(TextConstant.INPUT_DATA, TextConstant.PHONE_NUMBER_MOBILE_ADDITIONAL);
        entry.setPhoneNumberMobileAdditional(eiuc.processInputWithScanner(inputMessage, Regex.REGEX_PHONE_NUMBER_MOBILE_ADDITIONAL));

        inputMessage = view.concatenateStrings(TextConstant.INPUT_DATA, TextConstant.EMAIL);
        entry.setEmail(eiuc.processInputWithScanner(inputMessage, Regex.REGEX_EMAIL));

        inputMessage = view.concatenateStrings(TextConstant.INPUT_DATA, TextConstant.SKYPE);
        entry.setSkype(eiuc.processInputWithScanner(inputMessage, Regex.REGEX_SKYPE));

        inputMessage = view.concatenateStrings(TextConstant.INPUT_DATA, TextConstant.ADDRESS);
        entry.setAddress(eiuc.processInputWithScanner(inputMessage, Regex.REGEX_ADDRESS));

//        inputMessage = view.concatenateStrings(TextConstant.INPUT_DATA, TextConstant.DATE_CREATED);
//        entry.setMiddleName(eiuc.processInputWithScanner(inputMessage, Regex.REGEX_DATE_CREATED));
//
//        inputMessage = view.concatenateStrings(TextConstant.INPUT_DATA, TextConstant.DATE_UPDATED);
//        entry.setMiddleName(eiuc.processInputWithScanner(inputMessage, Regex.REGEX_DATE_UPDATED));

        entry.setDateCreated(LocalDate.now());
        entry.setDateUpdated(LocalDate.now());

        return entry;
    }
}
