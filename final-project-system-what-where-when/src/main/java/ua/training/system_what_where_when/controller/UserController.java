package ua.training.system_what_where_when.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.training.system_what_where_when.dto.GameDTO;
import ua.training.system_what_where_when.model.User;
import ua.training.system_what_where_when.service.GameService;
import ua.training.system_what_where_when.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
    private final GameService gameService;
    private final UserService userService;

    public UserController(GameService gameService, UserService userService) {
        this.gameService = gameService;
        this.userService = userService;
    }

    @GetMapping("/userhome")
    public String getUserHomePage(Model model) {
        setLocalizedLoggedInUserName(model);
        setCurrentLocaleLanguage(model);
        return "userhome";
    }

    @GetMapping("/games/statistics")
    public String getGamesStatistics(Model model) {
//        List<GameWithoutAnsweredQuestionDTO> gameDTOs = new ArrayList<>();
//        try {
//            gameDTOs = gameService.getGameStatisticsByLoginedTeam();
//        } catch (EntityNotFoundException e) {
//            log.warn("IN getGamesStatistics - cannot find games statistics for logged in user");
//        }
//
//        model.addAttribute("gameDTOs", gameDTOs);
//        setLocalizedLoggedInUserName(model);
//        setCurrentLocaleLanguage(model);
        return "usergamesstatistics";
    }

    @GetMapping("/games/{id}")
    public String getGameDetails(Model model, @PathVariable Long id) {
        GameDTO gameFullDTO = gameService.getGameFullStatisticsById(id);
        model.addAttribute("gameFullDTO", gameFullDTO);
        setLocalizedLoggedInUserName(model);
        setCurrentLocaleLanguage(model);
        return "usergamedetails";
    }

    @GetMapping("/appeal/games/{id}")
    public String getFileApealForm(Model model, @PathVariable Long id) {
        GameDTO gameFullDTO = gameService.getGameFullStatisticsById(id);
        model.addAttribute("gameFullDTO", gameFullDTO);
        setLocalizedLoggedInUserName(model);
        setCurrentLocaleLanguage(model);
        return "usergamefileappealform";
    }

    @PostMapping("/appeal/game/questions")
    public String appealQuestions(HttpServletRequest request, Model model) {
        String[] answeredQuestionIds = request.getParameterValues("ids");
        if (answeredQuestionIds.length > 0) {
            log.info("IN appealQuastions - appealed questions {} successfully were got", answeredQuestionIds.length);
            gameService.fileAppealAgainstGameAnsweredQuestions(answeredQuestionIds);
        }
        return "redirect:/user/games/statistics";
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
