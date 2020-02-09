package pl.sda.dao;

import pl.sda.entity.ProductEntity;

import java.util.List;

public interface ProductDao {
    List<ProductEntity> getAllProductsEntities();
}
