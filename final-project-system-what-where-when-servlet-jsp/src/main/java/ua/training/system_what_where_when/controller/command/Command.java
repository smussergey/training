package ua.training.system_what_where_when.controller.command;

import javax.servlet.http.HttpServletRequest;

public interface Command {


    String execute(HttpServletRequest request);
}
