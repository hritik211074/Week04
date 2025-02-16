package com.day05_junit_testing.main.java.org.example;

public class BankAccount {
    private double balance;


    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {

            balance += amount;
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient funds or invalid withdrawal amount");
        }
    }

    public double getBalance() {
        return balance;
    }
}

