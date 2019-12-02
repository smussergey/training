package ua.training.controller;

public interface Regex {
    // Cyrillic
    String REGEX_LAST_NAME_UKR = "^[А-ЩЬЮЯҐІЇЄ]{1}[а-щьюяґіїє']{1,}$";
    String REGEX_FIRST_NAME_UKR = "^[А-ЩЬЮЯҐІЇЄ]{1}[а-щьюяґіїє']{1,}$";
    String REGEX_MIDDLE_NAME_UKR = "^[А-ЩЬЮЯҐІЇЄ]{1}[а-щьюяґіїє']{1,}$";
    String REGEX_CITY_UKR = "^[А-ЩЬЮЯҐІЇЄа-щьюяґіїє']{1,}$";
    String REGEX_STREET_UKR = "^[А-ЩЬЮЯҐІЇЄа-щьюяґіїє'0-9]{1,}$";
    String REGEX_BUILDING_NUMBER_UKR = "^[А-ЩЬЮЯҐІЇЄа-щьюяґіїє'0-9]{1,}$";
    String REGEX_APARTMENT_NUMBER_UKR = "^[А-ЩЬЮЯҐІЇЄа-щьюяґіїє'0-9]{1,}$";;

    // Latin or default
    String REGEX_LAST_NAME_LAT = "^[A-Z]{1}[a-z]{1,}$";
    String REGEX_FIRST_NAME_LAT = "^[A-Z]{1}[a-z]{1,}$";
    String REGEX_MIDDLE_NAME_LAT = "^[A-Z]{1}[a-z]{1,}$";
    String REGEX_NICKNAME = "^\\w{0,}$";
    String REGEX_COMMENT = "^.{0,}$";
    String REGEX_MARITAL_STATUS = "^(0||1)$";
    String REGEX_PHONE_NUMBER_HOME_OR_MOBILE = "^\\+\\d{5}-\\d{3}-\\d{2}-\\d{2}$";
    String REGEX_PHONE_NUMBER_MOBILE_ADDITIONAL = "^(\\+\\d{5}-\\d{3}-\\d{2}-\\d{2})||-$";
    String REGEX_EMAIL = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    String REGEX_SKYPE = "^\\w{0,}$";
    String REGEX_POST_CODE = "^\\d{1,6}$";
    String REGEX_CITY_LAT = "^[A-Za-z]{1,}$";
    String REGEX_STREET_LAT = "^[A-Za-z0-9]{1,}$";
    String REGEX_BUILDING_NUMBER_LAT = "^[A-Za-z0-9]{1,}$";
    String REGEX_APARTMENT_NUMBER_LAT = "^[A-Za-z0-9]{1,}$";
}
