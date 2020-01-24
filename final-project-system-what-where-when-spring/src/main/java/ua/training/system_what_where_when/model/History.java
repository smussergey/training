package ua.training.system_what_where_when.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

//TODO add constraints
@Data
@Entity
@Table(name = "game_history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "game_id")
    private Long id;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "player_name_ua")
    private String playerNameUa;
    @Column(name = "player_name_en")
    private String playerNameEn;
    @Column(name = "opponent_name_ua")
    private String opponentNameUa;
    @Column(name = "opponent_name_en")
    private String opponentNameEn;
    @Column(name = "scores")
    private String scores;
    @Column(name = "appeal_stage")
    private String appealStage;
}
