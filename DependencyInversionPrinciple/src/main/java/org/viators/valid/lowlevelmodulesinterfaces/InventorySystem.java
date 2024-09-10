package org.viators.valid.lowlevelmodulesinterfaces;

public interface InventorySystem {
    boolean checkStock(String productId, int quantity);
    void updateStock(String productId, int quantity);
}
