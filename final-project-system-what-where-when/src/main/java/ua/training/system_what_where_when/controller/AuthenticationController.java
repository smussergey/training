package ua.training.system_what_where_when.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ua.training.system_what_where_when.dto.UserRegisterDTO;
import ua.training.system_what_where_when.service.UserService;
import ua.training.system_what_where_when.util.UTF8Control;
import ua.training.system_what_where_when.util.validation.ValidationErrorBuilder;

import javax.validation.Valid;

@Slf4j
@Controller
public class AuthenticationController {

    private final UTF8Control utf8Control;
    private UserService userService;

    public AuthenticationController(UTF8Control utf8Control, UserService userService) {
        this.utf8Control = utf8Control;
        this.userService = userService;
    }

    @PostMapping("/registration") //TODO correct functionality of bindingResult
    public String registrer(@ModelAttribute("newuser") @Valid UserRegisterDTO userRegisterDTO,
                            Errors errors, Model model) {

        if (!errors.hasErrors()) {
            try {
                userService.register(userRegisterDTO);
                return "login";
            } catch (Exception ex) {
                log.info(userRegisterDTO.getEmail() + " email is already exist");
                model.addAttribute("emailerror", "registration.message.login.already.exists");
                return "registration";
            }
        }
        model.addAttribute("fielderrors", ValidationErrorBuilder.fromBindingErrors(errors, utf8Control).getErrors());

        return "registration";
//        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLogin(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout,
                           Model model) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return "login";
    }
}
