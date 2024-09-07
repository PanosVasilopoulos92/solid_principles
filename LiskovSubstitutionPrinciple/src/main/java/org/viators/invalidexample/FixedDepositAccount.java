package org.viators.invalidexample;

import org.viators.invalidexample.exceptions.InsufficientFundsException;
import org.viators.invalidexample.exceptions.WithdrawalLimitExceededException;

import java.math.BigDecimal;

// FixedDepositAccount class completely changes the behavior of withdraw() by throwing an UnsupportedOperationException.
// This violates LSP because a FixedDepositAccount cannot be used interchangeably with its parent Account class.
public class FixedDepositAccount extends Account {
    private boolean hasMatured = false;

    public FixedDepositAccount(String accountName, BigDecimal balance) {
        super(accountName, balance);
    }

    public FixedDepositAccount(String accountName, BigDecimal balance, boolean hasMatured) {
        super(accountName, balance);
        this.hasMatured = hasMatured;
    }

    // Violation: Completely changing behavior, totally breaking LSP
    @Override
    public void withdraw(BigDecimal amount) throws InsufficientFundsException, WithdrawalLimitExceededException {
        throw new UnsupportedOperationException("Cannot withraw from a fixed account.");
    }

    // Violation: Changes the behavior of deposit method.
    // This violates LSP because it weakens the postconditions of the base class method.
    @Override
    public void deposit(BigDecimal amount) {
        if (!hasMatured) {
            super.deposit(amount);
        } else {
            throw new UnsupportedOperationException("Cannot deposit to a matured fixed deposit account");
        }
    }

    public void setHasMatured(boolean hasMatured) {
        this.hasMatured = hasMatured;
    }
}
