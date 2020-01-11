package ua.training.system_what_where_when.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.training.system_what_where_when.dto.UserRegisterDTO;
import ua.training.system_what_where_when.service.UserService;

@Slf4j
@Controller
public class AuthenticationController {
    private UserService userService;

    @Autowired
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public String register(UserRegisterDTO userRegisterDto, Model model) {
        try {
            userService.register(userRegisterDto);
        } catch (Exception ex) {
            log.info(userRegisterDto.getEmail() + " email is already exist");
            model.addAttribute("message", "email is already exist");
            return "registration";
        }
        return "redirect:/login";
    }


    @GetMapping( "/login" )
    public String getLogin(@RequestParam( value = "error", required = false ) String error,
                           @RequestParam( value = "logout", required = false ) String logout,
                           Model model) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return "login";
    }
}
