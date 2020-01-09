package ua.training.system_what_where_when.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ua.training.system_what_where_when.model.Role;
import ua.training.system_what_where_when.model.User;
import ua.training.system_what_where_when.service.GameService;
import ua.training.system_what_where_when.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final GameService gameService;
    private final UserService userService;

    public AdminController(GameService gameService, UserService userService) {
        this.gameService = gameService;
        this.userService = userService;
    }

    @GetMapping("/users")
    public ModelAndView getAllUsersWithRoleUser(ModelAndView modelAndView) {
        List<User> users = userService.findAllUsersByRole(Role.ROLE_USER);
        System.out.println("------------size=" + users.size());
        System.out.println("1t user name=" + users.get(0).getNameUa());
        //  users.stream().forEach(user -> System.out.println(user.getNameUa()));
        modelAndView.setViewName("adminhome");
        modelAndView.addObject("users", users);
        System.out.println("from getAllUsersWithRoleUser(Model model)");
        return modelAndView;
    }

    @GetMapping("/newgame")
    public ModelAndView getPreparedForNewGame(ModelAndView modelAndView) {
        List<User> users = userService.findAllUsersByRole(Role.ROLE_USER);
        System.out.println("------------size=" + users.size());
        System.out.println("1t user name=" + users.get(0).getNameUa());
        //  users.stream().forEach(user -> System.out.println(user.getNameUa()));
        modelAndView.setViewName("adminhome");
        modelAndView.addObject("users", users);
        System.out.println("from getAllUsersWithRoleUser(Model model)");
        return modelAndView;
    }

    @PostMapping("/newgame")
    public ModelAndView startNewGame(ModelAndView modelAndView) {
        System.out.println("New game was started");
        modelAndView.setViewName("adminhome");
        System.out.println("New game was saved");
        gameService.saveGameTest();
        return modelAndView;
    }
}
