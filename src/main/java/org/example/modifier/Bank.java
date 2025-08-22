package org.example.modifier;

import java.util.ArrayList;
import java.util.List;

final public class Bank {
  final private List<BankAccount> accounts = new ArrayList<>();

  public void addAccount(BankAccount account) {
    if (this.accounts.stream().anyMatch(a -> a.getAccountNumber().equals(account.getAccountNumber()))) {
      throw new IllegalArgumentException("Account number already exists");
    }
    this.accounts.add(account);
  }

  public BankAccount findAccount(String accountNumber) {
    return accounts.stream()
                   .filter(a -> a.getAccountNumber().equals(accountNumber))
                   .findFirst()
                   .orElseThrow(() -> new IllegalArgumentException("Account not found"));
  }

  public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
    BankAccount fromAccount = findAccount(fromAccountNumber);
    BankAccount toAccount = findAccount(toAccountNumber);

    if (fromAccount.getBalance() < amount) {
      throw new IllegalArgumentException("Insufficient balance for transfer");
    }

    fromAccount.withdraw(amount);
    try {
      toAccount.deposit(amount);
    }
    catch (Exception e) {
      // Rollback the withdrawal if deposit fails
      fromAccount.deposit(amount);
      throw new IllegalArgumentException("Transfer failed: " + e.getMessage());
    }
  }
}
