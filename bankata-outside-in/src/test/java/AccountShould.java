import app.Account;
import app.printable.Printable;
import app.repositories.Deposit;
import app.repositories.TransactionRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class AccountShould {

    @Mock
    private Printable printer;

    @Mock
    private TransactionRepository repository;

    @Test
    public void send_deposit_to_repository() {
        MockitoAnnotations.initMocks(this);
        Account account = new Account(repository, printer);
        account.deposit(1000);

        verify(repository).save(new Deposit(1000));
    }

}
