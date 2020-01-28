package ua.training.system_what_where_when_servlet.controller.command;

import javax.servlet.http.HttpServletRequest;


public class ExceptionCommand implements Command {


    @Override
    public String execute(HttpServletRequest request) {
        throw new RuntimeException("Generated exception");
    }
}
