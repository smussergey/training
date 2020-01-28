//package ua.training.system_what_where_when_servlet.controller;
//
//import ua.training.system_what_where_when_servlet.controller.command.Command;
//import ua.training.system_what_where_when_servlet.controller.command.ExceptionCommand;
//import ua.training.system_what_where_when_servlet.controller.command.LoginCommand;
//import ua.training.system_what_where_when_servlet.controller.command.LogoutCommand;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.HashMap;
//
//public class ControllerHelper {
//    private static ControllerHelper instance;
//    private HashMap<String, Command> commands;
//
//    public static ControllerHelper getInstance() {
//        if (instance == null) {
//            instance = new ControllerHelper();
//        }
//        return instance;
//    }
//
//    Command getCommand(HttpServletRequest request) {
//        String command = request.getRequestURI().replaceAll(".*/", "");
//        return commands.get(command);
//    }
//
//    private ControllerHelper() {
//        commands = new HashMap<>();
//        commands.put("logout",
//                new LogoutCommand());
//        commands.put("login",
//                new LoginCommand());
//        commands.put("exception", new ExceptionCommand());
//    }
//
//}