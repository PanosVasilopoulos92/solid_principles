package org.viators.valid.lowlevelmodulesimpl;

import org.viators.valid.lowlevelmodulesinterfaces.PaymentProcessor;

public class PayPalPaymentProcessor implements PaymentProcessor {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " via PayPal");
        return Math.random() < 0.92; // 92% success rate
    }
}
