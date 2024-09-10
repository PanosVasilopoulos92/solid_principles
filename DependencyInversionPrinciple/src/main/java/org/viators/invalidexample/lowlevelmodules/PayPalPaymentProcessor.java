package org.viators.invalidexample.lowlevelmodules;

public class PayPalPaymentProcessor {
    public boolean processPayment(double amount) {
        System.out.println("Processing payment of " + amount + " euros via PayPal");
        return Math.random() < 0.9; // 90% success rate
    }
}
