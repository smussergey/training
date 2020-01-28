package ua.training.system_what_where_when_servlet.controller.command;


import ua.training.system_what_where_when_servlet.dao.DaoFactory;
import ua.training.system_what_where_when_servlet.dao.UserDao;
import ua.training.system_what_where_when_servlet.entity.Role;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;

class CommandUtility {
    static void setUserAndRoleToSession(HttpServletRequest request,
                                        Role role, String username) {
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        session.setAttribute("role", role);
    }


    static boolean checkUserIsLogged(HttpServletRequest request, String username) {
        HashSet<String> loggedUsers = (HashSet<String>) request.getSession().getServletContext()
                .getAttribute("loggedUsers");

        if (loggedUsers.stream().anyMatch(username::equals)) {
            return true;
        }
        loggedUsers.add(username);
        request.getSession().getServletContext()
                .setAttribute("loggedUsers", loggedUsers);
        return false;
    }

    static Role getRoleByUsernameAndPassword(String username, String password) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        UserDao userDao = daoFactory.createUserDao();

        //TODO correctly Optional;
        Role role = userDao.findByUserName(username).get().getRole();
        System.out.println("getRoleByUsernameAndPassword(String username, String password): " + role.name());
        return role;
    }
}
