package org.viators.valid.discountstrategies;

import org.viators.valid.Order;

import java.math.BigDecimal;

// Now I added this new strategy without any need for modifying existing code, it can be simply added to Main method
// as a new discount strategy.
public class BulkDiscount implements DiscountStrategy {

    @Override
    public BigDecimal applyDiscount(Order order) {
        if (order.getTotalPrice().compareTo(BigDecimal.valueOf(50)) > 0){
            return order.getTotalPrice().multiply(BigDecimal.valueOf(0.7));
        }
        return order.getTotalPrice();
    }
}
