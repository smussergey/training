package training.model;

import java.util.Arrays;

public class Entry {
    private String name;
    private String login;

    public Entry(String name, String login) {
        if (Arrays.stream(EntryDataBase.values()).anyMatch(val -> val.isLoginExistInDb(login))) {
            throw new DuplicateLoginException(login);
        }

        this.name = name;
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "name='" + name + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}