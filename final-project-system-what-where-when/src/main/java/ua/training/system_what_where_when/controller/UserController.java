package ua.training.system_what_where_when.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.training.system_what_where_when.dto.GameWithAnsweredQuestionDTO;
import ua.training.system_what_where_when.dto.GameWithoutAnsweredQuestionDTO;
import ua.training.system_what_where_when.model.Game;
import ua.training.system_what_where_when.model.User;
import ua.training.system_what_where_when.service.GameService;
import ua.training.system_what_where_when.service.UserService;

import java.security.Principal;
import java.util.List;
import java.util.Locale;

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

    @GetMapping("/games/appeal/{id}")
    public ModelAndView getGameToAppeal(ModelAndView modelAndView, @PathVariable Long id) {
        System.out.println("-----------------id=" + id);
        Game game = gameService.findGameById(id);
        GameWithAnsweredQuestionDTO gameFullDTO = gameService.getGameFullStatisticsByLoginedTeam(id);
        modelAndView.setViewName("usergameappeal");
        modelAndView.addObject("gameFullDTO", gameFullDTO);
        System.out.println("from getGamesStatistics(ModelAndView modelAndView)");
        return modelAndView;
    }

    private Model setLocalizedLoggedInUserName(Model model) {
        User loggedInUser = userService.findLoginedUser();
        model.addAttribute("userNameEn", loggedInUser.getNameEn());
        model.addAttribute("userNameUa", loggedInUser.getNameUa());
        return model;
    }

    private Model setCurrentLocaleLanguage(Model model) {
        model.addAttribute("lang", LocaleContextHolder.getLocale().getLanguage());
        return model;
    }

}
