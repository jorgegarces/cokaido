package app.repositories;

public class Withdrawal extends Transaction {

    public Withdrawal(int amount, String date) {
        super(amount, date);
    }

    @Override
    public int calculateBalance(int currentBalance) {
        return 0;
    }


    @Override
    public String toString() {
         return this.date + " ||          || " + this.amount + ".00   || ";
    }

}
