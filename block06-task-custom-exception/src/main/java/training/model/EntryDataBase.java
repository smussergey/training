package training.model;

import java.util.Arrays;

public enum EntryDataBase {
    IVANOV("Ivanov", "Ivlog"),
    PETROV("Petrov", "Petlog"),
    SIDOROV("Sidorov", "Sidlog");

    private String name;
    private String login;

    EntryDataBase(String name, String login) {
        this.name = name;
        this.login = login;
    }

    public boolean isLoginExistInDb(String newLogin) {
        return Arrays.stream(EntryDataBase.values())
                .anyMatch(val -> val.login.equals(newLogin));
    }
}
