package Couplers.MessageChains;

public class Customer {
    private Address address;

    public Customer(Address address)
    {
        this.address = address;
    }

    boolean isInEurope() {
        return address.isInEurope();
    }
}
