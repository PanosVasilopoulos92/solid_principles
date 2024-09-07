package org.viators.valid;

import org.viators.valid.exceptions.ImmatureWithdrawalException;
import org.viators.valid.exceptions.InsufficientFundsException;
import org.viators.valid.exceptions.WithdrawalLimitExceededException;

import java.math.BigDecimal;

public abstract class Account {
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

    // Abstract methods that all accounts must implement.
    public abstract void deposit(BigDecimal amount);
    public abstract void withdraw(BigDecimal amount) throws InsufficientFundsException, WithdrawalLimitExceededException, ImmatureWithdrawalException;
}
