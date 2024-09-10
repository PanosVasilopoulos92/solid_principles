package org.viators.valid.highlevelmodulesintefaces;

import org.viators.valid.model.Customer;
import org.viators.valid.model.Order;

public interface OrderService {
    void processOrder(Order order, Customer customer);
}
