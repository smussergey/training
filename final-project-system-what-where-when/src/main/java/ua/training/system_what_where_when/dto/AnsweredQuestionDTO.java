package ua.training.system_what_where_when.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.training.system_what_where_when.model.AnsweredQuestion;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnsweredQuestionDTO {
    private Long id;
    private String userName;
    private String appealStage;

    public static AnsweredQuestionDTO toAnsweredQuestionDTO(AnsweredQuestion answeredQuestion) {
        AnsweredQuestionDTO answeredQuestionDTO = new AnsweredQuestionDTO();

        answeredQuestionDTO.setId(answeredQuestion.getId());
        if (answeredQuestion.getUserWhoGotPoint() != null) {
            answeredQuestionDTO.setUserName(answeredQuestion.getUserWhoGotPoint().getNameUa());
        }
        answeredQuestionDTO.setAppealStage(answeredQuestion.getAppealStage().name()); //TODO correct for different locale
        return answeredQuestionDTO;
    }
}
