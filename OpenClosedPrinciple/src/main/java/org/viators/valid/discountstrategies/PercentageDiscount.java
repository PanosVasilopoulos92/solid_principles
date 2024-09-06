package org.viators.valid.discountstrategies;

import org.viators.valid.Order;
import java.math.BigDecimal;
import java.math.RoundingMode;

// Concrete implementation of a percentage-based discount
public class PercentageDiscount implements DiscountStrategy {
    private BigDecimal percentageDiscount;

    public PercentageDiscount(BigDecimal percentageDiscount){
        this.percentageDiscount = percentageDiscount;
    }

    @Override
    public BigDecimal applyDiscount(Order order) {
        BigDecimal discount = order.getTotalPrice().multiply(percentageDiscount)
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        return order.getTotalPrice().subtract(discount);
    }
}
