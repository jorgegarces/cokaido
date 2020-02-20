import app.repositories.TransactionRepository;
import org.junit.Assert;
import org.junit.Test;

public class TransactionRepositoryShould {

    @Test
    public void return_empty_statement(){
        TransactionRepository transactionRepository = new TransactionRepository();

        Assert.assertEquals("date       || credit   || debit    || balance\n", transactionRepository.getStatement());
    }


}
