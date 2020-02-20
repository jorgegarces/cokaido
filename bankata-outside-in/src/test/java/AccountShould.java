import app.Account;
import app.printable.Printable;
import app.repositories.Deposit;
import app.repositories.TransactionRepository;
import app.repositories.Withdrawal;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class AccountShould {
    private Account account;
    @Mock
    private Printable printer;

    @Mock
    private TransactionRepository repository;

    @Test
    public void send_deposit_to_repository() {

        MockitoAnnotations.initMocks(this);
        account = new Account(repository, printer);
        account.deposit(1000);

        verify(repository).save(new Deposit(1000));
    }

    @Test
    public void send_withdrawal_to_repository() {

        MockitoAnnotations.initMocks(this);
        account = new Account(repository, printer);
        account.withdraw(500);

        verify(repository).save(new Withdrawal(500));
    }
}
