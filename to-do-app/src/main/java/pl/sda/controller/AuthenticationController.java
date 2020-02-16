package pl.sda.controller;

import pl.sda.service.AuthenticationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet ("/authentication")
public class AuthenticationController extends HttpServlet {

    private AuthenticationService authenticationService = new AuthenticationService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (authenticationService.authenticate(req)){
            req.getRequestDispatcher("/to-do/show-tasks").forward(req, resp);
        } else {
            req.setAttribute("invalidCredentials", true);
            req.getRequestDispatcher("/login").forward(req, resp);
        }
    }
}
