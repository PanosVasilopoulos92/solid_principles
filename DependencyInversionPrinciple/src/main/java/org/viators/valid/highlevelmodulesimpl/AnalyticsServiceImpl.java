package org.viators.valid.highlevelmodulesimpl;

import org.viators.valid.highlevelmodulesintefaces.AnalyticsService;
import org.viators.valid.lowlevelmodulesinterfaces.Database;
import org.viators.valid.model.Order;

import java.time.LocalDateTime;

public class AnalyticsServiceImpl implements AnalyticsService {
    private final Database database;

    public AnalyticsServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public void trackOrderProcessing(Order order) {
        String query = "INSERT INTO analytics (order_id, timestamp, total_amount) VALUES ('" +
                order.id() + "', '" + LocalDateTime.now() + "', " + order.totalAmount() + ")";
        database.executeQuery(query);
    }
}
