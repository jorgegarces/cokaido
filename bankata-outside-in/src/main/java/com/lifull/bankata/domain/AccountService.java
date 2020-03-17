package com.lifull.bankata.domain;

import com.lifull.bankata.domain.transaction.deposit.Deposit;
import com.lifull.bankata.domain.transaction.withdrawal.Withdrawal;
import com.lifull.bankata.infrastructure.TransactionRepository;
import com.lifull.bankata.services.TimeServer;
import org.springframework.stereotype.Component;

@Component
public class AccountService {

    private TransactionRepository repository;
    private TimeServer timeServer;

    public AccountService(TransactionRepository repository, TimeServer timeServer) {
        this.repository = repository;
        this.timeServer = timeServer;
    }

    public void deposit(int amount) {
        repository.save(new Deposit(amount, timeServer.getDate()));
    }

    public void withdraw(int amount) {
        repository.save(new Withdrawal(amount, timeServer.getDate()));
    }

    public String printStatement() {
        return repository.getStatement();
    }
}