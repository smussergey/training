package ua.training.system_what_where_when.entity;

import lombok.Data;

import javax.persistence.*;

//TODO add constraints
@Data
@Entity
@Table(name = "answered_question")
public class AnsweredQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "answered_question_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "appeal_id")
    private Appeal appeal;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User userWhoGotPoint;

    // TODO delete this field
    @Column(name = "is_appeal_possible")
    private boolean isAppealPossible;

    @Enumerated(EnumType.STRING)
    @Column(name = "appeal_stage")
    private AppealStage appealStage;


}
