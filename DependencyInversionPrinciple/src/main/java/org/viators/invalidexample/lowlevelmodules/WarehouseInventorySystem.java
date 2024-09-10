package org.viators.invalidexample.lowlevelmodules;

public class WarehouseInventorySystem {
    public boolean checkStock(String productId, int quantity) {
        System.out.println("Checking stock for product " + productId + ", quantity: " + quantity);
        return Math.random() < 0.8; // 80% chance of being in stock
    }

    public void updateStock(String productId, int quantity) {
        System.out.println("Updating stock for product " + productId + ", new quantity: " + quantity);
    }
}
