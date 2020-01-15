package com.company.model.entity;

public enum DBNoteBook {
    NOTE_ONE   ("Тарас", "taras123"),
    NOTE_TWO   ("Микола", "nik12345"),
    NOTE_THREE ("Петро", "shoko123");

    private final String firstName;
    private final String login;

    DBNoteBook(String firstName, String login) {
        this.firstName = firstName;
        this.login = login;
    }
    public String getName() { return firstName; }
    public String getLogin() { return login; }

    public static boolean checkLogin (String loginData){
        for (DBNoteBook note : DBNoteBook.values()) {
            if (note.getLogin().equals(loginData)) {
                return true;
            }
        }
        return false;
    }

}
