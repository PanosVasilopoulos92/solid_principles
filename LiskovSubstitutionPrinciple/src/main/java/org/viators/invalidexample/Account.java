package org.viators.invalidexample;

import org.viators.invalidexample.exceptions.InsufficientFundsException;
import org.viators.invalidexample.exceptions.WithdrawalLimitExceededException;

import java.math.BigDecimal;

// Base class
public class Account {
    protected String accountName;
    protected BigDecimal balance;

    public Account(String accountName, BigDecimal balance) {
        this.accountName = accountName;
        this.balance = balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    // Violation: Base class assumes that all accounts can deposit
    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    // Violation: Base class assumes that all accounts can withdraw
    public void withdraw(BigDecimal amount) throws InsufficientFundsException, WithdrawalLimitExceededException {
        if (balance.compareTo(amount) < 0) {
            throw new InsufficientFundsException("Not enough money in account.");
        }

        balance = balance.subtract(amount);
    }
}
