package org.viators.valid;

import org.viators.valid.exceptions.ImmatureWithdrawalException;
import org.viators.valid.exceptions.InsufficientFundsException;
import org.viators.valid.exceptions.WithdrawalLimitExceededException;

import java.math.BigDecimal;

public class FixedDepositAccount extends Account{
    private boolean hasMatured = false;

    public FixedDepositAccount(String accountName, BigDecimal balance) {
        super(accountName, balance);
    }

    @Override
    public void deposit(BigDecimal amount) {
        if (hasMatured) {
            // If account is matured a fee of one euro will be set.
            balance = balance.add(amount.subtract(BigDecimal.valueOf(1)));
            System.out.println("Account has matured. A fee of 1 euro has been set.");
        }

        balance = balance.add(amount);
    }

    @Override
    public void withdraw(BigDecimal amount) throws InsufficientFundsException, ImmatureWithdrawalException {
        if (!hasMatured) {
            throw new ImmatureWithdrawalException("Cannot withdraw from immature fixed deposit account");
        }
        if (balance.compareTo(amount) < 0) {
            throw new InsufficientFundsException("Insufficient funds in fixed deposit account");
        }
        balance = balance.subtract(amount);
    }

    public boolean hasMatured() {
        return hasMatured;
    }

    public void setHasMatured(boolean hasMatured) {
        this.hasMatured = hasMatured;
    }
}
