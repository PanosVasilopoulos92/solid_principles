package org.viators.invalidexample.model;

import java.util.List;

public record Order(String id, List<OrderItem> items, double totalAmount, String status) {
}
