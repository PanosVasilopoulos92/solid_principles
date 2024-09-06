package org.viators.valid.discountstrategies;

import org.viators.valid.Order;

import java.math.BigDecimal;

// Concrete implementation of a fixed amount discount.
public class FixedAmountDiscount implements DiscountStrategy{
    private final BigDecimal discountAmount;

    public FixedAmountDiscount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public BigDecimal applyDiscount(Order order) {
        return order.getTotalPrice().subtract(discountAmount);
    }
}
