package com.example.bank_app;

public final class TestData {
    private TestData() {
    }

    public static BankAccount[] getAccounts() {
        return new BankAccount[] {
                new BankAccount("Анна Смирнова", "100001"),
                new BankAccount("Иван Петров", "100002", 12500.00),
                new BankAccount("Мария Иванова", "100003", 8300.50)
        };
    }
}
