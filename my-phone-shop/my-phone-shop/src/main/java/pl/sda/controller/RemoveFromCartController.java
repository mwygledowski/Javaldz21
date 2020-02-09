package pl.sda.controller;


import pl.sda.service.CartService;
import pl.sda.service.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/remove-from-cart")
public class RemoveFromCartController extends HttpServlet {

    private CartService cartService = new CartServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        cartService.removeFromCart(id, req);

        resp.sendRedirect(req.getHeader("referer"));
    }
}
