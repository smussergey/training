package ua.training.system_what_where_when.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
    @GetMapping("/home")
    public String getDefaultPage() {
        return "home";
    }

    @GetMapping("/")
    public String getHomePage() {
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



    @GetMapping("/user/userhome")
    public String userPage() {
        return "userhome";
    }


    @GetMapping("/admin/adminhome")
    public String adminPage() {
        return "adminhome";
    }
}