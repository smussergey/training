//package ua.training.system_what_where_when.controller.Command;
//
//import ua.training.system_what_where_when.model.entity.enums.Role;
//
//import javax.servlet.http.HttpServletRequest;
//
//public class LogOutCommand implements Command {
//    @Override
//    public String execute(HttpServletRequest request) {
//        // ToDo delete current user (context & session)
//        CommandUtility.setUserRole(request, Role.UNKNOWN, "Guest");
//        return "/index.jsp";
//    }
//}
