package pl.sda.service;

import pl.sda.model.Product;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CartServiceImpl implements CartService {

    ProductService productService = new ProductServiceImpl();
    private static String CART = "cart";
    


    @Override
    public void addToCart(Long id, HttpServletRequest req) {
        List<Long> cart = (List<Long>) req.getSession().getAttribute(CART);
        if (cart == null) {
            cart = new ArrayList<>();
            req.getSession().setAttribute(CART, cart);
        }
        cart.add(id);
    }

    @Override
    public void removeFromCart(Long id, HttpServletRequest req) {
        List<Long> cart = (List<Long>) req.getSession().getAttribute(CART);
        cart.remove(id);
    }

    @Override
    public List<Product> getCart(HttpServletRequest req) {
        List<Long> cart = (List<Long>) req.getSession().getAttribute(CART);
        List<Product> cartProducts = new ArrayList<>();

        if(cart==null){
            return Collections.emptyList();
        }

        for(Long id : cart){
            cartProducts.add(productService.getProductById(id));
        }
        return cartProducts;
    }

    @Override
    public void removeAllProducts(HttpServletRequest req) {
        req.getSession().setAttribute(CART, Collections.EMPTY_LIST);
    }
}
