package org.viators.valid.highlevelmodulesintefaces;

import org.viators.valid.model.Order;

public interface AnalyticsService {
    void trackOrderProcessing(Order order);
}
