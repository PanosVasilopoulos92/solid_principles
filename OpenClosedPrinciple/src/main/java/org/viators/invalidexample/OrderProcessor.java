package org.viators.invalidexample;

import java.math.BigDecimal;
import java.math.RoundingMode;

// The OrderProcessor class violates the Open-Closed Principle because it uses enum to define discount types
public class OrderProcessor {

    public enum DiscountType {
        NO_DISCOUNT,
        PERCENTAGE_DISCOUNT,
        FIXED_AMOUNT_DISCOUNT,
        BUY_ONE_GET_ONE_FREE
    }

    // Violation: One method that handles all the discount types. If a new discount type occurs the method has to be modified.
    public BigDecimal calculateTotal(Order order, DiscountType discountType,
                                     BigDecimal discountAmount, String productName){
        BigDecimal totalPrice = order.getTotalPrice();

        // Violation: Switch statement will have to be modified for every new discount type that may be added in the future.
        switch (discountType){
            case PERCENTAGE_DISCOUNT:
                BigDecimal discountFactor = BigDecimal.ONE.subtract(
                        discountAmount.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP)
                );
                return totalPrice.multiply(discountFactor);
            case FIXED_AMOUNT_DISCOUNT:
                return totalPrice.subtract(discountAmount);
            case BUY_ONE_GET_ONE_FREE:
                long count = order.getProducts().stream()
                        .filter(p -> p.name().equals(productName))
                        .count();
                BigDecimal discount = order.getProducts().stream()
                        .filter(p -> p.name().equals(productName))
                        .map(Product::price)
                        .findFirst()
                        .orElse(BigDecimal.ZERO)
                        .multiply(BigDecimal.valueOf(count / 2)); // now if for example 4 products match the productName, only two will be paid by the customer
                return totalPrice.subtract(discount);
            case NO_DISCOUNT:
            default:
                return totalPrice;
        }
    }


}
