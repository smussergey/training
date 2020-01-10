package ua.training.system_what_where_when.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.training.system_what_where_when.dto.GameDTO;
import ua.training.system_what_where_when.service.GameService;
import ua.training.system_what_where_when.service.UserService;

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

    @GetMapping("/games/statistics")
    public ModelAndView getGamesStatistics(ModelAndView modelAndView) {
        List<GameDTO> gameDTOs = gameService.getGameStatisticsByLoginedTeam();
        System.out.println("------------size=" + gameDTOs.size());
        modelAndView.setViewName("userhome");
        modelAndView.addObject("gameDTOs", gameDTOs);
        System.out.println("from getGamesStatistics(ModelAndView modelAndView)");
        return modelAndView;
    }
}
