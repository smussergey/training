package ua.training.system_what_where_when.controller.command;


import ua.training.system_what_where_when.dao.DaoFactory;
import ua.training.system_what_where_when.dao.UserDao;
import ua.training.system_what_where_when.entity.Role;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;

class CommandUtility {
    static void setUserAndRoleToSession(HttpServletRequest request,
                                        Role role, String userName) {
        HttpSession session = request.getSession();
        ServletContext context = request.getSession().getServletContext();
        context.setAttribute("username", userName);
        session.setAttribute("role", role);
    }


    static boolean checkUserIsLogged(HttpServletRequest request, String userName) {
        HashSet<String> loggedUsers = (HashSet<String>) request.getSession().getServletContext()
                .getAttribute("loggedUsers");

        if (loggedUsers.stream().anyMatch(userName::equals)) {
            return true;
        }
        loggedUsers.add(userName);
        request.getSession().getServletContext()
                .setAttribute("loggedUsers", loggedUsers);
        return false;
    }

    static Role getRoleByUsernameAndPassword(String userName, String password) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        UserDao userDao = daoFactory.createUserDao();

        //TODO correctly Optional;
        return userDao.findByUserName(userName).get().getRole();
    }
}
