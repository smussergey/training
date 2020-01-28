package ua.training.system_what_where_when_servlet.controller.command;

import org.apache.log4j.Logger;
import ua.training.system_what_where_when_servlet.entity.Role;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    private static final Logger LOGGER = Logger.getLogger(LoginCommand.class);


    @Override
    public String execute(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        LOGGER.info("User with " + username + "and password " + password + " is trying to log in ");
        System.out.println("request.getParameter(\"username\"):" + username);
        System.out.println("request.getParameter(\"password\"):" + password);

        if (username == null || username.equals("") || password == null || password.equals("")) {
            System.out.println("Error: fill out fields login, password");
            return "/login.jsp";
        }

        if (CommandUtility.checkUserIsLogged(request, username)) {
            LOGGER.warn("User " + username + " is logged in already");
            return "/WEB-INF/error.jsp";
        }

        if (CommandUtility.getRoleByUsernameAndPassword(username, password).equals(Role.ROLE_REFEREE)) {
            CommandUtility.setUserAndRoleToSession(request, Role.ROLE_REFEREE, username);
            LOGGER.info("Referee " + username + " logged successfully.");
            return "/WEB-INF/referee/mainReferee.jsp";
        } else if (CommandUtility.getRoleByUsernameAndPassword(username, password).equals(Role.ROLE_PLAYER)) {
            CommandUtility.setUserAndRoleToSession(request, Role.ROLE_PLAYER, username);
            LOGGER.info("Player " + username + " logged successfully.");
            return "/WEB-INF/player/main_player.jsp";
        } else {
            LOGGER.info("User with " + username + " can not log in, try another passworn or username");
            return "/login.jsp";
        }


    }

}

