package org.viators.valid;

import org.viators.valid.highlevelmodulesimpl.AnalyticsServiceImpl;
import org.viators.valid.highlevelmodulesimpl.OrderServiceImpl;
import org.viators.valid.highlevelmodulesintefaces.AnalyticsService;
import org.viators.valid.highlevelmodulesintefaces.OrderService;
import org.viators.valid.lowlevelmodulesimpl.EmailNotificationService;
import org.viators.valid.lowlevelmodulesimpl.MySQLDatabase;
import org.viators.valid.lowlevelmodulesimpl.PayPalPaymentProcessor;
import org.viators.valid.lowlevelmodulesimpl.WarehouseInventorySystem;

// Factory class for creating service instances (simplifies dependency injection)
public class ServiceFactory {
    public static OrderService createOrderService() {
        return new OrderServiceImpl(
                new MySQLDatabase(),
                new PayPalPaymentProcessor(),
                new WarehouseInventorySystem(),
                new EmailNotificationService()
        );
    }

    public static AnalyticsService createAnalyticsService() {
        return new AnalyticsServiceImpl(
                new MySQLDatabase()
        );
    }

}
