package training.controller;

public interface Regex {
    // Cyrillic
    String NAME_UKR = "^[А-ЩЬЮЯҐІЇЄ]{1}[а-щьюяґіїє']{1,}$";

    // Latin or default
    String NAME_LAT = "^[A-Z]{1}[a-z]{1,}$";
    String LOGIN = "^\\w{0,}$";
}
