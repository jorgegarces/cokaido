package com.lifull.bankata.domain;

import com.lifull.bankata.domain.transaction.deposit.Deposit;
import com.lifull.bankata.domain.transaction.withdrawal.Withdrawal;
import com.lifull.bankata.infrastructure.TransactionRepository;
import com.lifull.bankata.services.TimeServer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountServiceShould {

    @Mock
    private TransactionRepository repository;

    @Mock
    private TimeServer timeServer;

    @InjectMocks
    private AccountService accountService;

    @Test
    public void send_deposit_to_repository() {
        MockitoAnnotations.initMocks(this);

        accountService.deposit(1000);

        verify(repository).save(new Deposit(1000, timeServer.getDate()));
    }

    @Test
    public void send_withdrawal_to_repository() {

        MockitoAnnotations.initMocks(this);

        accountService.withdraw(500);

        verify(repository).save(new Withdrawal(500, timeServer.getDate()));
    }

    @Test
    public void get_statement_from_repository() {

        MockitoAnnotations.initMocks(this);
        accountService = new AccountService(repository, timeServer);

        when(repository.getStatement()).thenReturn("Amount");

        Assert.assertEquals("Amount", accountService.printStatement());
    }
}
