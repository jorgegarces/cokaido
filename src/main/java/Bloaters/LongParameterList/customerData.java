package Bloaters.LongParameterList;

public class customerData {
    private final String customerFirstName;
    private final String customerLastName;
    private final String customerTitle;
    private final String customerCity;
    private final String customerPostCode;
    private final String customerCountry;

    public customerData(String customerFirstName, String customerLastName, String customerTitle, String customerCity, String customerPostCode, String customerCountry) {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerTitle = customerTitle;
        this.customerCity = customerCity;
        this.customerPostCode = customerPostCode;
        this.customerCountry = customerCountry;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public String getCustomerTitle() {
        return customerTitle;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public String getCustomerPostCode() {
        return customerPostCode;
    }

    public String getCustomerCountry() {
        return customerCountry;
    }
}
