package ua.training.system_what_where_when.model;

import lombok.AccessLevel;
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
    private Long id;
    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JoinColumn(name = "appeal_is_enabled")
    private boolean appealIsEnabled;

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

    public void removeArticle(AnsweredQuestion answeredQuestion) {
        answeredQuestions.remove(answeredQuestion);
        answeredQuestion.setGame(null);
    }
}
