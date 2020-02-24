package app.repositories;

public class Deposit extends Transaction {

    public Deposit(int amount, String date) {
        super(amount, date);
    }

    @Override
    public String toString() {
        return this.date + " || " + this.amount + ".00  ||          || ";
    }
}