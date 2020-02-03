package ua.training.system_what_where_when_servlet.controller.filter;

import org.apache.log4j.Logger;
import ua.training.system_what_where_when_servlet.entity.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {
    private static final Logger LOGGER = Logger.getLogger(AuthFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        final HttpServletResponse httpResponce = (HttpServletResponse) servletResponse;
        final HttpSession session = httpRequest.getSession();

        String path = httpRequest.getRequestURI();
        Role role = (Role) session.getAttribute("role");

        boolean isLoggedIn = (session != null &&
                session.getAttribute("username") != null &&
                session.getAttribute("role") != null);
        boolean isLoginRequest = path.contains("login");
        boolean isLogoutRequest = path.contains("logout");
        boolean isError = path.contains("error");

        LOGGER.info("in AuthFilter: request URI= " + httpRequest.getRequestURI());

        if (isError) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        if (!isLoggedIn && isLoginRequest) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        if (isLoggedIn && isLoginRequest) {
            httpResponce.sendRedirect("/logout");
            return;
        }

        if (isLogoutRequest) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        if (isLoggedIn && role.equals(Role.ROLE_REFEREE)) {
            LOGGER.info("in AuthFilter:isLoggedIn && role.equals(Role.ROLE_REFEREE): " + (isLoggedIn && role.equals(Role.ROLE_REFEREE)));
            if (isPathAllowedForRole(path, Role.ROLE_REFEREE)) {
                LOGGER.info("in AuthFilter:isPathCorrect(path, Role.ROLE_REFEREE): " + isPathAllowedForRole(path, Role.ROLE_REFEREE));
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            } else {
                LOGGER.warn("in AuthFilter:isPathCorrect(path, Role.ROLE_REFEREE): " + isPathAllowedForRole(path, Role.ROLE_REFEREE));
                httpResponce.sendRedirect("/WEB-INF/error/denied.jsp");
                return;
            }

        }
        if (isLoggedIn && role.equals(Role.ROLE_PLAYER)) {
            LOGGER.info("in AuthFilter:isLoggedIn && role.equals(Role.ROLE_PLAYER): " + (isLoggedIn && role.equals(Role.ROLE_PLAYER)));
            if (isPathAllowedForRole(path, Role.ROLE_PLAYER)) {
                LOGGER.info("in AuthFilter:isPathCorrect(path, Role.ROLE_PLAYER): " + isPathAllowedForRole(path, Role.ROLE_PLAYER));
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            } else {
                LOGGER.warn("in AuthFilter:isPathCorrect(path, Role.ROLE_PLAYER): " + isPathAllowedForRole(path, Role.ROLE_PLAYER));
                httpResponce.sendRedirect("/WEB-INF/error/denied.jsp");
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

    private boolean isPathAllowedForRole(String path, Role role) {
        System.out.println("Requested path: " + path + " by user with role " + role.name().toLowerCase());
        System.out.println("isPathCorrect: " + path.contains(role.name().replaceAll("ROLE_", "").toLowerCase()));
        return path.contains(role.name().replaceAll("ROLE_", "").toLowerCase());
    }

    @Override
    public void destroy() {

    }
}