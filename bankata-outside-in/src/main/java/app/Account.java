package app;

import app.printable.Printable;
import app.repositories.Deposit;
import app.repositories.Transaction;
import app.repositories.TransactionRepository;

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
    }

    public void printStatement() {
    }
}

