package org.viators.valid;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public BigDecimal getTotalPrice() {
        return products.stream()
                .map(Product::price)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
