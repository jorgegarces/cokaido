package app.repositories;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {
    private List<Transaction> transactions;

    public TransactionRepository() {
        this.transactions = new ArrayList<>();
    }

    public void save(Transaction transaction) {

        this.transactions.add(transaction);
    }

    public String getStatement() {
        StringBuilder statement = new StringBuilder("date       || credit   || debit    || balance\n");
        int currentBalance = 0;
        for (Transaction transaction : transactions) {
            currentBalance = transaction.calculateBalance(currentBalance);
            statement.append(transaction).append(currentBalance + ".00");
        }

        return statement.toString();
    }

}
