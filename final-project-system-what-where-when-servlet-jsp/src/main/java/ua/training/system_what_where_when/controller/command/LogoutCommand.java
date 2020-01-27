package ua.training.system_what_where_when.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.getServletContext().removeAttribute("username");
        session.removeAttribute("role");
        session.invalidate();
        return "/index.jsp";
    }
}

