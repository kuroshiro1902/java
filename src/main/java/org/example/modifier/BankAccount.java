package org.example.modifier;

import java.util.List;

abstract public class BankAccount {
  final private String accountNumber;
  final private String ownerName;
  private double balance;

  public BankAccount(String accountNumber, String ownerName) {
    this.accountNumber = accountNumber;
    this.ownerName = ownerName;
  }

  /**
   * Deposits a specified amount into the bank account.
   */
  public void deposit(double amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException("Deposit amount must be positive");
    }
    this.balance += amount;
  }

  public void withdraw(double amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException("Withdrawal amount must be positive");
    }
    if (amount > this.balance) {
      throw new IllegalArgumentException("Insufficient balance");
    }
    this.balance -= amount;
  }

  public double getBalance() {
    return this.balance;
  }

  public String getAccountNumber() {
    return this.accountNumber;
  }

  public void setBalance(double balance) {
    if (balance < 0) {
      throw new IllegalArgumentException("Balance cannot be negative");
    }
    this.balance = balance;
  }
}
