package com.day05_junit_testing.test.java;

import org.example.BankAccount;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    void setup() {
        account = new BankAccount(100.0); // Initial balance of 100
    }

    @Test
    void testDeposit() {
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance());
    }

    @Test
    void testWithdrawSuccess() {
        account.withdraw(30.0);
        assertEquals(70.0, account.getBalance());
    }

    @Test
    void testWithdrawInsufficientFunds() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(200.0));
    }

    @Test
    void testNegativeDeposit() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-10.0));
    }

    @Test
    void testNegativeWithdraw() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-20.0));
    }
}
