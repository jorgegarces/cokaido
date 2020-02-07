package Bloaters.DataClumps;

public class Customer {

    private final Name name;
    private final Address address;

    public Customer(Name name, Address address)
    {
        this.name = name;
        this.address = address;
    }

    String getAddressSummary() {
        return address.getAddressSummary();
    }
}
