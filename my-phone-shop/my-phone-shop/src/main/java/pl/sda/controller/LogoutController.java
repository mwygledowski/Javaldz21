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

@WebServlet("/logout")
public class LogoutController extends HttpServlet {

    private AuthorizationService authorizationService= new AuthorizationServiceImpl();
    private CartService cartService = new CartServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        authorizationService.logout(req);
        cartService.removeAllProducts(req);
        req.getRequestDispatcher("/home").forward(req,resp);

    }


}
