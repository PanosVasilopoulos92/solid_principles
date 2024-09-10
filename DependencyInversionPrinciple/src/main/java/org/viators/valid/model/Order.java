package org.viators.valid.model;

import org.viators.valid.constants.OrderStatus;

import java.util.List;

public record Order(String id, List<OrderItem> items, double totalAmount, OrderStatus status) {
}
