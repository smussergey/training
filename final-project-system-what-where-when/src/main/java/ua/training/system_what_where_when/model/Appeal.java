package ua.training.system_what_where_when.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "appeal")
public class Appeal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "appeal_id")
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(name = "appeal_stage")
    private AppealStage appealStage;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
}
