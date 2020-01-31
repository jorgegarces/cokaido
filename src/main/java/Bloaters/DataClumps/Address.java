package Bloaters.DataClumps;

public class Address {

    public String house;

    public String street;

    public String city;

    public String postCode;

    public String country;

    public Address(String house, String street, String city, String postCode, String country) {
        this.house = house;
        this.street = street;
        this.city = city;
        this.postCode = postCode;
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public String getPostCode() {
        return postCode;
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

    public String getAddressSummary() {
        return house + ", " + street + ", " + city + ", " + postCode + ", " + country;
    }
}
