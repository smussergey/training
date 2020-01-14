package ua.training.system_what_where_when.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.training.system_what_where_when.model.AnsweredQuestion;
import ua.training.system_what_where_when.util.ResourceBundleUtil;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnsweredQuestionDTO {
    private Long id;
    private int number;
    private String nameUa;
    private String nameEn;
    private boolean isAppealPossible;
    private String appealStage;

    public static AnsweredQuestionDTO toAnsweredQuestionDTO(AnsweredQuestion answeredQuestion) {
        AnsweredQuestionDTO answeredQuestionDTO = new AnsweredQuestionDTO();
        answeredQuestionDTO.setId(answeredQuestion.getId());

        if (answeredQuestion.getUserWhoGotPoint() != null) {
            answeredQuestionDTO.setNameUa(answeredQuestion.getUserWhoGotPoint().getNameUa());
            answeredQuestionDTO.setNameEn(answeredQuestion.getUserWhoGotPoint().getNameEn());
        }

        answeredQuestionDTO.setAppealStage(
                ResourceBundleUtil.getBundleStringForAppealStage(
                        answeredQuestion.getAppealStage().name()));
        answeredQuestionDTO.setAppealPossible(answeredQuestion.isAppealPossible());

        return answeredQuestionDTO;
    }
}
