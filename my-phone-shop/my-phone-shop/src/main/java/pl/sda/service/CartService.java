package pl.sda.service;
import pl.sda.model.Product;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface CartService {

    void addToCart(Long id, HttpServletRequest req);
    void removeFromCart(Long id, HttpServletRequest req);
    List<Product> getCart(HttpServletRequest req);

}
