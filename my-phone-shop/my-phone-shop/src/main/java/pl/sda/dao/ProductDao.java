package pl.sda.dao;

import pl.sda.entity.ProductEntity;
import pl.sda.model.Product;

import java.util.List;

public interface ProductDao {
    List<ProductEntity> getAllProductsEntities();

    ProductEntity getProductById(Long id);
}
