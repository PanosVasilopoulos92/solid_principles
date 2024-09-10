package org.viators.valid.highlevelmodulesimpl;

import org.viators.valid.constants.OrderStatus;
import org.viators.valid.highlevelmodulesintefaces.OrderService;
import org.viators.valid.lowlevelmodulesinterfaces.Database;
import org.viators.valid.lowlevelmodulesinterfaces.InventorySystem;
import org.viators.valid.lowlevelmodulesinterfaces.NotifService;
import org.viators.valid.lowlevelmodulesinterfaces.PaymentProcessor;
import org.viators.valid.model.Customer;
import org.viators.valid.model.Order;

public class OrderServiceImpl implements OrderService {
    private final Database database;
    private final PaymentProcessor paymentProcessor;
    private final InventorySystem inventorySystem;
    private final NotifService notificationService;

    public OrderServiceImpl(Database database, PaymentProcessor paymentProcessor,
                            InventorySystem inventorySystem, NotifService notificationService) {
        this.database = database;
        this.paymentProcessor = paymentProcessor;
        this.inventorySystem = inventorySystem;
        this.notificationService = notificationService;
    }

    @Override
    public void processOrder(Order order, Customer customer) {
        database.connect();

        if (!checkInventory(order)) {
            updateOrderStatus(order, OrderStatus.FAILED);
            notifyCustomer(customer, "Order Failed", "Some items are out of stock");
            return;
        }

        if (!processPayment(order)) {
            updateOrderStatus(order, OrderStatus.FAILED);
            notifyCustomer(customer, "Payment Failed", "Your payment could not be processed");
            return;
        }

        updateInventory(order);
        updateOrderStatus(order, OrderStatus.PAID);
        notifyCustomer(customer, "Order Confirmed", "Your order " + order.id() +
                " has been processed successfully.");

        System.out.println("Order " + order.id() + " processed successfully.");
    }

    private boolean checkInventory(Order order) {
        return order.items().stream()
                .allMatch(orderItem -> inventorySystem.checkStock(orderItem.product().id(), orderItem.quantity()));
    }

    private boolean processPayment(Order order) {
        return paymentProcessor.processPayment(order.totalAmount());
    }

    private void updateInventory(Order order) {
        order.items().forEach(item ->
                inventorySystem.updateStock(item.product().id(), item.quantity()));
    }

    private void updateOrderStatus(Order order, OrderStatus status) {
        String updateQuery = "UPDATE orders SET status = '" + status + "' WHERE id = '" + order.id() + "'";
        database.executeQuery(updateQuery);
    }

    private void notifyCustomer(Customer customer, String subject, String body) {
        notificationService.sendNotification(customer.email(), subject, body);
    }
}
