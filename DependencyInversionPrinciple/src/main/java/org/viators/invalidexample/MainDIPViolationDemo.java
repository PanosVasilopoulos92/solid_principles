package org.viators.invalidexample;

/*
    Dependency Inversion Principle (DIP):
    This principle states that high-level modules should not depend on low-level modules.
    Both should depend on abstractions. Abstractions should not depend on details. Details
    should depend on abstractions.

    - Problems caused by violating the DIP:
    1. The OrderProcessor class now depends on four concrete implementations(MySQLDatabase,
       PayPalPaymentProcessor, WarehouseInventorySystem, EmailNotificationService), worsen the
       DIP violation.
    2. Tight Coupling: Both OrderProcessor and the new AnalyticsService are tightly coupled with their
       dependencies, making the system rigid and hard to modify or test.
    3. Lack of Abstractions: There are still no interfaces defining the contracts for the various operations,
       violating a key aspect of DIP.
    4. Complex Business Logic: The processOrder method in OrderProcessor contains a mix of business logic,
       database operations, and error handling, making it difficult to maintain and test.
    5. Direct Instantiation: Both OrderProcessor and AnalyticsService create their dependencies directly,
       further increasing coupling.
    6. Inflexibility: Changing any of the low-level components (e.g., switching to a different database or
       payment processor) would require significant changes to multiple classes.
    7. Testing Challenges: The tight coupling makes it virtually impossible to unit test OrderProcessor or
       AnalyticsService in isolation.
 */

import org.viators.invalidexample.highlevelmodules.AnalyticsService;
import org.viators.invalidexample.highlevelmodules.OrderProcessor;
import org.viators.invalidexample.lowlevelmodules.MySQLDatabase;
import org.viators.invalidexample.model.Customer;
import org.viators.invalidexample.model.Order;
import org.viators.invalidexample.model.OrderItem;
import org.viators.invalidexample.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// client code
public class MainDIPViolationDemo {

    public static void main(String[] args) {
        MySQLDatabase mySQLDatabase = new MySQLDatabase();
        OrderProcessor orderProcessor = new OrderProcessor();
        AnalyticsService analyticsService = new AnalyticsService(mySQLDatabase);

        // sample order
        List<OrderItem> items = new ArrayList<>();
        items.add(new OrderItem(new Product("P1", "Laptop", 999.99), 1));
        items.add(new OrderItem(new Product("P2", "Mouse", 19.99), 2));
        Order order = new Order(UUID.randomUUID().toString(), items, 999.99 + 19.99, "PENDING");

        Customer customer1 = new Customer("C1", "Panos Vasilopoulos", "panos@gmail.com");

        // processing the order
        orderProcessor.processOrder(order, customer1);

        // tracks analytics
        analyticsService.trackOrderProcessing(order);
    }
}
