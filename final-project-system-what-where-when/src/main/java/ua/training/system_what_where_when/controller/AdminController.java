package ua.training.system_what_where_when.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.training.system_what_where_when.dto.GameWithAnsweredQuestionDTO;
import ua.training.system_what_where_when.dto.GameWithoutAnsweredQuestionDTO;
import ua.training.system_what_where_when.model.AppealStage;
import ua.training.system_what_where_when.model.Role;
import ua.training.system_what_where_when.model.User;
import ua.training.system_what_where_when.service.GameService;
import ua.training.system_what_where_when.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {
    private final GameService gameService;
    private final UserService userService;

    public AdminController(GameService gameService, UserService userService) {
        this.gameService = gameService;
        this.userService = userService;
    }

    @GetMapping("/adminhome")
    public String getAdminHomePage(Model model) {
        setLocalizedLoggedInUserName(model);
        setCurrentLocaleLanguage(model);
        return "adminhome";
    }

    @GetMapping("/games/statistics")
    public String getGamesStatistics(Model model) {
        List<GameWithoutAnsweredQuestionDTO> gameDTOs = gameService.getGameStatisticsByAllTeams();
        model.addAttribute("gameDTOs", gameDTOs);
        setLocalizedLoggedInUserName(model);
        setCurrentLocaleLanguage(model);
        return "admingamesstatistics";
    }

    @GetMapping("/games/{id}")
    public String getGameDetails(Model model, @PathVariable Long id) {
        GameWithAnsweredQuestionDTO gameFullDTO = gameService.getGameFullStatisticsById(id);
        model.addAttribute("gameFullDTO", gameFullDTO);
        model.addAttribute("appealStageProcessed", AppealStage.CONSIDERED.name());
        setLocalizedLoggedInUserName(model);
        setCurrentLocaleLanguage(model);
        return "admingamedetails";
    }

    @GetMapping("/appeal/games/{id}")
    public String getCosiderationApealForm(Model model, @PathVariable Long id) {
        GameWithAnsweredQuestionDTO gameFullDTO = gameService.getGameFullStatisticsById(id);
        model.addAttribute("gameFullDTO", gameFullDTO);
        setLocalizedLoggedInUserName(model);
        setCurrentLocaleLanguage(model);
        return "admingameconsiderationappealform";
    }

    @PostMapping("/appeal/game/quastions")
    public String considerAppealedQuestions(HttpServletRequest request, Model model) {
        Arrays.stream(request.getParameterValues("ids")).forEach(q -> System.out.println("--------id=" + q));
        String[] answeredQuestionIds = request.getParameterValues("ids");
        if (answeredQuestionIds.length > 0) {
            log.info("IN considerAppealedQuestions - question with id: {} successfully was got", answeredQuestionIds.length);
            gameService.approveAppealAgainstGameAnsweredQuestions(answeredQuestionIds);
        }
        return "redirect:/admin/games/statistics";
    }

    @GetMapping("/games/new")
    public String getPreparedForNewGame(Model model) {
        List<User> users = userService.findAllUsersByRole(Role.ROLE_USER);;
        model.addAttribute("users", users);
        setLocalizedLoggedInUserName(model);
        setCurrentLocaleLanguage(model);
        return "admingamenew";
    }

    @PostMapping("/games/new")
    public String playNewGame(@RequestParam(value = "id", required = true) Long teamId,
                              @RequestParam(value = "maxscores", required = true) int maxNumberOfScores,
                              Model model) {
        log.info("IN playNewGame - team id: {} successfully was got", teamId);
        log.info("IN playNewGame - number Of questions : {} successfully was got", maxNumberOfScores);
        GameWithoutAnsweredQuestionDTO gameDTO = gameService.runNewGame(teamId, maxNumberOfScores);
        return "redirect:/admin/games/statistics";
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
