package ua.training.system_what_where_when.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "game_id")
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Setter(AccessLevel.PRIVATE)
//    @JoinColumn(name = "user_id")
    @ManyToMany(mappedBy = "games", fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();

    @Column(name = "is_appeal_possible")
    private boolean isAppealPossible;

    @Setter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "game", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<Appeal> appeals = new ArrayList<>();

    public void addAppeal(Appeal appeal) {
        appeals.add(appeal);
        appeal.setGame(this);
    }

    public void addAppeals(List<Appeal> appeals) {
        this.appeals.addAll(appeals);
        appeals.forEach(appeal -> appeal.setGame(this));
    }

    public void removeAppeal(Appeal appeal) {
        appeals.remove(appeal);
        appeal.setGame(null);
    }


    @Setter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "game", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<AnsweredQuestion> answeredQuestions = new ArrayList<>();

    public void addAnsweredQuestion(AnsweredQuestion answeredQuestion) {
        answeredQuestions.add(answeredQuestion);
        answeredQuestion.setGame(this);
    }

    public void addAnsweredQuestions(List<AnsweredQuestion> answeredQuestions) {
        this.answeredQuestions.addAll(answeredQuestions);
        answeredQuestions.forEach(answeredQuestion -> answeredQuestion.setGame(this));
    }

    public void removeAnsweredQuestions(AnsweredQuestion answeredQuestion) {
        answeredQuestions.remove(answeredQuestion);
        answeredQuestion.setGame(null);
    }
}
