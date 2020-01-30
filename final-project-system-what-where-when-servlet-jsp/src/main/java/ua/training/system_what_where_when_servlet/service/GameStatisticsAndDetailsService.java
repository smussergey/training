package ua.training.system_what_where_when_servlet.service;

import org.apache.log4j.Logger;
import ua.training.system_what_where_when_servlet.dao.DaoFactory;
import ua.training.system_what_where_when_servlet.dao.GameDao;
import ua.training.system_what_where_when_servlet.dto.AnsweredQuestionDTO;
import ua.training.system_what_where_when_servlet.dto.GameDTO;
import ua.training.system_what_where_when_servlet.entity.Game;
import ua.training.system_what_where_when_servlet.entity.exception.EntityNotFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GameStatisticsAndDetailsService {
    private static final Logger LOGGER = Logger.getLogger(UserService.class);
    private final DaoFactory daoFactory;
    private final GameDTOService gameDTOService = ServiceFactory.getInstance().getGameDTOService();
    private final AnsweredQuestionService answeredQuestionService = ServiceFactory.getInstance().getAnsweredQuestionService();

    public GameStatisticsAndDetailsService() {
        this.daoFactory = DaoFactory.getInstance();
    }


//    private final UserService userService;
//    private final GameDao gameDao;
//    private final AnsweredQuestionService answeredQuestionService;
//    private final GameDTOService gameDTOService;


//
//    public Page<GameDTO> getGameStatisticsByAllGamesAndPlayers(Pageable pageable) {
//        return gameRepository.findAll(pageable)
//                .map(gameDTOService::toGameDTO);
//    }

    public List<GameDTO> getGameStatisticsByAllGamesAndPlayers() {
        try (GameDao gameDao = daoFactory.createGameDao()) {
            List<Game> games = gameDao.findAll();
            LOGGER.info(String.format("GameStatisticsAndDetailsService class, getGameStatisticsByAllGamesAndPlayers method, were found %s games", games.size()));

            return games.stream()
                    .map(gameDTOService::toGameDTO)
                    .sorted(Comparator.comparing(GameDTO::getDate).reversed())
                    .collect(Collectors.toList());
        } catch (Exception e) {
            LOGGER.error("Exception in GameStatisticsAndDetailsService class, getGameStatisticsByAllGamesAndPlayers method.", e);
        }
        return null; //TODO correct
    }

    //    TODO forbid logged user to see not his game results
    public GameDTO getGameFullStatisticsById(int id) {
        LOGGER.info("GameStatisticsAndDetailsService class, getGameFullStatisticsById method is executing");
        Game game = null; //TODO
        try (GameDao gameDao = daoFactory.createGameDao()) {
            game = gameDao.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Game with id = %d was not found", id)));
            LOGGER.info(String.format("GameStatisticsAndDetailsService class: getGameFullStatisticsById method: game with id = %d", game.getId()));
        } catch (Exception e) { //TODO
            LOGGER.error("GameStatisticsAndDetailsService class, getGameFullStatisticsById method: game was not found by id=" + id);
        }
        GameDTO gameDTO = gameDTOService.toGameDTO(game);

        LOGGER.info(String.format("GameStatisticsAndDetailsService class, getGameFullStatisticsById method: game with id =  %d has %d answeredQuestions", id, game.getAnsweredQuestions().size()));
        List<AnsweredQuestionDTO> answeredQuestions = game.getAnsweredQuestions().stream()
                .map(answeredQuestionService::toAnsweredQuestionDTO)
                .collect(Collectors.toList());

        gameDTO.setAnsweredQuestionDTOs(answeredQuestions);
//            gameDTO.setAppealPossible(checkIfLoggedUserCanFileAppealAgainstGame(game));

        return gameDTO;
    }

//        // TODO improve this method
//        private boolean checkIfLoggedUserCanFileAppealAgainstGame(Game game) {
//
//            if (!game.getAppeals().isEmpty()) {
//                return !game.getAppeals().stream()
//                        .filter(appeal -> appeal.getUser().equals(userService.findLoggedIndUser()))
//                        .findAny()
//                        .isPresent();
//            } else {
//                return true;
//            }
//        }


//    public Page<GameDTO> getGamesStatisticsByLoggedInPlayer(Principal principal, Pageable pageable) throws EntityNotFoundException {
//        //TODO improve with Principal
//        return gameRepository.findAllByUsers(userService.findLoggedIndUser(), pageable)
//                .map(gameDTOService::toGameDTO);
//    }

//    //    TODO forbid logged user to see not his game results
//    public GameDTO getGameFullStatisticsById(Long id) {
//        Game game = findGameById(id);
//        GameDTO gameDTO = gameDTOService.toGameDTO(game);
//
//        List<AnsweredQuestionDTO> answeredQuestions = game.getAnsweredQuestions().stream()
//                .map(answeredQuestionService::toAnsweredQuestionDTO)
//                .collect(Collectors.toList());
//
//        gameDTO.setAnsweredQuestionDTOs(answeredQuestions);
//        gameDTO.setAppealPossible(checkIfLoggedUserCanFileAppealAgainstGame(game));
//
//        return gameDTO;
//    }
//
//    // TODO improve this method
//    private boolean checkIfLoggedUserCanFileAppealAgainstGame(Game game) {
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
//
//    //TODO check/allow only user's games
//    public GameDTO getGameFullStatisticsByIdForAppealForm(Long id) {
//        User loggedInUser = userService.findLoggedIndUser();
//        Game game = findGameById(id);
//        GameDTO gameDTO = gameDTOService.toGameDTO(game);
//
//        List<AnsweredQuestionDTO> answeredQuestions = game.getAnsweredQuestions().stream()
//                .map(answeredQuestionService::toAnsweredQuestionDTO)
//                .peek(aqDTO -> {
//                    if (!aqDTO.getNameWhoGotPointEn().equals(loggedInUser.getNameEn())) {
//                        aqDTO.setAppealPossible(true);
//                    } else {
//                        aqDTO.setAppealPossible(false);
//                    }
//                })
//                .collect(Collectors.toList());
//
//        gameDTO.setAnsweredQuestionDTOs(answeredQuestions);
//
//        return gameDTO;
//    }
//
//    public Game findGameById(Long id) {
//        return gameRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("Can not fond games with id: " + id));
//    }


}