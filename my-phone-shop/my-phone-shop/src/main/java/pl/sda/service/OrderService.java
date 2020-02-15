package pl.sda.service;

import pl.sda.model.Product;

import java.util.List;

public interface OrderService {
    void order(String login, List<Product> products);
}
