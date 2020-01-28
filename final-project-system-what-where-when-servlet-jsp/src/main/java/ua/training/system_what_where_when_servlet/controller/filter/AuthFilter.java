package ua.training.system_what_where_when_servlet.controller.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        ServletContext context = session.getServletContext();

        System.out.println("req.getSession(): " + session);
        System.out.println("session.getAttribute(\"role\") " + session.getAttribute("role"));
        System.out.println("context.getAttribute(\"loggedUsers\"): " + context.getAttribute("loggedUsers"));


        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
