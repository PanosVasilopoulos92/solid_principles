package org.viators.valid;

import org.viators.valid.exceptions.ImmatureWithdrawalException;
import org.viators.valid.exceptions.InsufficientFundsException;
import org.viators.valid.exceptions.WithdrawalLimitExceededException;

import java.math.BigDecimal;

public class SavingsAccount extends Account {
    private final BigDecimal WITHDRAW_LIMIT = BigDecimal.valueOf(1000);

    public SavingsAccount(String accountName, BigDecimal balance) {
        super(accountName, balance);
    }

    @Override
    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    @Override
    public void withdraw(BigDecimal amount) throws InsufficientFundsException, WithdrawalLimitExceededException, ImmatureWithdrawalException {
        if (balance.compareTo(amount) < 0) {
            throw new InsufficientFundsException("Not enough money in account.");
        }
        if (amount.compareTo(WITHDRAW_LIMIT) > 0) {
            throw new WithdrawalLimitExceededException("Amount exceeds daily limit.");
        }

        balance = balance.subtract(amount);
    }

}
