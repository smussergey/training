package ua.training.system_what_where_when.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "is_appeal_possible")
    private boolean isAppealPossible;

    @Enumerated(EnumType.STRING)
    @Column(name = "appeal_stage")
    private AppealStage appealStage;

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
