package ua.training.system_what_where_when_servlet.controller.command.page;

import ua.training.system_what_where_when_servlet.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class LoginPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "login.jsp";
    }
}
