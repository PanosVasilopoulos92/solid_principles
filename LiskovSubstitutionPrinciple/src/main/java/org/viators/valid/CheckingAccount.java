package org.viators.valid;

import org.viators.valid.exceptions.ImmatureWithdrawalException;
import org.viators.valid.exceptions.InsufficientFundsException;
import org.viators.valid.exceptions.WithdrawalLimitExceededException;

import java.math.BigDecimal;

public class CheckingAccount extends Account{

    public CheckingAccount(String accountName, BigDecimal balance) {
        super(accountName, balance);
    }

    @Override
    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    @Override
    public void withdraw(BigDecimal amount) throws InsufficientFundsException, WithdrawalLimitExceededException, ImmatureWithdrawalException {
        if (balance.compareTo(amount)< 0){
            throw new InsufficientFundsException("Not enough money in account.");
        }

        balance = balance.subtract(amount);
    }

}
