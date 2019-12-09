package training.controller;

public interface Regex {
    // Cyrillic
    String REGEX_LAST_NAME_UKR = "^[А-ЩЬЮЯҐІЇЄ]{1}[а-щьюяґіїє']{1,}$";

    // Latin or default
    String REGEX_LAST_NAME_LAT = "^[A-Z]{1}[a-z]{1,}$";
    String REGEX_NICKNAME = "^\\w{0,}$";
}
