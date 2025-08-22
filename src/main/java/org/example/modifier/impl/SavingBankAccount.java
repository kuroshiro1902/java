package org.example.modifier.impl;

import org.example.modifier.BankAccount;

final public class SavingBankAccount extends BankAccount {
    private final double interestRate;

    public SavingBankAccount(String accountNumber, String ownerName, double interestRate) {
        super(accountNumber, ownerName);
        if(interestRate < 0 || interestRate > 1) {
            throw new IllegalArgumentException("Interest rate must be between 0 and 1");
        }
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = this.getBalance() * this.interestRate;
        this.deposit(interest);
    }

}
