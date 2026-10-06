package lab3.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class TransferTransaction extends Transaction {
    private final String direction;

    public TransferTransaction(UUID id, LocalDate date, BigDecimal amount, String direction) {
        super(id, date, amount);
        if (!direction.equals("INCOMING") && !direction.equals("OUTGOING")) {
            throw new IllegalArgumentException("Неверное направление перевода");
        }
        this.direction = direction;
    }

    @Override
    public BigDecimal balanceImpact() {
        if (direction.equals("INCOMING")) {
            return getAmount();
        } else {
            return getAmount().negate();
        }
    }
}
