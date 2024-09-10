package org.viators.invalidexample.highlevelmodules;

import org.viators.invalidexample.lowlevelmodules.EmailNotificationService;
import org.viators.invalidexample.lowlevelmodules.MySQLDatabase;
import org.viators.invalidexample.lowlevelmodules.PayPalPaymentProcessor;
import org.viators.invalidexample.lowlevelmodules.WarehouseInventorySystem;
import org.viators.invalidexample.model.Customer;
import org.viators.invalidexample.model.Order;

import java.util.List;

/*
    Dependency Inversion Priciple was violated because:
    1. The high-level OrderProcessor class depends directly on multiple low-level modules
       (MySQLDatabase, PayPalPaymentProcessor, WarehouseInventorySystem, EmailNotificationService).
    2. The OrderProcessor constructor create instances of these low-level modules, tightly coupling the classes together.
    3. There are no abstractions (interfaces) defining the contracts for various operations
       (database, payment processing, inventory management, notifications).
    4. Changing any of the low-level components would require significant changes to the OrderProcessor class.
    5. It's difficult to test the OrderProcessor in isolation, as it's tightly coupled with concrete implementations.
    6. Error handling and transaction management are mixed with business logic, making the code harder to maintain and
       extend.
 */


public class OrderProcessor {
    private final MySQLDatabase database;
    private final PayPalPaymentProcessor paymentProcessor;
    private final WarehouseInventorySystem inventorySystem;
    private final EmailNotificationService notificationService;

    // Constructor directly instantiates low-level modules, meaning now the OrderProccessor class is
    // tightly coupled with all of them.
    public OrderProcessor() {
        this.database = new MySQLDatabase();
        this.paymentProcessor = new PayPalPaymentProcessor();
        this.inventorySystem = new WarehouseInventorySystem();
        this.notificationService = new EmailNotificationService();
    }

    public void processOrder(Order order, Customer customer) {
        database.connect();

        // checks inventory for stock
        boolean existInStock = order.items().stream()
                .allMatch(orderItem -> inventorySystem.checkStock(orderItem.product().id(), orderItem.quantity()));

        if (!existInStock) {
            notificationService.sendEmail(customer.email(), "Order Failed.",
                    "Reason: Some items are out of stock");
            return;
        }

        // payment proccess
        boolean paymentSuccess = paymentProcessor.processPayment(order.totalAmount());

        if (!paymentSuccess) {
            notificationService.sendEmail(customer.email(), "Payment Failed",
                    "Reason: Your payment could not be processed");
            return;
        }

        // updates inventory
        order.items().forEach(orderItem ->
                inventorySystem.updateStock(orderItem.product().id(), orderItem.quantity()));

        // Updates order status (example query)
        String updateQuery = "UPDATE orders SET status = 'PAID' WHERE id = '" + order.id() + "'";
        database.executeQuery(updateQuery);

        // Fetches order details
        String selectQuery = "SELECT * FROM orders WHERE id = '" + order.id() + "'";
        List<String> orderDetails = database.fetchResults(selectQuery);

        // Sends confirmation email
        notificationService.sendEmail(customer.email(), "Order Confirmed",
                "Your order " + order.id() + " has been processed successfully.");

        System.out.println("Order " + order.id() + " processed successfully.");
    }
}
