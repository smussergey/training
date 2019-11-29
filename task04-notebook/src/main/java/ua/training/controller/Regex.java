package ua.training.controller;

public interface Regex {

    String REGEX_LAST_NAME = "^[A-Z]{1}[a-z]{0,}$";
    String REGEX_FIRST_NAME = "^[A-Z]{1}[a-z]{0,}$";
    String REGEX_MIDDLE_NAME = "^[A-Z]{1}[a-z]{0,}$";
    String REGEX_NICKNAME = "^\\w{0,}$";
    String REGEX_COMMENT = "^.{0,}$";
    String REGEX_MARITAL_STATUS = "^(Single||Married)$";
    String REGEX_PHONE_NUMBER_HOME = "^\\+\\d{2}\\d{3}-\\d{3}-\\d{2}-\\d{2}$";
    String REGEX_PHONE_NUMBER_MOBILE_MAIN = "^\\+\\d{2}\\d{3}-\\d{3}-\\d{2}-\\d{2}$";
    String REGEX_PHONE_NUMBER_MOBILE_ADDITIONAL = "^(\\+\\d{2}\\d{3}-\\d{3}-\\d{2}-\\d{2})||-$"; //TODO correct "-"
    String REGEX_EMAIL = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    String REGEX_SKYPE = "^\\w{0,}$"; //TODO check
    String REGEX_ADDRESS = "^\\w{0,}$";  //TODO correct
//    String REGEX_DATE_CREATED = "^\\d{4}+.{1}\\d{2}+.{1}\\d{2}$"; //TODO correct
//    String REGEX_DATE_UPDATED = "^\\d{4}+.{1}\\d{2}+.{1}\\d{2}$"; //TODO correct
}
