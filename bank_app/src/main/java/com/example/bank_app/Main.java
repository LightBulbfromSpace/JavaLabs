package com.example.bank_app;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount[] accounts = TestData.getAccounts();
        BankAccount selectedAccount = null;

        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                printMenu(selectedAccount);
                String command = readLine(scanner);
                if (command == null) {
                    break;
                }

                boolean waitForContinue = true;
                switch (command) {
                    case "1":
                        listAccounts(accounts, selectedAccount);
                        break;
                    case "2":
                        if (selectedAccount == null) {
                            BankAccount newSelection = selectAccount(scanner, accounts);
                            waitForContinue = false;
                            if (newSelection != null) {
                                selectedAccount = newSelection;
                            }
                        } else {
                            showAccountInfo(selectedAccount);
                        }
                        break;
                    case "3":
                        if (selectedAccount == null) {
                            System.out.println("Создано счетов: " + BankAccount.getAccountsCount());
                        } else {
                            deposit(scanner, selectedAccount);
                            waitForContinue = false;
                        }
                        break;
                    case "4":
                        if (selectedAccount == null) {
                            System.out.println("Неизвестная команда. Выберите пункт из меню.");
                            waitForContinue = false;
                        } else {
                            withdraw(scanner, selectedAccount);
                            waitForContinue = false;
                        }
                        break;
                    case "5":
                        if (selectedAccount == null) {
                            System.out.println("Неизвестная команда. Выберите пункт из меню.");
                            waitForContinue = false;
                        } else {
                            BankAccount newSelection = selectAccount(scanner, accounts);
                            waitForContinue = false;
                            if (newSelection != null) {
                                selectedAccount = newSelection;
                            }
                        }
                        break;
                    case "6":
                        if (selectedAccount == null) {
                            System.out.println("Неизвестная команда. Выберите пункт из меню.");
                            waitForContinue = false;
                        } else {
                            selectedAccount = null;
                            System.out.println("Выбор счёта отменён.");
                            waitForContinue = false;
                        }
                        break;
                    case "7":
                        if (selectedAccount == null) {
                            System.out.println("Неизвестная команда. Выберите пункт из меню.");
                            waitForContinue = false;
                        } else {
                            System.out.println("Создано счетов: " + BankAccount.getAccountsCount());
                        }
                        break;
                    case "0":
                        running = false;
                        System.out.println("Работа программы завершена.");
                        break;
                    default:
                        System.out.println("\nНеизвестная команда. Выберите пункт из меню.\n");
                        waitForContinue = false;
                }

                if (running && waitForContinue) {
                    System.out.print("\nНажмите Enter, чтобы вернуться в главное меню...");
                    if (!scanner.hasNextLine()) {
                        break;
                    }
                    scanner.nextLine();
                }
            }
        }
    }

    private static void printMenu(BankAccount selectedAccount) {
        System.out.println("\n=== Главное меню ===");
        if (selectedAccount == null) {
            System.out.println("Счёт не выбран. Выберите счёт из списка.");
            System.out.println("1. Список банковских счетов");
            System.out.println("2. Выбрать счёт");
            System.out.println("3. Количество созданных счетов");
            System.out.println("0. Завершить программу");
            System.out.print("Выбранный пункт: ");
            return;
        }

        System.out.printf("Выбран счёт %s (%s)%n",
                selectedAccount.getAccountNumber(), selectedAccount.getOwner());
        System.out.println("1. Список банковских счетов");
        System.out.println("2. Информация о выбранном счёте");
        System.out.println("3. Пополнить выбранный счёт");
        System.out.println("4. Снять денежные средства");
        System.out.println("5. Выбрать другой счёт");
        System.out.println("6. Выйти из выбранного счёта");
        System.out.println("7. Количество созданных счетов");
        System.out.println("0. Завершить программу");
        System.out.print("Выберите пункт: ");
    }

    private static void listAccounts(BankAccount[] accounts, BankAccount selectedAccount) {
        System.out.println("\nСписок банковских счетов:");
        for (int index = 0; index < accounts.length; index++) {
            BankAccount account = accounts[index];
            String marker = account == selectedAccount ? " (выбран)" : "";
            System.out.printf(Locale.ROOT, "%d. %s | %s | баланс: %.2f%s%n",
                    index + 1,
                    account.getAccountNumber(),
                    account.getOwner(),
                    account.getBalance(),
                    marker);
        }
    }

    private static void showAccountInfo(BankAccount account) {
        System.out.println("\nИнформация о счёте:");
        System.out.println("Владелец: " + account.getOwner());
        System.out.println("Номер счёта: " + account.getAccountNumber());
        System.out.printf(Locale.ROOT, "Текущий баланс: %.2f%n", account.getBalance());
    }

    private static void deposit(Scanner scanner, BankAccount account) {
        System.out.print("Введите сумму пополнения: ");
        Double amount = readAmount(scanner);
        if (amount == null) {
            return;
        }

        if (account.deposit(amount)) {
            System.out.printf(Locale.ROOT, "Счёт пополнен. Новый баланс: %.2f%n", account.getBalance());
        } else {
            System.out.println("Сумма пополнения должна быть конечным числом больше нуля.");
        }
    }

    private static void withdraw(Scanner scanner, BankAccount account) {
        System.out.print("Введите сумму снятия: ");
        Double amount = readAmount(scanner);
        if (amount == null) {
            return;
        }

        if (account.withdraw(amount)) {
            System.out.printf(Locale.ROOT, "Средства сняты. Новый баланс: %.2f%n", account.getBalance());
        } else {
            System.out.println("Сумма должна быть больше нуля и не превышать текущий баланс.");
        }
    }

    private static Double readAmount(Scanner scanner) {
        String input = readLine(scanner);
        if (input == null) {
            return null;
        }

        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException exception) {
            System.out.println("Некорректная сумма. Введите число, например 250.50.");
            return null;
        }
    }

    private static BankAccount selectAccount(Scanner scanner, BankAccount[] accounts) {
        listAccounts(accounts, null);
        System.out.print("Введите номер счёта или номер пункта из списка: ");
        String selection = readLine(scanner);
        if (selection == null) {
            return null;
        }

        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(selection)) {
                System.out.println("Выбран счёт " + account.getAccountNumber() + ".");
                return account;
            }
        }

        try {
            int menuIndex = Integer.parseInt(selection);
            if (menuIndex >= 1 && menuIndex <= accounts.length) {
                BankAccount account = accounts[menuIndex - 1];
                System.out.println("Выбран счёт " + account.getAccountNumber() + ".");
                return account;
            }
        } catch (NumberFormatException exception) {
            System.out.println("Такой номер счёта или пункт меню не найден.");
            return null;
        }

        System.out.println("Такой номер счёта или пункт меню не найден.");
        return null;
    }

    private static String readLine(Scanner scanner) {
        if (!scanner.hasNextLine()) {
            return null;
        }

        String input = scanner.nextLine().trim();
        if (!input.isEmpty() && input.charAt(0) == 0xFEFF) {
            input = input.substring(1).trim();
        }
        return input;
    }
}