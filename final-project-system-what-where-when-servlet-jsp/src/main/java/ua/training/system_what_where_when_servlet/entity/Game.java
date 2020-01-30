package ua.training.system_what_where_when_servlet.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private Integer id;
    private LocalDate date;
    private List<User> users = new ArrayList<>();
    private List<Appeal> appeals = new ArrayList<>();
    private List<AnsweredQuestion> answeredQuestions = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Appeal> getAppeals() {
        return appeals;
    }

    public void setAppeals(List<Appeal> appeals) {
        this.appeals = appeals;
    }

    public List<AnsweredQuestion> getAnsweredQuestions() {
        return answeredQuestions;
    }

    public void setAnsweredQuestions(List<AnsweredQuestion> answeredQuestions) {
        this.answeredQuestions = answeredQuestions;
    }
}
