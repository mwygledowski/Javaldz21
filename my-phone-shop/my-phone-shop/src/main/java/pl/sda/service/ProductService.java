package pl.sda.service;

import pl.sda.model.Brand;
import pl.sda.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(Long id);

    List<Product> getProductsByBrands(List<Brand> brands);
}
