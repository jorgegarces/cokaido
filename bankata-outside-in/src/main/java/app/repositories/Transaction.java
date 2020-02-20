package app.repositories;

import java.util.Objects;

public abstract class Transaction {
    private int amount;

    public Transaction(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return amount == that.amount;
    }

}
