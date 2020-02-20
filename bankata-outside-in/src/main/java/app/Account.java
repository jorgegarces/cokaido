package app;

import app.printable.Printable;
import app.repositories.Deposit;
import app.repositories.Transaction;
import app.repositories.TransactionRepository;
import app.repositories.Withdrawal;

public class Account {

    private final TransactionRepository repository;
    private final Printable printer;

    public Account(TransactionRepository repository, Printable printer) {
        this.repository = repository;
        this.printer = printer;
    }

    public void deposit(int amount) {
        repository.save(new Deposit(amount));
    }

    public void withdraw(int amount) {
        repository.save(new Withdrawal(amount));
    }

    public void printStatement() {
        printer.print(repository.getStatement());
    }
}

