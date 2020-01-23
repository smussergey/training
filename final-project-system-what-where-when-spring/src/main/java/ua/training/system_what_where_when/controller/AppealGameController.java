package ua.training.system_what_where_when.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ua.training.system_what_where_when.dto.GameDTO;
import ua.training.system_what_where_when.model.AppealStage;
import ua.training.system_what_where_when.model.User;
import ua.training.system_what_where_when.service.AppealServise;
import ua.training.system_what_where_when.service.GameService;
import ua.training.system_what_where_when.service.UserService;
import ua.training.system_what_where_when.util.ResourceBundleUtil;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class AppealGameController {
    private final static String FILE_APPEAL_FORM_PAGE_PLAYER = "player/fileappealformplayer";
    private final static String REDIRECT_GAMES_STATISTICS_PLAYER = "redirect:/player/games/statistics";
    private final static String APPEAL_CONSIDERATION_FORM_PAGE_REFEREE = "referee/appealconsiderationformreferee";
    private final static String REDIRECT_GAMES_STATISTICS_REFEREE = "redirect:/referee/games/statistics";

    private final GameService gameService;
    private final UserService userService;
    private final AppealServise appealServise;

    public AppealGameController(GameService gameService, UserService userService, AppealServise appealServise) {
        this.gameService = gameService;
        this.userService = userService;
        this.appealServise = appealServise;
    }


    @GetMapping("/player/appeal/games/{id}")
    public String getFileApealForm(Model model, @PathVariable Long id) {
        GameDTO gameDTO = gameService.getGameFullStatisticsByIdForAppealForm(id);
        model.addAttribute("gameDTO", gameDTO);
        setLocalizedLoggedInUserName(model);
        setCurrentLocaleLanguage(model);
        return FILE_APPEAL_FORM_PAGE_PLAYER;
    }

    @PostMapping("/player/appeal/game/questions")
    public String appealQuestions(HttpServletRequest request, Model model) {
        String[] answeredQuestionIds = request.getParameterValues("ids");
        if (answeredQuestionIds.length > 0) {
            log.info("IN appealQuastions - appealed questions {} successfully were got", answeredQuestionIds.length);
            appealServise.fileAppealAgainstGameAnsweredQuestions(answeredQuestionIds);
        }
        return REDIRECT_GAMES_STATISTICS_PLAYER;
    }


    @GetMapping("/referee/appeal/games/{id}")
    public String getCosiderationApealForm(Model model, @PathVariable Long id) {
        GameDTO gameDTO = gameService.getGameFullStatisticsById(id);
        model.addAttribute("gameDTO", gameDTO);
        model.addAttribute("appealStageFiled",
                ResourceBundleUtil.getBundleStringForAppealStage(AppealStage.FILED.name()));
        setLocalizedLoggedInUserName(model);
        setCurrentLocaleLanguage(model);
        return APPEAL_CONSIDERATION_FORM_PAGE_REFEREE;
    }

    @PostMapping("/referee/appeal/game/quastions")
    public String approvedAppealedQuestions(HttpServletRequest request, Model model) {
        String[] answeredQuestionIds = request.getParameterValues("ids");
        if (answeredQuestionIds.length > 0) {
            log.info("IN considerAppealedQuestions - question with id: {} successfully was got", answeredQuestionIds.length);
            appealServise.approveAppealsAgainstGameAnsweredQuestions(answeredQuestionIds);
        }
        return REDIRECT_GAMES_STATISTICS_REFEREE;
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
