package ua.training.system_what_where_when.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;;
import org.springframework.web.bind.annotation.PostMapping;
import ua.training.system_what_where_when.dto.UserRegisterDto;
import ua.training.system_what_where_when.service.UserService;

@Slf4j
@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public String register(UserRegisterDto userRegisterDto, Model model) {
        try {
            userService.register(userRegisterDto);
        } catch (Exception ex) {
            log.info(userRegisterDto.getEmail() + " email is already exist");
            model.addAttribute("message", "email is already exist");
            return "registration";
        }
        return "redirect:/login";
    }
}
