package Couplers.MessageChains;

public class Address {
    private Country country;

    public Address(Country country)
    {
        this.country = country;
    }

    boolean isInEurope() {
        return country.isInEurope();
    }
}
