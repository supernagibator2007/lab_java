package ru.fa.finance.service;

import ru.fa.finance.model.Transaction;
import ru.fa.finance.model.TransactionType;

public class TransactionPrinter {

    public static void print(Transaction tx) {
        String icon = tx.getType() == TransactionType.INCOME ? "➕" : "➖";
        System.out.printf("[%s] ID: %d | %s %-7s | Категория: %-10s | Сумма: %,.2f руб.%n",
                tx.getDate(),
                tx.getId(),
                icon,
                tx.getType(),
                tx.getCategory().getName(),
                tx.getAmount()
        );
        if (!tx.getDescription().isEmpty()) {
            System.out.println("Описание: " + tx.getDescription());
        }
    }
}
