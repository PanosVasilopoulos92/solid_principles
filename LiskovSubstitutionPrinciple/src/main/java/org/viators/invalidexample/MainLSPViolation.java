package org.viators.invalidexample;

import java.math.BigDecimal;

public class MainLSPViolation {

    public static void main(String[] args) {
        Bank bank = new Bank();

        CheckingAccount checkingAccount = new CheckingAccount("PanosAccount",
                new BigDecimal("1000"));
        SavingsAccount savingsAccount = new SavingsAccount("AngelikiAccount",
                new BigDecimal("19000"));
        FixedDepositAccount fixedDepositAccount = new FixedDepositAccount("EfraimAccount",
                new BigDecimal("12000"));

        bank.addAccount(checkingAccount);
        bank.addAccount(savingsAccount);
        bank.addAccount(fixedDepositAccount);

        // Perform operations that demonstrate LSP violations and cause runtime exceptions.
        bank.processDeposit("PanosAccount", new BigDecimal("500.00"));  // Works
        bank.processWithdraws("PanosAccount", new BigDecimal("200.00"));  // Works

        bank.processDeposit("AngelikiAccount", new BigDecimal("1000.00"));  // Works
        bank.processWithdraws("AngelikiAccount", new BigDecimal("2000.00"));  // Throws uncaught WithdrawalLimitExceededException

        bank.processDeposit("EfraimAccount", new BigDecimal("5000.00"));  // Works
        bank.processWithdraws("EfraimAccount", new BigDecimal("1000.00"));  // Throws UnsupportedOperationException

        // Mature the fixed deposit account and execute deposit method again:
        fixedDepositAccount.setHasMatured(true);
        bank.processDeposit("EfraimAccount", new BigDecimal("1000.00"));  // Throws UnsupportedOperationException
    }
}
