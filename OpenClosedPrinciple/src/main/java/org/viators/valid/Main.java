package org.viators.valid;

import org.viators.valid.discountstrategies.BulkDiscount;
import org.viators.valid.discountstrategies.BuyOneGetOneFreeDiscount;
import org.viators.valid.discountstrategies.FixedAmountDiscount;
import org.viators.valid.discountstrategies.PercentageDiscount;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        Product book = new Product("Book", BigDecimal.valueOf(16.0));
        Product pencil = new Product("Pencil", BigDecimal.valueOf(0.8));

        Order order2 = new Order();
        order2.addProduct(book);
        order2.addProduct(book);
        order2.addProduct(pencil);
        order2.addProduct(pencil);

        System.out.printf("Original price: %.2f€ %n".formatted(order2.getTotalPrice()));

        OrderProcessor percentDiscOrder = new OrderProcessor(new PercentageDiscount(BigDecimal.valueOf(20)));
        System.out.println("After 20% discount: " +
                percentDiscOrder.calculateTotal(order2));

        OrderProcessor fixedAmountDiscOrder = new OrderProcessor(new FixedAmountDiscount(BigDecimal.valueOf(10)));
        System.out.println("After a 10€ discount: " +
                fixedAmountDiscOrder.calculateTotal(order2));

        OrderProcessor onePlusOneDiscOrder = new OrderProcessor(new BuyOneGetOneFreeDiscount("Book"));
        System.out.println("After 1+1 discount: " +
                onePlusOneDiscOrder.calculateTotal(order2));

        System.out.println("-".repeat(12));

        order2.addProduct(book);
        order2.addProduct(book);
        System.out.printf("Updated original order price: %.2f%n", order2.getTotalPrice());
        // The newly added BulkStrategy
        OrderProcessor bulkDiscOrder = new OrderProcessor(new BulkDiscount());
        System.out.println("After bulk discount (orders above 50€ receive 30% discount): " +
                bulkDiscOrder.calculateTotal(order2));

    }
}
