package Bloaters.LongParameterList;

public class Customer {
    private String firstName;
    private String lastName;
    private String title;
    private Address address;


    private String buildCustomerSummary(customerData customerData)
    {
        return customerData.getCustomerTitle() + " " + customerData.getCustomerFirstName() + " " + customerData.getCustomerLastName() + ", " + customerData.getCustomerCity() + ", "
                + customerData.getCustomerPostCode() + ", " + customerData.getCustomerCountry();
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Bloaters.LongParameterList.Address getAddress() {
        return address;
    }

    public void setAddress(Bloaters.LongParameterList.Address address) {
        this.address = address;
    }

    public String getSummary() {
        return buildCustomerSummary(
                new customerData(firstName, lastName, title, address.getCity(), address.getPostcode(), address.getCountry()));
    }
}
