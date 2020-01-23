package ua.training.system_what_where_when.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.training.system_what_where_when.model.Game;
import ua.training.system_what_where_when.model.GameStatus;
import ua.training.system_what_where_when.util.ResourceBundleUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
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
