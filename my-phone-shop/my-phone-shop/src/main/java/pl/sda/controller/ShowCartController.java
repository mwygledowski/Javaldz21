package pl.sda.controller;

import pl.sda.model.Product;
import pl.sda.service.BillService;
import pl.sda.service.BillServiceImpl;
import pl.sda.service.CartService;
import pl.sda.service.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/show-cart")
public class ShowCartController extends HttpServlet {

    private CartService cartService = new CartServiceImpl();
    private BillService billService = new BillServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> cart = cartService.getCart(req);
        req.setAttribute("cart", cart);
        req.setAttribute("totalValue", billService.calculateCartValue(1L, cart));
        req.getRequestDispatcher("/WEB-INF/view/show-cart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
