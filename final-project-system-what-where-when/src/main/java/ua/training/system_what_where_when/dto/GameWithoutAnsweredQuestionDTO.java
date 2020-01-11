package ua.training.system_what_where_when.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.training.system_what_where_when.model.Game;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameWithoutAnsweredQuestionDTO {
    private Long id;
    private LocalDate date;
    private String userName;
    private String scores;
    private String appealStage;

    public static GameWithoutAnsweredQuestionDTO toGameDTO(Game game) {
        GameWithoutAnsweredQuestionDTO gameDTO = new GameWithoutAnsweredQuestionDTO();

        gameDTO.setId(game.getId());
        gameDTO.setDate(game.getDate());
        gameDTO.setUserName(game.getUser().getNameUa()); //TODO correct for different locale
        gameDTO.setAppealStage(game.getAppealStage().name());

        int teamsCorrectAnswers = (int) game.getAnsweredQuestions()
                .stream()
                .filter(answeredQuestion -> answeredQuestion.getUserWhoGotPoint() != null)
                .count();
        int teamsWrongAnswers = game.getAnsweredQuestions().size() - teamsCorrectAnswers;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(teamsCorrectAnswers);
        stringBuilder.append(':');//TODO move ":" to properties
        stringBuilder.append(teamsWrongAnswers);
        String scores = stringBuilder.toString();
        gameDTO.setScores(scores);
        return gameDTO;
    }

}
