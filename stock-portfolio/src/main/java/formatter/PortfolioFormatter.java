package formatter;
import operation.Operation;
import java.util.List;

public interface PortfolioFormatter {

    String create(List<Operation> operationsList);
}
