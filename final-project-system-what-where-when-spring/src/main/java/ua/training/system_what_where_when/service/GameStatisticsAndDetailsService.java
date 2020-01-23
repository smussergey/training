package ua.training.system_what_where_when.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.training.system_what_where_when.dto.AnsweredQuestionDTO;
import ua.training.system_what_where_when.dto.GameDTO;
import ua.training.system_what_where_when.exception.EntityNotFoundException;
import ua.training.system_what_where_when.model.*;
import ua.training.system_what_where_when.repository.GameRepository;
import ua.training.system_what_where_when.util.ResourceBundleUtil;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class GameStatisticsAndDetailsService {
    private static final String DELIMITER = ":";

    private final UserService userService;
    private final GameRepository gameRepository;
    private final AnsweredQuestionService answeredQuestionService;

    public GameStatisticsAndDetailsService(UserService userService, GameRepository gameRepository, AnsweredQuestionService answeredQuestionService) {
        this.userService = userService;
        this.gameRepository = gameRepository;
        this.answeredQuestionService = answeredQuestionService;
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
        gameDTO.setAppealPossible(checkIfLoggedUserCanFileAppealAgainstGame(game));

        return gameDTO;
    }

    // TODO improve this method
    private boolean checkIfLoggedUserCanFileAppealAgainstGame(Game game) {

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

}
