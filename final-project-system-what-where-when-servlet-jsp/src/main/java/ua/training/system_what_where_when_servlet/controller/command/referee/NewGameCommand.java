package ua.training.system_what_where_when_servlet.controller.command.referee;

import ua.training.system_what_where_when_servlet.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class NewGameCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {

        return "/WEB-INF/referee/newGame.jsp";
    }
}
