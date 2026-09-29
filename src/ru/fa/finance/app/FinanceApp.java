package ru.fa.finance.app;

import ru.fa.finance.model.*;
import ru.fa.finance.service.TransactionCalculator;
import ru.fa.finance.service.TransactionPrinter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FinanceApp {
    public static void main(String[] args) {
        Wallet primaryWallet = new Wallet("Основной счет дебет", new BigDecimal("15000.00"));
        Wallet savingsWallet = new Wallet("Накопительный счет", new BigDecimal("100000.00"));

        Category salary = new Category(1, "Зарплата");
        Category food = new Category(2, "Продукты");
        Category transport = new Category(3, "Транспорт");

        List<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction(1, new BigDecimal("45000.00"), LocalDate.now(), TransactionType.INCOME, salary, "Основной оклад"));
        transactions.add(new Transaction(2, new BigDecimal("1200.00"), LocalDate.now(), TransactionType.EXPENSE, food)); // Конструктор без описания
        transactions.add(new Transaction(3, new BigDecimal("350.00"), LocalDate.now().minusDays(1), TransactionType.EXPENSE, transport, "Поездки на такси"));
        transactions.add(new Transaction(4, new BigDecimal("2300.00"), LocalDate.now().minusDays(1), TransactionType.EXPENSE, food, "Супермаркет"));
        transactions.add(new Transaction(5, new BigDecimal("7000.00"), LocalDate.now().minusDays(2), TransactionType.INCOME, salary, "Фриланс"));

        for (Transaction tx : transactions) {
            TransactionPrinter.print(tx);
        }

        BigDecimal finalBalance = TransactionCalculator.calculateBalance(primaryWallet, transactions);
        System.out.println("Итоговый баланс кошелька '" + primaryWallet.getName() + "': " + finalBalance + " руб.");

        try {
            // Попытка создать транзакцию с нулевой/отрицательной суммой
            new Transaction(6, new BigDecimal("-100.00"), LocalDate.now(), TransactionType.EXPENSE, food);
        } catch (IllegalArgumentException e) {
            System.out.println("Перехвачено исключение бизнес-валидации: " + e.getMessage());
        }
    }
}
