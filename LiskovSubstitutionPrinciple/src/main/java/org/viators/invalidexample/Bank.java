package org.viators.invalidexample;

import org.viators.invalidexample.exceptions.InsufficientFundsException;
import org.viators.invalidexample.exceptions.WithdrawalLimitExceededException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
/*
Bank class that demonstrates the LSP violations.
1) Bank class doesn't handle all possible exceptions that could be thrown by the withdraw() method of different account types.
   This can lead to runtime errors and violates the expectation set by the base Account class.
2) Bank class needs to use try-catch blocks to handle different behaviors of subclasses, which is a sign that LSP is being violated.
   In a design that follows LSP, such type checking or exception handling shouldn't be necessary.
*/
public class Bank {
    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.add(account);
    }

    // This method violates LSP because it doesn't work correctly for all Account subclasses
    public void processDeposit(String accountName, BigDecimal amount) {
        Account account = findAccount(accountName);

        if (account != null) {
            try {
                account.deposit(amount);
                System.out.printf("%.2f have been added to your account.%n", amount);
            } catch (UnsupportedOperationException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Account was not found.");
        }
    }

    public void processWithdraws(String accountName, BigDecimal amount) {
        Account account = findAccount(accountName);

        if (account != null) {
            try {
                account.withdraw(amount);
                System.out.printf("%.2f have been withdrawn from account.", amount);
            } catch (InsufficientFundsException e) {
                throw new RuntimeException(e);
            } catch (WithdrawalLimitExceededException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Account was not found.");
        }
    }

    private Account findAccount(String accountName) {
        return accounts.stream()
                .filter(account -> account.getAccountName().equals(accountName))
                .findFirst()
                .orElse(null);
    }

}
