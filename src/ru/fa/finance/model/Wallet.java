package ru.fa.finance.model;

import java.math.BigDecimal;

public class Wallet {
    private final String name;
    private final BigDecimal initialBalance;

    public Wallet(String name, BigDecimal initialBalance) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название кошелька не может быть пустым");
        }
        if (initialBalance == null || initialBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Начальный баланс не может быть отрицательным");
        }
        this.name = name;
        this.initialBalance = initialBalance;
    }

    public String getName() { return name; }
    public BigDecimal getInitialBalance() { return initialBalance; }
}
