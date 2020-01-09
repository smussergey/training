package ua.training.system_what_where_when.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.training.system_what_where_when.dto.GameDTO;
import ua.training.system_what_where_when.model.AnsweredQuestion;
import ua.training.system_what_where_when.model.AppealStage;
import ua.training.system_what_where_when.model.Game;
import ua.training.system_what_where_when.repository.GameRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class GameService {
    @Autowired
    private UserService userService;

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game saveGameTest() {

        List<AnsweredQuestion> answeredQuestionList = new ArrayList<>();
        AnsweredQuestion answeredQuestion1 = new AnsweredQuestion();
        answeredQuestion1.setAppealStage(AppealStage.NOT_FILED);
        answeredQuestion1.setUserWhoGotPoint(userService.findById(11L));

        AnsweredQuestion answeredQuestion2 = new AnsweredQuestion();
        answeredQuestion2.setAppealStage(AppealStage.NOT_FILED);
        answeredQuestion2.setUserWhoGotPoint(null);

        AnsweredQuestion answeredQuestion3 = new AnsweredQuestion();
        answeredQuestion3.setAppealStage(AppealStage.NOT_FILED);
        answeredQuestion3.setUserWhoGotPoint(null);

        answeredQuestionList.add(answeredQuestion1);
        answeredQuestionList.add(answeredQuestion2);
        answeredQuestionList.add(answeredQuestion3);

        Game game = new Game();
        game.setDate(LocalDate.now());
        game.setUser(userService.findById(11L));
        game.setAppealStage(AppealStage.NOT_FILED);
        game.addAnsweredQuestions(answeredQuestionList);

        return gameRepository.save(game);
    }

    public List<GameDTO> getGameStatistics() {
        List<Game> games = findAllGames();
        return games.stream()
                .map(GameService::toGameDTO)
                .collect(Collectors.toList());
    }

    private static GameDTO toGameDTO(Game game) {
        GameDTO gameDTO = new GameDTO();
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

    private Long id;
    private LocalDate date;
    private String userName;
    private String scores;
    private String appealStage;

    public List<Game> findAllGames() {
        return gameRepository.findAll();
    }
}
