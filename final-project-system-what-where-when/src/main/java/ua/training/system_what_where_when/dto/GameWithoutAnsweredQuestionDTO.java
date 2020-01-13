package ua.training.system_what_where_when.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.training.system_what_where_when.model.Game;
import ua.training.system_what_where_when.model.GameStatus;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameWithoutAnsweredQuestionDTO {
    private Long id;
    private LocalDate date;
    private String nameUa;
    private String nameEn;
    private String scores;
    private String gameStatus;
    private String appealStage;

    public static GameWithoutAnsweredQuestionDTO toGameDTO(Game game) {
        GameWithoutAnsweredQuestionDTO gameDTO = new GameWithoutAnsweredQuestionDTO();

        gameDTO.setId(game.getId());
        gameDTO.setDate(game.getDate());
        gameDTO.setNameUa(game.getUser().getNameUa());
        gameDTO.setNameEn(game.getUser().getNameEn());

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

        if ((teamsCorrectAnswers > teamsWrongAnswers)) {
            gameDTO.setGameStatus(GameStatus.WON.name());
        } else {
            gameDTO.setGameStatus(GameStatus.LOST.name());
        }

        gameDTO.setAppealStage(game.getAppealStage().name());
        return gameDTO;
    }

}
