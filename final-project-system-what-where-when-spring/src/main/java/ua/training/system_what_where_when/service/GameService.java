package ua.training.system_what_where_when.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import ua.training.system_what_where_when.dto.AnsweredQuestionDTO;
import ua.training.system_what_where_when.dto.GameDTO;
import ua.training.system_what_where_when.exception.EntityNotFoundException;
import ua.training.system_what_where_when.model.*;
import ua.training.system_what_where_when.repository.GameRepository;
import ua.training.system_what_where_when.util.ResourceBundleUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Slf4j
@Service
public class GameService {

    private static final Long DEFAULT_IDENTIFIER_IF_OPPONENT_IS_AUDIENCE = 0L;
    private static final String DELIMITER = ":";
    @Autowired
    private UserService userService;
    @Autowired
    private GameRepository gameRepository;
    private final AnsweredQuestionService answeredQuestionService;

    public GameService(AnsweredQuestionService answeredQuestionService) {
        this.answeredQuestionService = answeredQuestionService;
    }

    public Game runNewGame(Long teamId, Long opponentId, int maxNumberOfScores) {
        Game game;
        if (opponentId.equals(DEFAULT_IDENTIFIER_IF_OPPONENT_IS_AUDIENCE)) {
            game = generateNewGameResultsWithAudience(teamId, maxNumberOfScores);
        } else game = generateNewGameResultsWithAnotherTeam(teamId, opponentId, maxNumberOfScores);

        return save(game);
    }

    private Game generateNewGameResultsWithAudience(Long teamId, int maxNumberOfScores) {
        int playingTeamScoreCount = 0;
        int opponentAudienceScoreCount = 0;
        List<AnsweredQuestion> answeredQuestionList = new ArrayList<>();
        User playingTeam = userService.findUserById(teamId);

        while (true) {
            AnsweredQuestion answeredQuestion = generateAnsweredQuestion(playingTeam, null);
            answeredQuestionList.add(answeredQuestion);
            if (playingTeam.equals(answeredQuestion.getUserWhoGotPoint())) {
                playingTeamScoreCount++;
            } else {
                opponentAudienceScoreCount++;
            }

            if (playingTeamScoreCount == maxNumberOfScores
                    || opponentAudienceScoreCount == maxNumberOfScores
            ) {
                break;
            }
        }

        Game game = new Game();
        game.setDate(LocalDate.now());
        game.addUser(playingTeam);
        game.addAnsweredQuestions(answeredQuestionList);
        return game;
    }

    private Game generateNewGameResultsWithAnotherTeam(Long teamId, Long opponentId, int maxNumberOfScores) {
        int playingTeamScoreCount = 0;
        int opponentTeamScoreCount = 0;
        List<AnsweredQuestion> answeredQuestionList = new ArrayList<>();

        User playingTeam = userService.findUserById(teamId);
        User opponent = userService.findUserById(opponentId);

        while (true) {
            AnsweredQuestion answeredQuestion = generateAnsweredQuestion(playingTeam, opponent);
            answeredQuestionList.add(answeredQuestion);
            if (playingTeam.equals(answeredQuestion.getUserWhoGotPoint())) {
                playingTeamScoreCount++;
            } else {
                opponentTeamScoreCount++;
            }

            if (playingTeamScoreCount == maxNumberOfScores
                    || opponentTeamScoreCount == maxNumberOfScores) {
                break;
            }
        }

        Game game = new Game();
        game.setDate(LocalDate.now());
        game.addUser(playingTeam);
        game.addUser(opponent);
        game.addAnsweredQuestions(answeredQuestionList);
        return game;
    }

    private AnsweredQuestion generateAnsweredQuestion(User playingTeam, @Nullable User opponent) {
        AnsweredQuestion answeredQuestion = new AnsweredQuestion();
        if (ThreadLocalRandom.current().nextBoolean()) {
            answeredQuestion.setUserWhoGotPoint(playingTeam);
        } else {
            answeredQuestion.setUserWhoGotPoint(opponent);
        }
        return answeredQuestion;
    }

    public List<GameDTO> getGameStatisticsByAllGames() {
        List<Game> games = findAllGames();
        return games.stream()
                .map(game -> toGameDTO(game))
                .collect(Collectors.toList());
    }

    private GameDTO toGameDTO(Game game) {
        GameDTO gameDTO = new GameDTO();

        gameDTO.setId(game.getId());
        gameDTO.setDate(game.getDate());
        gameDTO.setPlayerNameUa(game.getUsers().stream()
                .findFirst()
                .get()
                .getNameUa());
        gameDTO.setPlayerNameEn(game.getUsers().stream()
                .findFirst()
                .get()
                .getNameEn());

        if (game.getUsers().size() > 1) { //TODO correct
            gameDTO.setOpponentNameUa(game.getUsers().get(1).getNameUa());
            gameDTO.setOpponentNameEn(game.getUsers().get(1).getNameEn());
        } else {
            gameDTO.setOpponentNameUa(ResourceBundleUtil.getBundleString("games.game.statistics.text.audience"));
            gameDTO.setOpponentNameEn(ResourceBundleUtil.getBundleString("games.game.statistics.text.audience"));
        }

        User firstPlayer = game.getUsers().get(0); //TODO correct
        long firstPlayerScores = game.getAnsweredQuestions()
                .stream()
                .filter(aq -> firstPlayer.equals(aq.getUserWhoGotPoint()))
                .count();

        long secondPlayerScores = game.getAnsweredQuestions()
                .stream()
                .count() - firstPlayerScores;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(firstPlayerScores);
        stringBuilder.append(DELIMITER);//TODO move ":" to properties
        stringBuilder.append(secondPlayerScores);
        String scores = stringBuilder.toString();
        gameDTO.setScores(scores);


        if (game.getAppeals().size() > 0) {
            gameDTO.setAppealStage(ResourceBundleUtil.getBundleStringForAppealStage(AppealStage.FILED.name())); //TODO correct
        } else
            gameDTO.setAppealStage(ResourceBundleUtil.getBundleStringForAppealStage(AppealStage.NOT_FILED.name())); //TODO correct
        return gameDTO;
    }

    public List<GameDTO> getGamesStatisticsByLoggedInTeam() {
        return findAllGamesByTeam(userService.findLoggedIndUser()).stream()
                .map(game -> toGameDTO(game))
                .collect(Collectors.toList());
    }

    public GameDTO getGameFullStatisticsById(Long id) {
        Game game = findGameById(id); //TODO check/allow only user's games
        GameDTO gameDTO = toGameDTO(game);

        List<AnsweredQuestionDTO> answeredQuestions = game.getAnsweredQuestions().stream()
                .map(aq -> answeredQuestionService.toAnsweredQuestionDTO(aq))
                .collect(Collectors.toList());

        gameDTO.setAnsweredQuestionDTOs(answeredQuestions);
        gameDTO.setAppealPossible(checkIfLoggedInUserCanFileAppealAgainstGame(game));

        return gameDTO;
    }

    // TODO improve this method
    private boolean checkIfLoggedInUserCanFileAppealAgainstGame(Game game) {

        if (!game.getAppeals().isEmpty()) {
            return !game.getAppeals().stream()
                    .filter(appeal -> appeal.getUser().equals(userService.findLoggedIndUser()))
                    .findAny()
                    .isPresent();
        } else {
            return true;
        }
    }

    public GameDTO getGameFullStatisticsByIdForAppealForm(Long id) {
        User loggedInUser = userService.findLoggedIndUser();
        Game game = findGameById(id); //TODO check/allow only user's games
        GameDTO gameDTO = toGameDTO(game);

        List<AnsweredQuestionDTO> answeredQuestions = game.getAnsweredQuestions().stream()
                .map(aq -> answeredQuestionService.toAnsweredQuestionDTO(aq))
                .peek(aqDTO -> {
                    if (!aqDTO.getNameWhoGotPointEn().equals(loggedInUser.getNameEn())) {
                        aqDTO.setAppealPossible(true);
                    } else {
                        aqDTO.setAppealPossible(false);
                    }
                })
                .collect(Collectors.toList());

        gameDTO.setAnsweredQuestionDTOs(answeredQuestions);
//        gameDTO.setAppealPossible(checkIfLoggedInUserCanFileAppealAgainstGame(game));

        return gameDTO;
    }

    // TODO improve this method
//    private boolean checkIfLoggedInUserCanFileAppealAgainstQuestion(Game game) {
//
//        if (!game.getAppeals().isEmpty()) {
//            return !game.getAppeals().stream()
//                    .filter(appeal -> appeal.getUser().equals(userService.findLoggedIndUser()))
//                    .findAny()
//                    .isPresent();
//        } else {
//            return true;
//        }
//    }


    public Game findGameById(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Can not fond games with id: " + id));
    }

    public List<Game> findAllGamesByTeam(User team) {
        return gameRepository.findByUsers(team)
                .orElseThrow(() -> new EntityNotFoundException("Can not fond games with team: " + team.getEmail()));
    }


    public List<Game> findAllGames() {
        return gameRepository.findAll();
    }

    public Game save(Game game) {
        log.info("***********************in GameService: save() - numberOfteams: {}", game.getUsers().size());
        log.info("***********************in GameService: save() - numberOfQuestionInGame: {}", game.getAnsweredQuestions().size());
        return gameRepository.save(game);
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
//        appealedGame.setAppealStage(AppealStage.FILED);
        appealedGame.getAnsweredQuestions()
                .stream()
                .filter(AnsweredQuestion::isAppealPossible)
                .map(answeredQuestion -> { //TODO replace with peek
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

//        appealedGame.setAppealStage(AppealStage.CONSIDERED);
        appealedGame.getAnsweredQuestions()
                .stream()
                .filter(answeredQuestion -> answeredQuestion.getAppealStage().equals(AppealStage.FILED))
                .forEach(questionWithAppealStageFiled -> {
                    if (approvedQuestionIds.contains(questionWithAppealStageFiled.getId())) {
//                        questionWithAppealStageFiled.setUserWhoGotPoint(appealedGame.getUser());
                        questionWithAppealStageFiled.setAppealStage(AppealStage.WON);
                    } else questionWithAppealStageFiled.setAppealStage(AppealStage.LOST);
                });
    }
}