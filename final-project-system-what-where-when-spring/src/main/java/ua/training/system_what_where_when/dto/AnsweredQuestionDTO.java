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
    private int number; // TODO check where it is used
    private String nameWhoGotPointUa;
    private String nameWhoGotPointEn;
    private boolean isAppealPossible;
    private String appealStage;
}
