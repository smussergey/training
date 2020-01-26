//package ua.training.system_what_where_when.controller.Command;
//
//
//import ua.training.system_what_where_when.model.entity.enums.Role;
//
//import javax.servlet.ServletContext;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.util.HashSet;
//
//class CommandUtility {
//    static void setUserRole(HttpServletRequest request,
//                            Role role, String name) {
//        HttpSession session = request.getSession();
//        ServletContext context = request.getServletContext();
//        context.setAttribute("userName", name);
//        session.setAttribute("role", role);
//    }
//
//    static boolean checkUserIsLogged(HttpServletRequest request, String userName) {
//        HashSet<String> loggedUsers = (HashSet<String>) request.getSession().getServletContext()
//                .getAttribute("loggedUsers");
//
//        if (loggedUsers.stream().anyMatch(userName::equals)) {
//            return true;
//        }
//        loggedUsers.add(userName);
//        request.getSession().getServletContext()
//                .setAttribute("loggedUsers", loggedUsers);
//        return false;
//    }
//}
