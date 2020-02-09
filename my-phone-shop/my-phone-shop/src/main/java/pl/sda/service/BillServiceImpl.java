package pl.sda.service;

import pl.sda.model.Product;

import java.math.BigDecimal;
import java.util.List;

public class BillServiceImpl implements BillService {
    @Override
    public BigDecimal calculateCartValue(Long userId, List<Product> products) {
        if(products.isEmpty()){
            return BigDecimal.ZERO;
        }
        return products.stream()
                .map(x-> x.getPrice())
                .reduce(BigDecimal::add).get();
    }
}
