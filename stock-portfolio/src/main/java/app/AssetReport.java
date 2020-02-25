package app;

public class AssetReport {
    private final String companyName;
    private final String shares;
    private final String currentPrice;
    private final String currentValue;
    private final String lastOperation;

    public AssetReport(String companyName, String shares, String currentPrice, String currentValue, String lastOperation
    ) {
        this.companyName = companyName;
        this.shares = shares;
        this.currentPrice = currentPrice;
        this.currentValue = currentValue;
        this.lastOperation = lastOperation;
    }
}
