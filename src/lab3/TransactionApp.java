package lab3;

import lab3.model.*;
import lab3.service.TransactionPrinter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class TransactionApp {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        Transaction inc = new IncomeTransaction(UUID.randomUUID(), today, new BigDecimal("1000"));
        Transaction exp = new ExpenseTransaction(UUID.randomUUID(), today, new BigDecimal("500"), new BigDecimal("50"));
        Transaction tr = new TransferTransaction(UUID.randomUUID(), today, new BigDecimal("200"), "OUTGOING");

        Transaction[] myTransactions = { inc, exp, tr };

        TransactionPrinter printer = new TransactionPrinter();
        printer.print(myTransactions);

        System.out.println();

        UUID sharedId = UUID.randomUUID();
        Transaction t1 = new IncomeTransaction(sharedId, today, new BigDecimal("100"));
        Transaction t2 = new IncomeTransaction(sharedId, today, new BigDecimal("500"));

        System.out.println("t1.equals(t2): " + t1.equals(t2));
        System.out.println("Хэш-коды равны: " + (t1.hashCode() == t2.hashCode()));
    }
}
