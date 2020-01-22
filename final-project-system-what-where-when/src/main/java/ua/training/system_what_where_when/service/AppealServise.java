package ua.training.system_what_where_when.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.training.system_what_where_when.model.AnsweredQuestion;
import ua.training.system_what_where_when.model.Appeal;
import ua.training.system_what_where_when.model.AppealStage;
import ua.training.system_what_where_when.model.Game;
import ua.training.system_what_where_when.repository.AppealRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AppealServise {
    @Autowired
    private AnsweredQuestionService answeredQuestionService;
    @Autowired
    private UserService userService;
    @Autowired
    private final AppealRepository appealRepository;

    public AppealServise(AppealRepository appealRepository) {
        this.appealRepository = appealRepository;
    }

    public Appeal fileAppealAgainstGameAnsweredQuestions(String[] appealedQuestionStringIds) {
        log.info("in AppealServise: fileAppealAgainstGameAnsweredQuestions() - id: {} successfully was got", appealedQuestionStringIds[0]);
        List<AnsweredQuestion> appealedQuestions = Arrays.stream(appealedQuestionStringIds)
                .mapToLong(Long::valueOf)
                .mapToObj(answeredQuestionService::findAnsweredQuestionById)
                .collect(Collectors.toList());

        // TODO check if null is impossible
        Game appealedGame = appealedQuestions.stream()
                .findAny()
                .get()
                .getGame();

        log.info("in AppealServise: fileAppealAgainstGameAnsweredQuestions() - appealedGame: {} successfully was find", appealedGame.getId());

        Appeal appeal = new Appeal();
        appeal.setDate(LocalDate.now());
        appeal.setUser(userService.findLoggedIndUser());
        appeal.setGame(appealedGame);
        appeal.addAnsweredQuestions(appealedQuestions);
        appeal.setAppealStage(AppealStage.FILED);
        return save(appeal);
    }

    public Appeal save(Appeal appeal) {
        return appealRepository.save(appeal);
    }

    public List<Appeal> saveAll(List<Appeal> appeals) {
        return appealRepository.saveAll(appeals);
    }

    public void approveAppealsAgainstGameAnsweredQuestions(String[] approvedQuestionStringIds) {
        log.info("in AppealServise: approveAppealAgainstGameAnsweredQuestions() - id: {} successfully was got", approvedQuestionStringIds[0]);
        List<AnsweredQuestion> answeredQuestionsWithApprovedAppeal = Arrays.stream(approvedQuestionStringIds)
                .mapToLong(Long::valueOf)
                .mapToObj(answeredQuestionService::findAnsweredQuestionById)
                .collect(Collectors.toList());

        answeredQuestionService.saveAll(answeredQuestionsWithApprovedAppeal.stream()
                .peek(aq -> aq.setUserWhoGotPoint(aq.getAppeal().getUser()))
                .collect(Collectors.toList()));

        Game appealedGame = answeredQuestionsWithApprovedAppeal.stream()
                .findAny()
                .get()
                .getGame();


        saveAll(appealedGame.getAppeals().stream()
                .peek(appeal -> appeal.setAppealStage(AppealStage.CONSIDERED))
                .collect(Collectors.toList()));

    }
}
