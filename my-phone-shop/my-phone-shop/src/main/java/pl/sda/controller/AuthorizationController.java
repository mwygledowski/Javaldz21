package pl.sda.controller;

import pl.sda.service.AuthorizationService;
import pl.sda.service.AuthorizationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/authorization")
public class AuthorizationController extends HttpServlet {

    private AuthorizationService authorizationService = new AuthorizationServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(authorizationService.authorize(req)){
            req.setAttribute("invalidCredentials",false);
            req.getRequestDispatcher("/home").forward(req,resp);
        }else{

            req.setAttribute("invalidCredentials",true);
            req.getRequestDispatcher("/login").forward(req,resp);
        }
    }
}
