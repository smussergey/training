package ua.training.system_what_where_when_servlet.controller.command.player;

import org.apache.log4j.Logger;
import ua.training.system_what_where_when_servlet.controller.command.Command;
import ua.training.system_what_where_when_servlet.controller.command.LoginCommand;
import ua.training.system_what_where_when_servlet.dto.GameDTO;
import ua.training.system_what_where_when_servlet.entity.exception.EntityNotFoundException;
import ua.training.system_what_where_when_servlet.service.GameStatisticsAndDetailsService;
import ua.training.system_what_where_when_servlet.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetFileAppealFormPlayerCommand implements Command {
    private static final Logger LOGGER = Logger.getLogger(GetFileAppealFormPlayerCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("GetFileAppealForm class is executing");
        int gameId = Integer.valueOf(request.getParameter("gameid"));
        LOGGER.info(String.format("GetFileAppealForm class: parameter id = %d  was received as request for a game details", gameId));
        GameStatisticsAndDetailsService service = ServiceFactory.getInstance().getGameStatisticsAndDetailsService();

        String username = (String) request.getSession().getAttribute("username"); //check casting

        try {
            GameDTO gameDTO = service.getGameFullStatisticsByIdForAppealForm(gameId, username);
            LOGGER.info(String.format("GetFileAppealForm class: game details were generated for a game with id = %d", gameDTO.getId()));
            request.setAttribute("gameDTO", gameDTO);
        } catch (EntityNotFoundException ex) {
            //TODO
        }
        return "/WEB-INF/player/fileAppealFormPlayer.jsp";
    }
}
