package ua.training.system_what_where_when.model.entity.enums;

import java.util.ArrayList;

public class User {
    private Long id;
    private String nameUa;
    private String nameEn;
    private String email;
    private String password;
    private Role role;
//    private List<Game> games = new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                '}';
    }
}
