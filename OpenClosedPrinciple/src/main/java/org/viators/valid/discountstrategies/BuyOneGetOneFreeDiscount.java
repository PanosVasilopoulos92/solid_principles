package org.viators.valid.discountstrategies;

import org.viators.valid.Order;
import org.viators.valid.Product;

import java.math.BigDecimal;

// Concrete implementation of a buy-one-get-one-free discount
public class BuyOneGetOneFreeDiscount implements DiscountStrategy{
    private final String productName;

    public BuyOneGetOneFreeDiscount(String productName) {
        this.productName = productName;
    }

    @Override
    public BigDecimal applyDiscount(Order order) {
        long count = order.getProducts().stream()
                .filter(product -> product.name().equals(productName))
                .count();
        BigDecimal discount = order.getProducts().stream()
                .filter(product -> product.name().equals(productName))
                .map(Product::price)
                .findFirst()
                .orElse(BigDecimal.ZERO)
                .multiply(BigDecimal.valueOf(count/2));
        return order.getTotalPrice().subtract(discount);
    }
}
