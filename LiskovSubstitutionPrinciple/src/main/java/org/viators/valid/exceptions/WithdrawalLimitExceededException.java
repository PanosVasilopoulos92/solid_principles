package org.viators.valid.exceptions;

public class WithdrawalLimitExceededException extends Exception {

    public WithdrawalLimitExceededException(String message) {
        super(message);
    }
}
