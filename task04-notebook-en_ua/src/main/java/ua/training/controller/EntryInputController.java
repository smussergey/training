package ua.training.controller;

import ua.training.model.Address;
import ua.training.model.Entry;
import ua.training.model.MaritalStatus;
import ua.training.view.TextConstant;
import ua.training.view.View;

import java.time.LocalDate;
import java.util.Scanner;

import static ua.training.controller.Regex.*;

public class EntryInputController {
    private Scanner scanner;
    private View view;

    public EntryInputController(Scanner scanner, View view) {
        this.scanner = scanner;
        this.view = view;
    }

    public Entry processEntryInput() {
        Entry entry = new Entry();
        Address address = new Address();
        EntryInputUtilityController eiuc = new EntryInputUtilityController(scanner, view);
        String inputMessage;
        String inputRegex;

        inputMessage = view.concatenateBundleStrings(TextConstant.INPUT_DATA, TextConstant.LAST_NAME);
        inputRegex = (String.valueOf(View.bundle.getLocale()).equals("ua"))
                ? REGEX_LAST_NAME_UKR : REGEX_LAST_NAME_LAT;
        entry.setLastName(eiuc.processInputWithScanner(inputMessage, inputRegex));

        inputMessage = view.concatenateBundleStrings(TextConstant.INPUT_DATA, TextConstant.FIRST_NAME);
        inputRegex = (String.valueOf(View.bundle.getLocale()).equals("ua"))
                ? REGEX_FIRST_NAME_UKR : REGEX_FIRST_NAME_LAT;
        entry.setFirstName(eiuc.processInputWithScanner(inputMessage, inputRegex));

        inputMessage = view.concatenateBundleStrings(TextConstant.INPUT_DATA, TextConstant.MIDDLE_NAME);
        inputRegex = (String.valueOf(View.bundle.getLocale()).equals("ua"))
                ? REGEX_MIDDLE_NAME_UKR : REGEX_MIDDLE_NAME_LAT;
        entry.setMiddleName(eiuc.processInputWithScanner(inputMessage, inputRegex));

        inputMessage = view.concatenateBundleStrings(TextConstant.INPUT_DATA, TextConstant.NICKNAME);
        inputRegex = REGEX_NICKNAME;
        entry.setNickName(eiuc.processInputWithScanner(inputMessage, inputRegex));

        inputMessage = view.concatenateBundleStrings(TextConstant.INPUT_DATA, TextConstant.COMMENT);
        inputRegex = REGEX_COMMENT;
        entry.setComment(eiuc.processInputWithScanner(inputMessage, inputRegex));

        inputMessage = view.concatenateBundleStrings(TextConstant.INPUT_DATA, TextConstant.MARITAL_STATUS);
        inputRegex = REGEX_MARITAL_STATUS;
        String maritalStatus = eiuc.processInputWithScanner(inputMessage, inputRegex);
        if (maritalStatus.equals("0")) {
            entry.setMaritalStatus(MaritalStatus.SINGLE);
        } else if (maritalStatus.equals("1")) {
            entry.setMaritalStatus(MaritalStatus.MARRIED);
        }

        inputMessage = view.concatenateBundleStrings(TextConstant.INPUT_DATA, TextConstant.PHONE_NUMBER_HOME);
        inputRegex = REGEX_PHONE_NUMBER_HOME_OR_MOBILE;
        entry.setPhoneNumberHome(eiuc.processInputWithScanner(inputMessage, inputRegex));

        inputMessage = view.concatenateBundleStrings(TextConstant.INPUT_DATA, TextConstant.PHONE_NUMBER_MOBILE_MAIN);
        inputRegex = REGEX_PHONE_NUMBER_HOME_OR_MOBILE;
        entry.setPhoneNumberMobileMain(eiuc.processInputWithScanner(inputMessage, inputRegex));

        inputMessage = view.concatenateBundleStrings(TextConstant.INPUT_DATA, TextConstant.PHONE_NUMBER_MOBILE_ADDITIONAL);
        inputRegex = REGEX_PHONE_NUMBER_MOBILE_ADDITIONAL;
        entry.setPhoneNumberMobileAdditional(eiuc.processInputWithScanner(inputMessage, inputRegex));

        inputMessage = view.concatenateBundleStrings(TextConstant.INPUT_DATA, TextConstant.EMAIL);
        inputRegex = REGEX_EMAIL;
        entry.setEmail(eiuc.processInputWithScanner(inputMessage, inputRegex));

        inputMessage = view.concatenateBundleStrings(TextConstant.INPUT_DATA, TextConstant.SKYPE);
        inputRegex = REGEX_SKYPE;
        entry.setSkype(eiuc.processInputWithScanner(inputMessage, inputRegex));

        inputMessage = view.concatenateBundleStrings(TextConstant.INPUT_DATA, TextConstant.ADDRESS, TextConstant.POST_CODE);
        inputRegex = REGEX_POST_CODE;
        address.setPostCode(eiuc.processInputWithScanner(inputMessage, inputRegex));

        inputMessage = view.concatenateBundleStrings(TextConstant.INPUT_DATA, TextConstant.CITY);
        inputRegex = (String.valueOf(View.bundle.getLocale()).equals("ua"))
                ? REGEX_CITY_UKR : REGEX_CITY_LAT;
        address.setCity(eiuc.processInputWithScanner(inputMessage, inputRegex));

        inputMessage = view.concatenateBundleStrings(TextConstant.INPUT_DATA, TextConstant.STREET);
        inputRegex = (String.valueOf(View.bundle.getLocale()).equals("ua"))
                ? REGEX_STREET_UKR : REGEX_STREET_LAT;
        address.setStreet(eiuc.processInputWithScanner(inputMessage, inputRegex));

        inputMessage = view.concatenateBundleStrings(TextConstant.INPUT_DATA, TextConstant.BUILDING_NUMBER);
        inputRegex = (String.valueOf(View.bundle.getLocale()).equals("ua"))
                ? REGEX_BUILDING_NUMBER_UKR : REGEX_BUILDING_NUMBER_LAT;
        address.setBuildingNumber(eiuc.processInputWithScanner(inputMessage, inputRegex));

        inputMessage = view.concatenateBundleStrings(TextConstant.INPUT_DATA, TextConstant.APARTMENT_NUMBER);
        inputRegex = (String.valueOf(View.bundle.getLocale()).equals("ua"))
                ? REGEX_APARTMENT_NUMBER_UKR : REGEX_APARTMENT_NUMBER_LAT;
        address.setApartmentNumber(eiuc.processInputWithScanner(inputMessage, inputRegex));

        entry.setAddress(address);
        entry.setDateCreated(LocalDate.now());
        entry.setDateUpdated(LocalDate.now());

        return entry;
    }
}
