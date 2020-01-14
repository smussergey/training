package ua.training.system_what_where_when.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.training.system_what_where_when.dto.GameWithAnsweredQuestionDTO;
import ua.training.system_what_where_when.dto.GameWithoutAnsweredQuestionDTO;
import ua.training.system_what_where_when.exception.EntityNotFoundException;
import ua.training.system_what_where_when.model.AnsweredQuestion;
import ua.training.system_what_where_when.model.AppealStage;
import ua.training.system_what_where_when.model.Game;
import ua.training.system_what_where_when.model.User;
import ua.training.system_what_where_when.repository.GameRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class GameService {
    @Autowired
    private UserService userService;
    @Autowired
    private GameRepository gameRepository;
    private final AnsweredQuestionService answeredQuestionService;

    public GameService(AnsweredQuestionService answeredQuestionService) {
        this.answeredQuestionService = answeredQuestionService;
    }

    public GameWithoutAnsweredQuestionDTO runNewGame(Long teamId, int maxNumberOfScores) {
        Game game = generateNewGameResults(teamId, maxNumberOfScores);
        gameRepository.save(game);
        return GameWithoutAnsweredQuestionDTO.toGameDTO(game);
    }

    private Game generateNewGameResults(Long teamId, int maxNumberOfScores) {
        int teamCorrectAnswerCount = 0;
        int teamWrongAnswerCount = 0;
        List<AnsweredQuestion> answeredQuestionList = new ArrayList<>();
        User playingTeam = userService.findUserById(teamId);

        while (true) {
            AnsweredQuestion answeredQuestion = generateAnsweredQuestion(playingTeam);
            answeredQuestionList.add(answeredQuestion);
            if (answeredQuestion.getUserWhoGotPoint() != null) {
                teamCorrectAnswerCount++;
            } else teamWrongAnswerCount++;

            if (teamCorrectAnswerCount == maxNumberOfScores || teamWrongAnswerCount == maxNumberOfScores) {
                if (teamWrongAnswerCount > teamCorrectAnswerCount) {
                    answeredQuestionList.stream().
                            filter(aq -> aq.getUserWhoGotPoint() == null)
                            .forEach(aq -> aq.setAppealPossible(true));
                }
                break;
            }
        }

        Game game = new Game();
        game.setDate(LocalDate.now());
        game.setUser(playingTeam);
        if (teamWrongAnswerCount > teamCorrectAnswerCount) {
            game.setAppealPossible(true);
        }
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

    public List<GameWithoutAnsweredQuestionDTO> getGameStatisticsByAllTeams() {
        List<Game> games = findAllGames();
        return games.stream()
                .map(GameWithoutAnsweredQuestionDTO::toGameDTO)
                .collect(Collectors.toList());
    }

    public List<GameWithoutAnsweredQuestionDTO> getGameStatisticsByLoginedTeam() {
        List<Game> games = findAllGamesByTeam(userService.findLoggedIndUser());
        return games.stream()
                .map(GameWithoutAnsweredQuestionDTO::toGameDTO)
                .collect(Collectors.toList());
    }

    public GameWithAnsweredQuestionDTO getGameFullStatisticsById(Long id) {
        Game game = findGameById(id); //TODO allow only user's games
        return GameWithAnsweredQuestionDTO.toGameDTO(game);
    }

    public Game findGameById(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Can not fond games with id: " + id));
    }

    public List<Game> findAllGamesByTeam(User team) {
        return gameRepository.findByUser(team)
                .orElseThrow(() -> new EntityNotFoundException("Can not fond games with team: " + team.getEmail()));
    }


    public List<Game> findAllGames() {
        return gameRepository.findAll();
    }

    public void fileAppealAgainstGameAnsweredQuestions(String[] appealedQuestionStringIds) {
        log.info("in GameService: fileAppealAgainstGameAnsweredQuestions() - id: {} successfully was got", appealedQuestionStringIds[0]);
        List<String> iDs = new ArrayList<>(Arrays.asList(appealedQuestionStringIds));

        List<Long> appealedQuestionIds = iDs.stream()
                .map(Long::valueOf)
                .collect(Collectors.toList());

        AnsweredQuestion anyQuestionFromAppealedGame = answeredQuestionService.findAnsweredQuestionById(appealedQuestionIds.
                stream()
                .findAny()
                .get());

        Game appealedGame = anyQuestionFromAppealedGame.getGame();
        log.info("in GameService: fileAppealAgainstGameAnsweredQuestions() - appealedGame: {} successfully was find", appealedGame.getId());

        appealedGame.setAppealPossible(false);
        appealedGame.setAppealStage(AppealStage.FILED);
        appealedGame.getAnsweredQuestions()
                .stream()
                .filter(answeredQuestion -> answeredQuestion.isAppealPossible())
                .map(answeredQuestion -> {
                    answeredQuestion.setAppealPossible(false);
                    return answeredQuestion;
                })
                .filter(answeredQuestion -> appealedQuestionIds.contains(answeredQuestion.getId()))
                .forEach(appealedQuestion -> appealedQuestion.setAppealStage(AppealStage.FILED));
    }

    public void approveAppealAgainstGameAnsweredQuestions(String[] approvedQuestionStringIds) {
        log.info("in GameService: considerAppealAgainstGameAnsweredQuestions() - id: {} successfully was got", approvedQuestionStringIds[0]);
        List<String> iDs = new ArrayList<>(Arrays.asList(approvedQuestionStringIds));

        List<Long> approvedQuestionIds = iDs.stream()
                .map(Long::valueOf)
                .collect(Collectors.toList());

        AnsweredQuestion anyQuestionFromAppealedGame = answeredQuestionService.findAnsweredQuestionById(approvedQuestionIds.
                stream()
                .findAny()
                .get());

        Game appealedGame = anyQuestionFromAppealedGame.getGame();
        log.info("in GameService: fileAppealAgainstGameAnsweredQuestions() - appealedGame: {} successfully was find", appealedGame.getId());

        appealedGame.setAppealStage(AppealStage.CONSIDERED);
        appealedGame.getAnsweredQuestions()
                .stream()
                .filter(answeredQuestion -> answeredQuestion.getAppealStage().equals(AppealStage.FILED))
                .forEach(questionWithAppealStageFiled -> {
                    if (approvedQuestionIds.contains(questionWithAppealStageFiled.getId())) {
                        questionWithAppealStageFiled.setUserWhoGotPoint(appealedGame.getUser());
                        questionWithAppealStageFiled.setAppealStage(AppealStage.WON);
                    } else questionWithAppealStageFiled.setAppealStage(AppealStage.LOST);
                });
    }
}
