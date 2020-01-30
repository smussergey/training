package ua.training.system_what_where_when_servlet.controller.command.referee;

import org.apache.log4j.Logger;
import ua.training.system_what_where_when_servlet.controller.command.Command;
import ua.training.system_what_where_when_servlet.controller.command.LoginCommand;
import ua.training.system_what_where_when_servlet.dto.GameDTO;
import ua.training.system_what_where_when_servlet.entity.exception.EntityNotFoundException;
import ua.training.system_what_where_when_servlet.service.GameStatisticsAndDetailsService;
import ua.training.system_what_where_when_servlet.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GameDetails implements Command {
    private static final Logger LOGGER = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("GameDetails class is executing");
        int gameId = Integer.valueOf(request.getParameter("gameid"));
        LOGGER.info(String.format("GameDetails class: parameter id = %d  was received as request for a game details", gameId));
        GameStatisticsAndDetailsService service = ServiceFactory.getInstance().getGameStatisticsAndDetailsService();

        try {
            GameDTO gameDTO = service.getGameFullStatisticsById(gameId);
            LOGGER.info(String.format("GameDetails class: game was found with id = %d", gameDTO.getId()));
            request.setAttribute("gameDTO", gameDTO);
        } catch (EntityNotFoundException ex) {
            //TODO
        }
        return "/WEB-INF/referee/gameDetails.jsp";
    }
}
