package ru.fa.finance.service;

import ru.fa.finance.model.Transaction;
import ru.fa.finance.model.TransactionType;
import ru.fa.finance.model.Wallet;
import java.math.BigDecimal;
import java.util.List;

public class TransactionCalculator {

    public static BigDecimal calculateBalance(Wallet wallet, List<Transaction> transactions) {
        BigDecimal balance = wallet.getInitialBalance();
        for (Transaction tx : transactions) {
            if (tx.getType() == TransactionType.INCOME) {
                balance = balance.add(tx.getAmount());
            } else if (tx.getType() == TransactionType.EXPENSE) {
                balance = balance.subtract(tx.getAmount());
            }
        }
        return balance;
    }
}
