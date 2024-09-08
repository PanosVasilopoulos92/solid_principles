package org.viators.valid.model;

import org.viators.valid.interfaces.Printable;
import org.viators.valid.interfaces.SupplyManageable;

// BasicPrinter now implements only the interfaces it supports.
public class BasicPrinter implements Printable, SupplyManageable {

    @Override
    public void print(String document) {
        System.out.println("BasicPrinter: Printing " + document);
    }

    @Override
    public int getRemainingPaper() {
        return 100; // Example value
    }

    @Override
    public int getRemainingInk() {
        return 50; // Example value
    }

    @Override
    public void orderSupplies() {
        System.out.println("BasicPrinter: Ordering supplies");
    }
}
