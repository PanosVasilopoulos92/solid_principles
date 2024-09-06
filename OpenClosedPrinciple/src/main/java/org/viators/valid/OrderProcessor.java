package org.viators.valid;

import org.viators.valid.discountstrategies.DiscountStrategy;

import java.math.BigDecimal;

// The OrderProcessor class is now closed for modification but open for extension
// It can work with any DiscountStrategy or with none without being modified
public class OrderProcessor {
    private final DiscountStrategy discountStrategy;

    public OrderProcessor(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public BigDecimal calculateTotal(Order order) {

        return discountStrategy.applyDiscount(order);
    }
}
