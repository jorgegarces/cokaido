import app.Portfolio;
import operation.Buy;
import operation.Sell;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import printable.Printable;
import repository.OperationRepository;
import timeserver.TimeServer;

import static org.mockito.Mockito.verify;

public class PortfolioShould {

    @Mock
    private Printable printer;

    @Mock
    private OperationRepository repository;

    @Mock
    private TimeServer timeServer;

    @Test
    public void send_buy_operation_to_repository() {

        MockitoAnnotations.initMocks(this);
        Portfolio portfolio = new Portfolio(printer, repository, timeServer);

        portfolio.buy(1000, "Old School Waterfall Software LTD", 5.75);

        verify(repository).save(new Buy(1000, "Old School Waterfall Software LTD", 5.75, timeServer.getDate()));
    }

    @Test
    public void send_sell_operation_to_repository() {

        MockitoAnnotations.initMocks(this);
        Portfolio portfolio = new Portfolio(printer, repository, timeServer);

        portfolio.sell(500, "Old School Waterfall Software LTD", 5.75);

        verify(repository).save(new Sell(500, "Old School Waterfall Software LTD", 5.75, timeServer.getDate()));
    }
}
