package ua.training.system_what_where_when_servlet.controller;

import ua.training.system_what_where_when_servlet.controller.command.*;
import ua.training.system_what_where_when_servlet.controller.command.page.LoginPageCommand;
import ua.training.system_what_where_when_servlet.controller.command.page.RegistrationPageCommand;
import ua.training.system_what_where_when_servlet.controller.command.player.*;
import ua.training.system_what_where_when_servlet.controller.command.referee.*;

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
                new MainRefereeCommand());
        commands.put("newGamePrepareReferee",
                new NewGamePrepareRefereeCommand());
        commands.put("generateNewGameReferee",
                new GenerateNewGameRefereeCommand());
        commands.put("gamesStatisticsReferee",
                new GamesStatisticsRefereeCommand());
        commands.put("gameDetailsReferee",
                new GameDetailsRefereeCommand());
        commands.put("historyConsiderationReferee",
                new HistoryConsiderationRefereeCommand());
        commands.put("mainPlayer",
                new MainPlayerCommand());
        commands.put("gamesStatisticsPlayer",
                new GamesStatisticsPlayerCommand());
        commands.put("gameDetailsPlayer",
                new GameDetailsPlayerCommand());
        commands.put("fileAppealFormPlayer",
                new FileAppealFormPlayerCommand());
        commands.put("fileAppealAgainstAnsweredQuestions",
                new FileAppealAgainstAnsweredQuestionsPlayerCommand());
        commands.put("considerationAppealForm",
                new ConsiderationAppealFormRefereeCommand());
        commands.put("considerAppealAgainstAnsweredQuestions",
                new ConsiderAppealAgainstAnsweredQuestionsRefereeCommand());
        commands.put("historyGamesStatistics",
                new HistoryGamesStatisticsRefereeCommand());
        commands.put("historyConsiderationReferee",
                new HistoryConsiderationRefereeCommand());
        commands.put("moveToHistory",
                new MoveToHistoryRefereeCommand());
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
