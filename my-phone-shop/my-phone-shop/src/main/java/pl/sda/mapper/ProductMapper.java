package pl.sda.mapper;

import pl.sda.entity.ProductEntity;
import pl.sda.model.Product;

import java.util.List;

public class ProductMapper {

    private ProductMapper() {
    }

    public static Product mapToProduct(ProductEntity productEntity, String imagePath) {
        return Product.builder()
                .id(productEntity.getId())
                .brand(productEntity.getBrand())
                .model(productEntity.getModel())
                .operatingSystem(productEntity.getOperatingSystem())
                .primaryCameraMp(productEntity.getPrimaryCameraMp())
                .secondaryCameraMp(productEntity.getSecondaryCameraMp())
                .price(productEntity.getSellingPrice())
                .imagePath(imagePath)
                .build();
    }

}
