package ua.training.system_what_where_when.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.training.system_what_where_when.dto.GameWithAnsweredQuestionDTO;
import ua.training.system_what_where_when.dto.GameWithoutAnsweredQuestionDTO;
import ua.training.system_what_where_when.model.User;
import ua.training.system_what_where_when.service.GameService;
import ua.training.system_what_where_when.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

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
    public String userHomePage(Model model) {
        setLocalizedLoggedInUserName(model);
        setCurrentLocaleLanguage(model);
        return "userhome";
    }

    @GetMapping("/games/statistics")
    public String getGamesStatistics(Model model) {
        List<GameWithoutAnsweredQuestionDTO> gameDTOs = gameService.getGameStatisticsByLoginedTeam();
        model.addAttribute("gameDTOs", gameDTOs);
        setLocalizedLoggedInUserName(model);
        setCurrentLocaleLanguage(model);
        return "usergamesstatistics";
    }

    @GetMapping("/games/{id}")
    public String getGameDetails(Model model, @PathVariable Long id) {
        GameWithAnsweredQuestionDTO gameFullDTO = gameService.getGameFullStatisticsByLoginedTeam(id);
        model.addAttribute("gameFullDTO", gameFullDTO);
        setLocalizedLoggedInUserName(model);
        setCurrentLocaleLanguage(model);
        return "usergamedetails";
    }

    @GetMapping("/appeal/games/{id}")
    public String getGameApealForm(Model model, @PathVariable Long id) {
        GameWithAnsweredQuestionDTO gameFullDTO = gameService.getGameFullStatisticsByLoginedTeam(id);
        model.addAttribute("gameFullDTO", gameFullDTO);
        setLocalizedLoggedInUserName(model);
        setCurrentLocaleLanguage(model);
        return "usergameappealform";
    }

    @PostMapping("/appeal/game/quastions")
    public String appealQuastions(HttpServletRequest request, Model model) {
        Arrays.stream(request.getParameterValues("ids")).forEach(q -> System.out.println("--------id=" + q));
        String[] answeredQuestionIds = request.getParameterValues("ids");
        if (answeredQuestionIds.length > 0) {
            log.info("IN appealQuastions - question with id: {} successfully was got", answeredQuestionIds[0]);
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
