package ua.training.system_what_where_when.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ua.training.system_what_where_when.dto.UserRegisterDTO;
import ua.training.system_what_where_when.service.UserService;
import ua.training.system_what_where_when.util.validation.ValidationErrorBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

@Slf4j
@Controller
public class RegistrationAndLoginController {
    private final static String REGISTRATION_PAGE = "registration";
    private final static String LOGIN_PAGE = "login";

    private UserService userService;

    public RegistrationAndLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        setCurrentLocaleLanguage(model);
        return REGISTRATION_PAGE;
    }

    @PostMapping("/registration")
    public String registrer(@ModelAttribute("newuser") @Valid UserRegisterDTO userRegisterDTO,
                            Errors errors, Model model) {
        if (!errors.hasErrors()) {
            try {
                userService.register(userRegisterDTO);
                return LOGIN_PAGE;
            } catch (Exception ex) {
                log.info(userRegisterDTO.getEmail() + " email is already exist");
                model.addAttribute("emailerror", "registration.message.login.already.exists");
                return REGISTRATION_PAGE;
            }
        }

        model.addAttribute("fielderrors", ValidationErrorBuilder.fromBindingErrors(errors).getErrors());
        return REGISTRATION_PAGE;
    }

    @GetMapping("/login")
    public String getLogin(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout,
                           Model model) {
        model.addAttribute("error", error != null); //TODO check why to use this
        model.addAttribute("logout", logout != null);//TODO check why to use this
        setCurrentLocaleLanguage(model);
        return "login";
    }

    private Model setCurrentLocaleLanguage(Model model) {
        model.addAttribute("lang", LocaleContextHolder.getLocale().getLanguage());
        return model;
    }

}
