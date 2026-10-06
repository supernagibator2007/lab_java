package lab3.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public abstract class Transaction {
    private final UUID id;
    private final LocalDate date;
    private final BigDecimal amount;

    protected Transaction(UUID id, LocalDate date, BigDecimal amount) {
        if (id == null) {
            throw new IllegalArgumentException("ID не может быть null");
        }
        if (date == null) {
            throw new IllegalArgumentException("Дата не может быть null");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Сумма должна быть больше 0");
        }
        this.id = id;
        this.date = date;
        this.amount = amount;
    }

    public final UUID getId() {
        return id;
    }

    public final BigDecimal getAmount() {
        return amount;
    }

    public abstract BigDecimal balanceImpact();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Transaction other = (Transaction) obj;
        return this.id.equals(other.id);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [id=" + id + ", date=" + date + ", amount=" + amount + "]";
    }
}