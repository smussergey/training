package ua.training.system_what_where_when.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.training.system_what_where_when.model.Game;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameWithAnsweredQuestionDTO {
    private Long id;
    private LocalDate date;
    private String userName;
    private String scores;
    private String appealStage;
    private List<AnsweredQuestionDTO> answeredQuestionDTOs = new ArrayList<>();

    public static GameWithAnsweredQuestionDTO toGameDTO(Game game) {
        GameWithAnsweredQuestionDTO gameDTO = new GameWithAnsweredQuestionDTO();

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

        List<AnsweredQuestionDTO> answeredQuestionDTOs = game.getAnsweredQuestions()
                .stream()
                .map(AnsweredQuestionDTO::toAnsweredQuestionDTO)
                .collect(Collectors.toList());

        gameDTO.setAnsweredQuestionDTOs(answeredQuestionDTOs);

        return gameDTO;
    }

}
