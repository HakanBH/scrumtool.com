package web.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class AuthenticationFilter extends OncePerRequestFilter {
    private static final String HOME_PAGE = "/";
    private static final String LOGIN_PAGE = "/users/login";
    private static final String REGISTER_PAGE = "/users/register";

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        if (resourceRequest(httpServletRequest)) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } else {
            if (isAuthenticated(httpServletRequest)) {
                filterChain.doFilter(httpServletRequest, httpServletResponse);
            } else {
                if (authenticationRequest(httpServletRequest)) {
                    filterChain.doFilter(httpServletRequest, httpServletResponse);
                } else {
                    httpServletResponse.sendRedirect("/");
                }
            }
        }
    }

    private boolean isAuthenticated(HttpServletRequest request) {
        return request.getSession().getAttribute("loggedUser") != null;
    }

    private boolean authenticationRequest(HttpServletRequest request) {
        String requestUrl = request.getRequestURI();
        return requestUrl.equals(HOME_PAGE) || requestUrl.equals(LOGIN_PAGE) || requestUrl.equals(REGISTER_PAGE);
    }

    private boolean resourceRequest(HttpServletRequest request) {
        String servletPath = request.getServletPath();
        return servletPath.contains("css") || servletPath.contains("images") || servletPath.contains("jpg")
                || servletPath.contains("js") || servletPath.contains("ico");

    }
}