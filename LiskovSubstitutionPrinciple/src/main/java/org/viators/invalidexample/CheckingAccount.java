package org.viators.invalidexample;

import java.math.BigDecimal;

// Will inherit behavior from parent class.
public class CheckingAccount extends Account{

    public CheckingAccount(String accountName, BigDecimal balance) {
        super(accountName, balance);
    }
}
