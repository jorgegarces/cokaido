package com.lifull.bankata.infrastructure;

import com.lifull.bankata.domain.transaction.Transaction;
import com.lifull.bankata.infrastructure.inmemory.InMemoryTransactionRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InMemoryTransactionRepositoryShould {
    @Mock
    private Transaction transaction;

    @Mock
    private Transaction newTransaction;

    @Test
    public void return_empty_statement() {
        TransactionRepository inMemoryTransactionRepository = new InMemoryTransactionRepository();

        Assert.assertEquals("date       || credit   || debit    || balance\n", inMemoryTransactionRepository.getStatement());
    }

    @Test
    public void return_statement_with_a_deposit_of_1000() {
        MockitoAnnotations.initMocks(this);
        TransactionRepository inMemoryTransactionRepository = new InMemoryTransactionRepository();

        when(transaction.toString()).thenReturn("10/01/2012 || 1000.00  ||          || ");
        when(transaction.calculateBalance(0)).thenReturn(1000);
        inMemoryTransactionRepository.save(transaction);

        Assert.assertEquals("date       || credit   || debit    || balance\n10/01/2012 || 1000.00  ||          || 1000.00\n", inMemoryTransactionRepository.getStatement());
    }
    @Test
    public void sort_transactions_by_date() {
        MockitoAnnotations.initMocks(this);
        TransactionRepository inMemoryTransactionRepository = new InMemoryTransactionRepository();

        when(transaction.toString()).thenReturn("10/01/2012 || 1000.00  ||          || ");
        when(newTransaction.toString()).thenReturn("13/01/2012 || 2000.00  ||          || ");

        when(transaction.calculateBalance(0)).thenReturn(1000);
        when(newTransaction.calculateBalance(1000)).thenReturn(3000);

        inMemoryTransactionRepository.save(transaction);
        inMemoryTransactionRepository.save(newTransaction);

        Assert.assertEquals("date       || credit   || debit    || balance\n13/01/2012 || 2000.00  ||          || 3000.00\n10/01/2012 || 1000.00  ||          || 1000.00\n", inMemoryTransactionRepository.getStatement());
    }
}
