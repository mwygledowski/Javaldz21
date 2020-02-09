package pl.sda.service;

import pl.sda.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface BillService {

    BigDecimal calculateCartValue(Long userId, List<Product> products);

}
