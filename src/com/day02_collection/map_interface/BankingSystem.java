package com.day02_collection.map_interface;

import java.util.*;

public class BankingSystem {

    // Store accounts
    Map<Integer, Double> accounts = new HashMap<>();
    // Sort by balance
    TreeMap<Double, Integer> sortedAccounts = new TreeMap<>();

    // Process withdrawals
    Queue<Integer> withdrawalQueue = new LinkedList<>();

    void createAccount(int accNo, double balance) {
        accounts.put(accNo, balance);
        sortedAccounts.put(balance, accNo);
    }

    void withdraw(int accNo, double amount) {
        if (accounts.containsKey(accNo) && accounts.get(accNo) >= amount) {
            accounts.put(accNo, accounts.get(accNo) - amount);
            sortedAccounts.put(accounts.get(accNo), accNo);
            withdrawalQueue.add(accNo);
        }
    }

    void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            int accNo = withdrawalQueue.poll();
            System.out.println("Processed withdrawal for Account: " + accNo);
        }
    }

    void displayAccounts() {
        System.out.println("Accounts: " + accounts);
        System.out.println("Sorted Accounts by Balance: " + sortedAccounts);
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.createAccount(101, 5000);
        bank.createAccount(102, 3000);
        bank.createAccount(103, 7000);

        bank.withdraw(101, 1000);
        bank.processWithdrawals();

        bank.displayAccounts();
    }
}

