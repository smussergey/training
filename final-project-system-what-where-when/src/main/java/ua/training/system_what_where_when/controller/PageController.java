package ua.training.system_what_where_when.controller;//package ua.training.delete;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/")
    public String mainPage() {
        return "index.html";
    }

    @RequestMapping("/login")
    public String loginPage() {
        return "login.html";
    }

    @RequestMapping("/user")
    public String mainUserPage() {
        return "index_user.html";
    }

    @RequestMapping("/admin")
    public String mainAdminPage() {
        return "index_admin.html";
    }
}
