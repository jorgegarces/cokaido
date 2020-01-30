package Bloaters.DataClumps;

public class Address {

    public String house;

    public String street;

    public String city;

    public String postcode;

    public String country;

    public Address(String house, String street, String city, String postcode, String country) {
        this.house = house;
        this.street = street;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
    }

    public String GetAddressSummary()
    {
        return house + ", " + street + ", " + city + ", " + postcode + ", "
                + country;
    }

    public String getCountry() {
        return country;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }
}
