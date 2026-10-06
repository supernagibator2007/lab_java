package lab3.model;

import lab3.interfaces.Commissionable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class ExpenseTransaction extends Transaction implements Commissionable {
    private final BigDecimal fee;

    public ExpenseTransaction(UUID id, LocalDate date, BigDecimal amount, BigDecimal fee) {
        super(id, date, amount);
        if (fee == null || fee.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Комиссия не может быть отрицательной");
        }
        this.fee = fee;
    }

    @Override
    public BigDecimal balanceImpact() {
        return getAmount().add(fee).negate();
    }

    @Override
    public BigDecimal commission() {
        return fee;
    }
}
