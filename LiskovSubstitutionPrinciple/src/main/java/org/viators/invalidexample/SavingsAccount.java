package org.viators.invalidexample;

import org.viators.invalidexample.exceptions.InsufficientFundsException;
import org.viators.invalidexample.exceptions.WithdrawalLimitExceededException;

import java.math.BigDecimal;

// SavingsAccount class adds a new precondition to the withdraw() method by introducing a withdrawal limit.
// This violates LSP because it strengthens the preconditions of the base class method.
public class SavingsAccount extends Account{
    private final BigDecimal DAILY_WITHDRAW_LIMIT = BigDecimal.valueOf(1000);

    public SavingsAccount(String accountName, BigDecimal balance) {
        super(accountName, balance);
    }

    // Violation: Changing behavior by adding a precondition to overridden method
    @Override
    public void withdraw(BigDecimal amount) throws InsufficientFundsException, WithdrawalLimitExceededException {
        if (amount.compareTo(DAILY_WITHDRAW_LIMIT)> 0){
            throw new  WithdrawalLimitExceededException("Amount exceeds daily limit.");
        }
        super.withdraw(amount);
    }

}
