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

        for (Transaction transaction : transactions) statement.append(transaction);

        return statement.toString();
    }

}
