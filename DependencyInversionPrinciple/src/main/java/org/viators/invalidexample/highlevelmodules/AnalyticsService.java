package org.viators.invalidexample.highlevelmodules;

import org.viators.invalidexample.lowlevelmodules.MySQLDatabase;
import org.viators.invalidexample.model.Order;

import java.time.LocalDateTime;

// Analytics module is !tightly coupled! with MysSQLDatabase
public class AnalyticsService {

    private final MySQLDatabase database;

    public AnalyticsService(MySQLDatabase database) {
        this.database = database;
    }

    public void trackOrderProcessing(Order order) {
        String query = "INSERT INTO analytics (order_id, timestamp, total_amount) VALUES ('" +
                order.id() + "', '" + LocalDateTime.now() + "', " + order.totalAmount() + ")";
        database.executeQuery(query);
    }
}
