package pl.sda.controller;

import pl.sda.model.Product;
import pl.sda.service.ProductService;
import pl.sda.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/show-product")
public class ShowProductController extends HttpServlet {

    private static ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Product product = productService.getProductById(Long.valueOf(id));
        req.setAttribute("product", product);

        req.getRequestDispatcher("/WEB-INF/view/show-product.jsp").forward(req, resp);


    }
}
