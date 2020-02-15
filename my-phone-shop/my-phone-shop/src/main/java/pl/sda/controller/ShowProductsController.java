package pl.sda.controller;

import pl.sda.model.Brand;
import pl.sda.model.Product;
import pl.sda.service.ProductService;
import pl.sda.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/home")
public class ShowProductsController extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String[] brands = req.getParameterMap().get("brand");


        if (brands == null) {
            req.setAttribute("productsList", productService.getAllProducts());
        } else {
            List<Brand> brandsList = Arrays.asList(brands).stream().map(b -> Brand.valueOf(b)).collect(Collectors.toList());
            req.setAttribute("productsList", productService.getProductsByBrands(brandsList));
            req.setAttribute("selectedBrands",Arrays.asList(brands).stream().map(b->Brand.valueOf(b)).collect(Collectors.toList()));

        }

        req.setAttribute("brands", Brand.values());
        req.getRequestDispatcher("/WEB-INF/view/show-products.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
