package org.example.modifier.impl;
import org.example.modifier.BankAccount;

final public class CheckingAccount extends BankAccount {
    final private double overdraftLimit;

    public CheckingAccount(String accountNumber, String ownerName, double overdraftLimit) {
        super(accountNumber, ownerName);
        if (overdraftLimit < 0) {
            throw new IllegalArgumentException("Overdraft limit cannot be negative");
        }
        this.overdraftLimit = overdraftLimit;
    }

  public void withdraw(double amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException("Withdrawal amount must be positive");
    }
    if (amount > this.getBalance() + this.overdraftLimit) {
      throw new IllegalArgumentException("Withdrawal exceeds overdraft limit");
    }
    double newBalance = this.getBalance() - amount;
    this.setBalance(newBalance);
  }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }
}
