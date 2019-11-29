package ua.training.controller;

public interface Regex {
    // Cyrillic
    String REGEX_LAST_NAME_UKR = "^[А-ЩЬЮЯҐІЇЄ]{1}[а-щьюяґіїє']{1,}$";
    String REGEX_FIRST_NAME_UKR = "^[А-ЩЬЮЯҐІЇЄ]{1}[а-щьюяґіїє']{1,}$";
    String REGEX_MIDDLE_NAME_UKR = "^[А-ЩЬЮЯҐІЇЄ]{1}[а-щьюяґіїє']{1,}$";
    String REGEX_MARITAL_STATUS_UKR = "^(Single||Married)$"; //TODO correct
    String REGEX_ADDRESS_UKR = "^\\w{0,}$";  //TODO correct

    // Latin
    String REGEX_LAST_NAME_LAT = "^[A-Z]{1}[a-z]{1,}$";
    String REGEX_FIRST_NAME_LAT = "^[A-Z]{1}[a-z]{1,}$";
    String REGEX_MIDDLE_NAME_LAT = "^[A-Z]{1}[a-z]{1,}$";
    String REGEX_NICKNAME = "^\\w{0,}$";
    String REGEX_COMMENT = "^.{0,}$";
    String REGEX_MARITAL_STATUS_LAT = "^(Single||Married)$";
    String REGEX_PHONE_NUMBER_HOME_OR_MOBILE = "^\\+\\d{5}-\\d{3}-\\d{2}-\\d{2}$";
    String REGEX_PHONE_NUMBER_MOBILE_ADDITIONAL = "^(\\+\\d{5}-\\d{3}-\\d{2}-\\d{2})||-$"; //TODO correct "-"
    String REGEX_EMAIL = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    String REGEX_SKYPE = "^\\w{0,}$"; //TODO check
    String REGEX_ADDRESS_LAT = "^\\w{0,}$";  //TODO correct
//    String REGEX_DATE_CREATED = "^\\d{4}+.{1}\\d{2}+.{1}\\d{2}$"; //TODO correct
//    String REGEX_DATE_UPDATED = "^\\d{4}+.{1}\\d{2}+.{1}\\d{2}$"; //TODO correct
}
