package ru.fa.finance.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {
    private final long id;
    private final BigDecimal amount;
    private final LocalDate date;
    private final TransactionType type;
    private final Category category;
    private String description;

    public Transaction(long id, BigDecimal amount, LocalDate date, TransactionType type, Category category) {
        this(id, amount, date, type, category, "");
    }

    public Transaction(long id, BigDecimal amount, LocalDate date, TransactionType type, Category category, String description) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Сумма транзакции должна быть строго больше 0");
        }
        if (date == null) {
            throw new IllegalArgumentException("Дата транзакции не может быть null");
        }
        if (type == null) {
            throw new IllegalArgumentException("Тип транзакции не может быть null");
        }
        if (category == null) {
            throw new IllegalArgumentException("Категория не может быть null");
        }
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.type = type;
        this.category = category;
        changeDescription(description);
    }

    public void changeDescription(String newDescription) {
        if (newDescription == null) {
            throw new IllegalArgumentException("Описание не может быть null");
        }
        this.description = newDescription.strip();
    }

    public long getId() { return id; }
    public BigDecimal getAmount() { return amount; }
    public LocalDate getDate() { return date; }
    public TransactionType getType() { return type; }
    public Category getCategory() { return category; }
    public String getDescription() { return description; }
}
