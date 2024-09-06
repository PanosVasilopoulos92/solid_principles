package org.viators.valid.discountstrategies;

import org.viators.valid.Order;

import java.math.BigDecimal;

// By making the discount strategy an interface we adhere to the Open-Closed Principle, meaning
// that new discount strategies can be added later without needing to modify any existing code.
public interface DiscountStrategy {
    BigDecimal applyDiscount(Order order);
}
