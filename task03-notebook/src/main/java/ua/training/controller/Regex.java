package ua.training.controller;

public interface Regex {

    String REGEX_LAST_NAME = "^[A-Z]{1}[a-z]{0,}$";
    String REGEX_FIRST_NAME = "^[A-Z]{1}[a-z]{0,}$";
    String REGEX_MIDDLE_NAME = "^[A-Z]{1}[a-z]{0,}$";
    String NICKNAME = "[A-Z]{1}[a-z]{0,}";
    String COMMENT = "comment:";
    String MARITAL_STATUS = "marital status:";
    String PHONE_NUMBER_HOME = "home phone number:";
    String PHONE_NUMBER_MOBILE_MAIN = "mobile phone number:";
    String PHONE_NUMBER_MOBILE_ADDITIONAL = "additional mobile phone number, in case you have:";
    String EMAIL = "email:";
    String SKYPE = "skype:";
    String ADDRESS = "address";
    String INPUT_DATE = "input date:";
    String MODIFIED_DATE = "modified date:";
}
