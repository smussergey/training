package ua.training.system_what_where_when.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
    @RequestMapping("/")
    public String getMainPage() {
        return "index.html";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @RequestMapping("/login")
    public String getLoginPage(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout,
                           Model model) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return "login";
    }

    @RequestMapping("/user")
    public String userPage() {
        return "user.html";
    }

    @RequestMapping("/game")
    public String gamePage() {
        return "game.html";
    }

    @RequestMapping("/admin")
    public String adminPage() {
        return "admin.html";
    }
}

