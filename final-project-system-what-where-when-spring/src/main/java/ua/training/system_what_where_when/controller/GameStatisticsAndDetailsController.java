package ua.training.system_what_where_when.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.training.system_what_where_when.dto.GameDTO;
import ua.training.system_what_where_when.exception.EntityNotFoundException;
import ua.training.system_what_where_when.model.AppealStage;
import ua.training.system_what_where_when.model.User;
import ua.training.system_what_where_when.service.GameService;
import ua.training.system_what_where_when.service.UserService;
import ua.training.system_what_where_when.util.ResourceBundleUtil;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class GameStatisticsAndDetailsController {
    private final static String GAMES_STATISTICS_PAGE_PLAYER = "player/gamesstatisticsplayer";
    private final static String GAME_DETAILS_PAGE_PLAYER = "player/gamedetailsplayer";
    private final static String GAMES_STATISTICS_PAGE_REFEREE = "referee/gamesstatisticsreferee";
    private final static String GAME_DETAILS_PAGE_REFEREE = "referee/gamedetailsreferee";

    private final GameService gameService;
    private final UserService userService;

    public GameStatisticsAndDetailsController(GameService gameService, UserService userService) {
        this.gameService = gameService;
        this.userService = userService;
    }

    @GetMapping("/player/games/statistics")
    public String getGamesStatisticsForPlayer(Model model) {
        List<GameDTO> gameDTOs = new ArrayList<>();
        try {
            gameDTOs = gameService.getGamesStatisticsByLoggedInTeam();
        } catch (EntityNotFoundException e) { // TODO chech if it should be here
            log.warn("IN getGamesStatistics - cannot find games statistics for logged in user");
        }

        model.addAttribute("gameDTOs", gameDTOs);
        setLocalizedLoggedInUserName(model);
        setCurrentLocaleLanguage(model);
        return GAMES_STATISTICS_PAGE_PLAYER;
    }

    @GetMapping("/player/games/{id}") //TODO check user can get info only on hig game
    public String getGameDetailsForPlayer(Model model, @PathVariable Long id) {
        GameDTO gameDTO = gameService.getGameFullStatisticsById(id);
        model.addAttribute("gameDTO", gameDTO);
        setLocalizedLoggedInUserName(model);
        setCurrentLocaleLanguage(model);
        return GAME_DETAILS_PAGE_PLAYER;
    }

    @GetMapping("/referee/games/statistics")
    public String getGamesStatisticsForAdmin(Model model) {
        List<GameDTO> gameDTOs = gameService.getGameStatisticsByAllGames();
        model.addAttribute("gameDTOs", gameDTOs);
        setLocalizedLoggedInUserName(model);
        setCurrentLocaleLanguage(model);
        return GAMES_STATISTICS_PAGE_REFEREE;
    }

    @GetMapping("/referee/games/{id}")
    public String getGameDetailsForAdmin(Model model, @PathVariable Long id) {
        GameDTO gameDTO = gameService.getGameFullStatisticsById(id);
        model.addAttribute("gameDTO", gameDTO);
        model.addAttribute("appealStageFiled",
                ResourceBundleUtil.getBundleStringForAppealStage(AppealStage.FILED.name()));
        setLocalizedLoggedInUserName(model);
        setCurrentLocaleLanguage(model);
        return GAME_DETAILS_PAGE_REFEREE;
    }

    private Model setLocalizedLoggedInUserName(Model model) {
        User loggedInUser = userService.findLoggedIndUser();
        model.addAttribute("userNameEn", loggedInUser.getNameEn());
        model.addAttribute("userNameUa", loggedInUser.getNameUa());
        return model;
    }

    private Model setCurrentLocaleLanguage(Model model) {
        model.addAttribute("lang", LocaleContextHolder.getLocale().getLanguage());
        return model;
    }
}
