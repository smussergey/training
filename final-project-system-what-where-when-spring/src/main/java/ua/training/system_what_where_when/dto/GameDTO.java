package ua.training.system_what_where_when.dto;

import lombok.*;
import ua.training.system_what_where_when.model.Game;
import ua.training.system_what_where_when.model.GameStatus;
import ua.training.system_what_where_when.util.ResourceBundleUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(of = "id")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameDTO {
    private Long id;
    private LocalDate date;
    private String playerNameUa;
    private String playerNameEn;
    private String opponentNameUa;
    private String opponentNameEn;
    private String scores;
    private String appealStage;
    private boolean isAppealPossible;
    private List<AnsweredQuestionDTO> answeredQuestionDTOs = new ArrayList<>();
}
