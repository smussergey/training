package ua.training.system_what_where_when_servlet.controller;

import ua.training.system_what_where_when_servlet.controller.command.*;
import ua.training.system_what_where_when_servlet.controller.command.page.LoginPageCommand;
import ua.training.system_what_where_when_servlet.controller.command.page.RegistrationPageCommand;
import ua.training.system_what_where_when_servlet.controller.command.referee.GamesStatistics;
import ua.training.system_what_where_when_servlet.controller.command.referee.HistoryConsideration;
import ua.training.system_what_where_when_servlet.controller.command.referee.MainReferee;
import ua.training.system_what_where_when_servlet.controller.command.referee.NewGameCommand;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Servlet extends HttpServlet {
    private Map<String, Command> commands = new HashMap<>();

    public void init(ServletConfig servletConfig) {

        servletConfig.getServletContext()
                .setAttribute("loggedUsers", new HashSet<String>());
        commands.put("registrationPage",
                new RegistrationPageCommand());
        commands.put("loginPage",
                new LoginPageCommand());
        commands.put("registration",
                new RegistrationCommand());
        commands.put("login",
                new LoginCommand());
        commands.put("logout",
                new LogoutCommand());
        commands.put("exception",
                new ExceptionCommand());
        commands.put("mainReferee",
                new MainReferee());
        commands.put("newGame",
                new NewGameCommand());
        commands.put("gamesStatistics",
                new GamesStatistics());
        commands.put("historyConsideration",
                new HistoryConsideration());
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("DoGet=" + request.getRequestURI());

        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println(request.getRequestURI());
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getRequestURI();
        System.out.println("request.getRequestURI(): " + path);
        path = path.replaceAll(".*/", "");
        System.out.println("replaceAll(\".*/\" , \"\"): " + path);
        Command command = commands.getOrDefault(path,
                (req, res) -> "/index.jsp");
        String page = command.execute(request, response);
        request.getRequestDispatcher(page).forward(request, response);

    }


}
