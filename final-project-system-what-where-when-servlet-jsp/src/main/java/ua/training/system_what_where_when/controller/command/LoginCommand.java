package ua.training.system_what_where_when.controller.command;

import ua.training.system_what_where_when.entity.Role;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command{

    @Override
    public String execute(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("request.getParameter(\"username\"):" + username);
        System.out.println("request.getParameter(\"password\"):" + password);

        if( username == null || username.equals("") || password == null || password.equals("")  ){
            System.out.println("Error: fill out fields login, password");
            return "/login.jsp";
        }

        if(CommandUtility.checkUserIsLogged(request, username)){
            System.out.println("User is logged in");
            return "/error.jsp";
        }

        if (CommandUtility.getRoleByUsernameAndPassword(username, password).equals(Role.ROLE_REFEREE)){
            CommandUtility.setUserAndRoleToSession(request, Role.ROLE_REFEREE, username);
            return "/main_referee.jsp";
        } else if(CommandUtility.getRoleByUsernameAndPassword(username, password).equals(Role.ROLE_PLAYER)) {
            CommandUtility.setUserAndRoleToSession(request, Role.ROLE_PLAYER, username);
            return "/main_player.jsp";
        } else {
            return "/login.jsp";
        }


    }

}
