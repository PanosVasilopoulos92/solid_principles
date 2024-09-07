package org.viators.valid;

import org.viators.valid.exceptions.ImmatureWithdrawalException;
import org.viators.valid.exceptions.InsufficientFundsException;
import org.viators.valid.exceptions.WithdrawalLimitExceededException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.add(account);
    }

    // This method demonstrates LSP
    // It can work with any type of Account WITHOUT knowing the specific subclass
    public void processDeposit(String accountName, BigDecimal amount) {
        Account account = findAccount(accountName);

        if (account != null) {
            account.deposit(amount);
            System.out.printf("%.2f have been added to your account.%n", amount);
        } else {
            System.out.println("Account not found");
        }
    }

    // This method also demonstrates LSP
    // It handles withdrawals for any Account subclass!
    public void processWithdrawal(String accountName, BigDecimal amount) {
        Account account = findAccount(accountName);

        if (account != null) {
            try {
                account.withdraw(amount);
                System.out.printf("%.2f have been withdrawn from account.%n", amount);
            } catch (InsufficientFundsException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (WithdrawalLimitExceededException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (ImmatureWithdrawalException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Account not found");
        }
    }

    private Account findAccount(String accountName) {
        return accounts.stream()
                .filter(name -> name.getAccountName().equals(accountName))
                .findFirst()
                .orElse(null);
    }
}
