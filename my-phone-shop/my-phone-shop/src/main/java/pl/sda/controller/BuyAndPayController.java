package pl.sda.controller;

import pl.sda.service.CartService;
import pl.sda.service.CartServiceImpl;
import pl.sda.service.OrderService;
import pl.sda.service.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/buy-and-pay")
public class BuyAndPayController extends HttpServlet {

    private OrderService orderService = new OrderServiceImpl();
    private CartService cartService= new CartServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        orderService.order("login", cartService.getCart(req));
        req.getRequestDispatcher("/WEB-INF/view/end-view.jsp").forward(req,resp);
    }
}
