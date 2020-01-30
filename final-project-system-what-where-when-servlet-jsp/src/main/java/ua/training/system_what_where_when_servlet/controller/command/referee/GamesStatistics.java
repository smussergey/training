package ua.training.system_what_where_when_servlet.controller.command.referee;

import org.apache.log4j.Logger;
import ua.training.system_what_where_when_servlet.controller.command.Command;
import ua.training.system_what_where_when_servlet.dto.GameDTO;
import ua.training.system_what_where_when_servlet.service.GameStatisticsAndDetailsService;
import ua.training.system_what_where_when_servlet.service.ServiceFactory;
import ua.training.system_what_where_when_servlet.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GamesStatistics implements Command {
    private static final Logger LOGGER = Logger.getLogger(UserService.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.debug("GamesStatistics class is executing");
        GameStatisticsAndDetailsService service = ServiceFactory.getInstance().getGameStatisticsAndDetailsService();
        List<GameDTO> gameDTOs = service.getGameStatisticsByAllGamesAndPlayers();
        request.setAttribute("gameDTOs", gameDTOs);
        return "/WEB-INF/referee/gamesStatistics.jsp";
    }
}