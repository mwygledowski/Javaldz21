package pl.sda.controller;

import pl.sda.service.AuthorizationService;
import pl.sda.service.AuthorizationServiceImpl;
import pl.sda.service.CartService;
import pl.sda.service.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/authorization")
public class AuthorizationController extends HttpServlet {

    private AuthorizationService authorizationService = new AuthorizationServiceImpl();
    private CartService cartService = new CartServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (authorizationService.authorize(req)) {
            req.setAttribute("invalidCredentials", false);

            if (cartService.getCart(req).isEmpty()) {
                req.getRequestDispatcher("/home").forward(req, resp);
            } else {
                req.getRequestDispatcher("/show-cart").forward(req, resp);
            }
        } else {

            req.setAttribute("invalidCredentials", true);
            req.getRequestDispatcher("/login").forward(req, resp);
        }
    }
}
