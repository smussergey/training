package ua.training.system_what_where_when.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String getMainPage(Model model,Principal principal) {
        setCurrentLocaleLanguage(model);
        if (principal == null) {
            log.info("-----------------------IN getMainPage - principal: {}", principal);
            return "home";
        }

        Role role = userService.findLoggedIndUser().getRole();
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
    public String getDefaultPage(Model model) {
        setCurrentLocaleLanguage(model);
        return "home";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        setCurrentLocaleLanguage(model);
        return "registration";
    }

    @GetMapping("/admin/adminhome")
    public String adminPage(Model model) {
        setCurrentLocaleLanguage(model);
        return "adminhome";
    }

    private Model setCurrentLocaleLanguage(Model model) {
        model.addAttribute("lang", LocaleContextHolder.getLocale().getLanguage());
        return model;
    }
}