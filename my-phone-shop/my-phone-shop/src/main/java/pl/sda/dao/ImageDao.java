package pl.sda.dao;

import pl.sda.model.Product;

public interface ImageDao {
    String getImagePath(Long productId);
}
