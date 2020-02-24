import app.repositories.Deposit;
import app.repositories.Transaction;
import app.repositories.TransactionRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransactionRepositoryShould {
    @Mock
    private Transaction transaction;

    @Test
    public void return_empty_statement() {
        TransactionRepository transactionRepository = new TransactionRepository();

        Assert.assertEquals("date       || credit   || debit    || balance\n", transactionRepository.getStatement());
    }

    @Test
    public void return_statement_with_a_deposit_of_1000() {
        MockitoAnnotations.initMocks(this);
        TransactionRepository transactionRepository = new TransactionRepository();

        when(transaction.toString()).thenReturn("10/01/2012 || 1000.00  ||          || ");
        when(transaction.calculateBalance(0)).thenReturn(1000);
        transactionRepository.save(transaction);

        Assert.assertEquals("date       || credit   || debit    || balance\n10/01/2012 || 1000.00  ||          || 1000.00", transactionRepository.getStatement());
    }


}
