package ua.training.system_what_where_when.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.training.system_what_where_when.model.AnsweredQuestion;
import ua.training.system_what_where_when.model.AppealStage;
import ua.training.system_what_where_when.model.Game;
import ua.training.system_what_where_when.repository.GameRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class GameService {
    @Autowired //delete
    private UserService userService;

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game saveGameTest() {

        List<AnsweredQuestion> answeredQuestionList = new ArrayList<>();
        AnsweredQuestion answeredQuestion1 = new AnsweredQuestion();
        answeredQuestion1.setAppealStage(AppealStage.NOT_FILED);
        answeredQuestion1.setUserWhoGotPoint(userService.findById(10L));

        AnsweredQuestion answeredQuestion2 = new AnsweredQuestion();
        answeredQuestion2.setAppealStage(AppealStage.NOT_FILED);
        answeredQuestion2.setUserWhoGotPoint(userService.findById(10L));

        AnsweredQuestion answeredQuestion3 = new AnsweredQuestion();
        answeredQuestion3.setAppealStage(AppealStage.NOT_FILED);

        answeredQuestionList.add(answeredQuestion1);
        answeredQuestionList.add(answeredQuestion2);
        answeredQuestionList.add(answeredQuestion3);

        Game game = new Game();
        game.setDate(LocalDate.now());
        game.setUser(userService.findById(10L));
        game.setAppealIsEnabled(true);
        game.addAnsweredQuestions(answeredQuestionList);

        return gameRepository.save(game);
    }

}
