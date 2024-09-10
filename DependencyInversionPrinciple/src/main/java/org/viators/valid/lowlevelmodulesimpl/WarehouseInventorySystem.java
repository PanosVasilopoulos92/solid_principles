package org.viators.valid.lowlevelmodulesimpl;

import org.viators.valid.lowlevelmodulesinterfaces.InventorySystem;

public class WarehouseInventorySystem implements InventorySystem {
    @Override
    public boolean checkStock(String productId, int quantity) {
        System.out.println("Checking stock for product " + productId + ", quantity: " + quantity);
        return Math.random() < 0.84; // 84% chance of being in stock
    }

    @Override
    public void updateStock(String productId, int quantity) {
        System.out.println("Updating stock for product " + productId + ", new quantity: " + quantity);
    }
}
