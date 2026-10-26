package com.example.bank_app;

public class BankAccount {
    private static int accountsCount;

    private final String owner;
    private final String accountNumber;
    private double balance;

    public BankAccount(String owner, String accountNumber) {
        this(owner, accountNumber, 0.0);
    }

    public BankAccount(String owner, String accountNumber, double initialBalance) {
        if (owner == null || owner.trim().isEmpty()) {
            throw new IllegalArgumentException("Владелец счёта не может быть пустым.");
        }
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Номер счёта не может быть пустым.");
        }
        if (!Double.isFinite(initialBalance) || initialBalance < 0) {
            throw new IllegalArgumentException("Начальный баланс должен быть неотрицательным числом.");
        }

        this.owner = owner.trim();
        this.accountNumber = accountNumber.trim();
        this.balance = initialBalance;
        accountsCount++;
    }

    public String getOwner() {
        return owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public static int getAccountsCount() {
        return accountsCount;
    }

    public boolean deposit(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            return false;
        }

        double newBalance = balance + amount;
        if (!Double.isFinite(newBalance)) {
            return false;
        }

        balance = newBalance;
        return true;
    }

    public boolean withdraw(double amount) {
        if (!Double.isFinite(amount) || amount <= 0 || amount > balance) {
            return false;
        }

        balance -= amount;
        return true;
    }
}