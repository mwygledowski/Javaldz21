package pl.sda.filter;


import pl.sda.service.AuthenticationService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter("/to-do/*")
public class AuthenticationFilter extends HttpFilter {

    private AuthenticationService authenticationService = new AuthenticationService();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (authenticationService.isAuthenticated(req)) {
            super.doFilter(req, res, chain);
        } else {
            req.getRequestDispatcher("/login").forward(req, res);
        }
    }
}
