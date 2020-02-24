package app;
import operation.Buy;
import operation.Operation;
import printable.Printable;
import timeserver.*;

import repository.OperationRepository;

public class Portfolio {
    private final Printable printer;
    private final OperationRepository repository;
    private final TimeServer timeServer;

    public Portfolio(Printable printer, OperationRepository repository, TimeServer timeServer) {
        this.printer = printer;
        this.repository = repository;
        this.timeServer = timeServer;
    }

    public void buy(int shareAmount, String companyName, double price) {
        this.repository.save(new Buy(shareAmount, companyName, price, timeServer.getDate() ));
    }

    public void sell(int shareAmount, String company, double sharePrice) {

    }

    public void print() {

    }

}
