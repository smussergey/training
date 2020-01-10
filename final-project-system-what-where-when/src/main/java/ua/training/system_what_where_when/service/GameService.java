package ua.training.system_what_where_when.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ua.training.system_what_where_when.dto.GameDTO;
import ua.training.system_what_where_when.exception.EntityNotFoundException;
import ua.training.system_what_where_when.model.AnsweredQuestion;
import ua.training.system_what_where_when.model.AppealStage;
import ua.training.system_what_where_when.model.Game;
import ua.training.system_what_where_when.model.User;
import ua.training.system_what_where_when.repository.GameRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class GameService {
    @Autowired
    private UserService userService;

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public GameDTO runNewGame(Long teamId) {
        Game game = generateNewGameResults(teamId);
        gameRepository.save(game);
        return toGameDTO(game);
    }

    private Game generateNewGameResults(Long teamId) {
        int teamCorrectAnswerCount = 0;
        int teamWrongAnswerCount = 0;
        List<AnsweredQuestion> answeredQuestionList = new ArrayList<>();
        User playingTeam = userService.findById(teamId);

        while (true) {
            AnsweredQuestion answeredQuestion = generateAnsweredQuestion(playingTeam);
            answeredQuestionList.add(answeredQuestion);
            if (answeredQuestion.getUserWhoGotPoint() != null) {
                teamCorrectAnswerCount++;
            } else teamWrongAnswerCount++;

            if (teamCorrectAnswerCount == 6 || teamWrongAnswerCount == 6) { // TODO move "6" to properties
                break;
            }
        }

        Game game = new Game();
        game.setDate(LocalDate.now());
        game.setUser(playingTeam);
        game.setAppealStage(AppealStage.NOT_FILED);
        game.addAnsweredQuestions(answeredQuestionList);

        return game;
    }

    private AnsweredQuestion generateAnsweredQuestion(User playingTeam) {
        AnsweredQuestion answeredQuestion = new AnsweredQuestion();
        answeredQuestion.setAppealStage(AppealStage.NOT_FILED);
        if (ThreadLocalRandom.current().nextBoolean()) {
            answeredQuestion.setUserWhoGotPoint(playingTeam);
        } else {
            answeredQuestion.setUserWhoGotPoint(null);

        }
        return answeredQuestion;
    }

    public List<GameDTO> getGameStatisticsByAllTeams() {
        List<Game> games = findAllGames();
        return games.stream()
                .map(GameService::toGameDTO)
                .collect(Collectors.toList());
    }

    public List<GameDTO> getGameStatisticsByLoginedTeam() {
        List<Game> games = findAllGamesByTeam(userService.findLoginedUser());
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

    public List<Game> findAllGamesByTeam(User team) {
        return gameRepository.findByUser(team)
                .orElseThrow(() -> new EntityNotFoundException("Can not fond games with team: " + team.getEmail()));
    }


    public List<Game> findAllGames() {
        return gameRepository.findAll();
    }
}
