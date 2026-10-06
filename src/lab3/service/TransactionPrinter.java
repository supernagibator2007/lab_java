package lab3.service;

import lab3.interfaces.Commissionable;
import lab3.model.Transaction;
import java.math.BigDecimal;

public class TransactionPrinter {

    // Overloading 1
    public void print(Transaction transaction) {
        System.out.println(transaction.toString());
        System.out.println("Изменение баланса: " + transaction.balanceImpact());

        if (transaction instanceof Commissionable) {
            Commissionable c = (Commissionable) transaction;
            System.out.println("Комиссия: " + c.commission());
        }
    }

    // Overloading 2
    public void print(Transaction[] transactions) {
        System.out.println("Список транзакций");
        BigDecimal total = BigDecimal.ZERO;

        // Позднее связывание (Overriding) работает прямо тут
        for (int i = 0; i < transactions.length; i++) {
            Transaction t = transactions[i];
            print(t);
            total = total.add(t.balanceImpact());
            System.out.println("-");
        }

        System.out.println("Итоговый баланс: " + total);
    }
}
