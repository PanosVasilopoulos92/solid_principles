package org.viators.valid;

import org.viators.valid.constants.OrderStatus;
import org.viators.valid.highlevelmodulesintefaces.AnalyticsService;
import org.viators.valid.highlevelmodulesintefaces.OrderService;
import org.viators.valid.model.Customer;
import org.viators.valid.model.Order;
import org.viators.valid.model.OrderItem;
import org.viators.valid.model.Product;

import java.util.List;
import java.util.UUID;

/*
    Dependency Inversion Principle (DIP):
    This principle states that high-level modules should not depend on low-level modules.
    Both should depend on abstractions. Abstractions should not depend on details. Details
    should depend on abstractions.

    This mini projects adheres to all SOLID principles, not just to DIP. It demonstrates
    how to apply SOLID principles into a little more complex application. For example:
    1. Single Responsibility Principle (SRP):
       Each class and interface has a single, well-defined responsibility. OrderService
       is responsible for processing orders, while AnalyticsService handles analytics tracking.
    2. Open-Closed Principle (OCP):
       The system is open for extension but closed for modification. New payment processors,
       inventory systems, or notification services can be added without modifying existing code.
    3. Liskov Substitution Principle (LSP):
       Interfaces are used to define contracts, ensuring that any implementation can be substituted
       without affecting the system's behavior. For example, different Database implementations can be
       used interchangeably.
    4. Interface Segregation Principle (ISP):
       Intergfaces are kept small and focused. For example, separate interfaces for Database, PaymentProcessor,
       InventorySystem, and NotifService instead of a large, monolithic interface.
    5. Dependency Inversion Principle (DIP):
       High-level modules (OrderService, AnalyticsService) depend on abstractions (interfaces) rather than
       concrete implementations. Dependencies are injected through constructors, allowing for easy substitution
       and testing.
*/

// client code
public class MainDIP {

    public static void main(String[] args) {
        OrderService orderService = ServiceFactory.createOrderService();
        AnalyticsService analyticsService = ServiceFactory.createAnalyticsService();

        // sample order
        List<OrderItem> items = List.of(
                new OrderItem(new Product("P1", "Laptop", 999.99), 1),
                new OrderItem(new Product("P2", "Mouse", 18.20), 2)
        );
        Order order1 = new Order(UUID.randomUUID().toString(), items, 999.99 + 18.20, OrderStatus.PENDING);

        Customer customer1 = new Customer("C2", "Panos Vasilopoulos", "panos@gmail.com");

        orderService.processOrder(order1, customer1);

        analyticsService.trackOrderProcessing(order1);
    }
}
