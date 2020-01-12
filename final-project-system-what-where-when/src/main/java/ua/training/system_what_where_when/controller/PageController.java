package ua.training.system_what_where_when.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.training.system_what_where_when.model.Role;
import ua.training.system_what_where_when.service.UserService;

import java.security.Principal;

@Slf4j
@Controller
public class PageController {
    private final UserService userService;

    public PageController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getMainPage(Principal principal) {
//        log.info("-----------------------IN getMainPage - principal: {}", principal.getName());
        if (principal == null) {
            log.info("-----------------------IN getMainPage - principal: {}",  principal);
            return "home";
        }

        Role role = userService.findLoginedUser().getRole();
        log.info("-----------------------IN getMainPage - role: {}", role.name());
        switch (role) {
            case ROLE_USER:
                return "redirect:/user/userhome";
            case ROLE_ADMIN:
                return "redirect:/admin/adminhome";
        }
        return "redirect:/home";
    }

    @GetMapping("home")
    public String getDefaultPage() {
        return "home";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @GetMapping("/secured")
    public String securedPage() {
        return "secured";
    }


    @GetMapping("/admin/adminhome")
    public String adminPage() {
        return "adminhome";
    }
}