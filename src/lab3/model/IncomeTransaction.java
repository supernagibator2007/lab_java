package lab3.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class IncomeTransaction extends Transaction {

    public IncomeTransaction(UUID id, LocalDate date, BigDecimal amount) {
        super(id, date, amount);
    }

    @Override
    public BigDecimal balanceImpact() {
        return getAmount();
    }
}
