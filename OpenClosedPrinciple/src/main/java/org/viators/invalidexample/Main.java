package org.viators.invalidexample;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        Product book = new Product("Book", BigDecimal.valueOf(10.0));
        Product pencil = new Product("Pencil", BigDecimal.valueOf(0.8));

        Order order1 = new Order();
        order1.addProduct(book);
        order1.addProduct(book);
        order1.addProduct(pencil);
        order1.addProduct(pencil);

        OrderProcessor orderProcessor = new OrderProcessor();
        System.out.printf("Original order price: %.2f €.%n".formatted(order1.getTotalPrice()));

        // Calculate price after discount if applicable
        System.out.println("After 20% discount: " +
                orderProcessor.calculateTotal(order1, OrderProcessor.DiscountType.PERCENTAGE_DISCOUNT,
                        BigDecimal.valueOf(20), null));

        System.out.println("After 11 euros off: " +
                orderProcessor.calculateTotal(order1, OrderProcessor.DiscountType.FIXED_AMOUNT_DISCOUNT,
                        BigDecimal.valueOf(11), null));

        System.out.println("After 1+1 offer: " +
                orderProcessor.calculateTotal(order1, OrderProcessor.DiscountType.BUY_ONE_GET_ONE_FREE,
                        null, "Pencil"));
    }
}
