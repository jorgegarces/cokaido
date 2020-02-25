import app.Portfolio;
import formatter.PortfolioFormatter;
import operation.Buy;
import operation.Operation;
import operation.Sell;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import printable.Printable;
import repository.OperationRepository;
import timeserver.TimeServer;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PortfolioShould {

    @Mock
    private Printable printer;

    @Mock
    private OperationRepository repository;

    @Mock
    private TimeServer timeServer;

    @Mock
    private PortfolioFormatter formatter;

    @Test
    public void send_buy_operation_to_repository() {

        MockitoAnnotations.initMocks(this);
        Portfolio portfolio = new Portfolio(printer, repository, timeServer, formatter);

        portfolio.buy(1000, "Old School Waterfall Software LTD", 5.75);

        verify(repository).save(new Buy(1000, "Old School Waterfall Software LTD", 5.75, timeServer.getDate()));
    }

    @Test
    public void send_sell_operation_to_repository() {

        MockitoAnnotations.initMocks(this);
        Portfolio portfolio = new Portfolio(printer, repository, timeServer, formatter);

        portfolio.sell(500, "Old School Waterfall Software LTD", 5.75);

        verify(repository).save(new Sell(500, "Old School Waterfall Software LTD", 5.75, timeServer.getDate()));
    }

    @Test
    public void print_operations() {
        MockitoAnnotations.initMocks(this);
        Portfolio portfolio = new Portfolio(printer, repository, timeServer, formatter);
        List<Operation> operationsList = new ArrayList<>();
        operationsList.add(new Buy(1000, "Old School Waterfall Software LTD", 5.75, timeServer.getDate()));
        when(repository.getOperations()).thenReturn(operationsList);
        when(formatter.create(operationsList)).thenReturn(" foo ");

        portfolio.print();

        verify(printer).print(" foo ");
    }
}
