package ua.training.system_what_where_when.controller;//package ua.training.delete;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/")
    public String mainPage() {
        return "index.html";
    }
}
