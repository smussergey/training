package ua.training.system_what_where_when_servlet.controller.command;

import org.apache.log4j.Logger;
import ua.training.system_what_where_when_servlet.controller.command.Command;
import ua.training.system_what_where_when_servlet.dto.UserRegistrationDTO;
import ua.training.system_what_where_when_servlet.service.ServiceFactory;
import ua.training.system_what_where_when_servlet.service.UserRegistrationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationCommand implements Command {
    private static final Logger LOGGER = Logger.getLogger(LoginCommand.class);

    UserRegistrationService userRegistrationService;

    public RegistrationCommand() {
        this.userRegistrationService = ServiceFactory.getInstance().getUserRegistrationService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String nameUa = request.getParameter("nameua");
        String nameEn = request.getParameter("nameen");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        LOGGER.info(String.format("In RegistrationCommand, Registration data: nameUa = %S, nameEn = %S, " +
                "username = %S, password = %S", nameUa, nameEn, username, password));
        // TODO validatiion

        UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO();
        userRegistrationDTO.setNameUa(nameUa);
        userRegistrationDTO.setNameEn(nameEn);
        userRegistrationDTO.setEmail(username);
        userRegistrationDTO.setPassword(password);

        ServiceFactory.getInstance().getUserRegistrationService().register(userRegistrationDTO);
        return "/login.jsp";

    }
}