package pl.sda.service;

import pl.sda.model.Product;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class CartServiceImpl implements CartService {

    ProductService productService = new ProductServiceImpl();


    @Override
    public void addToCart(Long id, HttpServletRequest req) {
        List<Long> cart = (List<Long>) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            req.getSession().setAttribute("cart", cart);
        }
        cart.add(id);
    }

    @Override
    public void removeFromCart(Long id, HttpServletRequest req) {
        List<Long> cart = (List<Long>) req.getSession().getAttribute("cart");
        cart.remove(id);
    }

    @Override
    public List<Product> getCart(HttpServletRequest req) {
        List<Long> cart = (List<Long>) req.getSession().getAttribute("cart");
        List<Product> cartProducts = new ArrayList<>();
        for(Long id : cart){
            cartProducts.add(productService.getProductById(id));
        }
        return cartProducts;
    }
}
