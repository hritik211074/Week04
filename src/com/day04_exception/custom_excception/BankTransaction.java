package com.day04_exception.custom_excception;

class InsufficientBalanceException extends Exception {
    // Custom exception for insufficient balance
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    // Constructor to initialize account balance
    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!"); // Handle negative amount
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!"); // Handle insufficient balance
        }
        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }
}

public class BankTransaction {
    public static void main(String[] args) {
        // Creating a bank account with an initial balance of 500
        BankAccount account = new BankAccount(500);

        try {
            // Attempt to withdraw more than the balance
            account.withdraw(600);
        } catch (InsufficientBalanceException e) {

            // Catch and display insufficient balance error
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            // Catch and display invalid amount error
            System.out.println(e.getMessage());
        }
    }
}
