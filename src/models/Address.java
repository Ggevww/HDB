package models;

/**
 * Address class represents a physical address with country, region, city, street, and house details.
 */
public class Address {
    private String Country;
    private String region;
    private String city;
    private String street;
    private String house;

    /**
     * Constructs an Address object with the specified details.
     *
     * @param country the country of the address
     * @param region  the region of the address
     * @param city    the city of the address
     * @param street  the street of the address
     * @param house   the house number or name of the address
     */
    public Address(String country, String region, String city, String street, String house) {
        this.Country = country;
        this.region = region;
        this.city = city;
        this.street = street;
        this.house = house;
    }
    /** Getters and Setters */

    public String getCountry() {
        return Country;
    }
    public void setCountry(String country) {
        Country = country;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getHouse() {
        return house;
    }
    public void setHouse(String house) {
        this.house = house;
    }
    @Override
    public String toString() {
        return "Address: " +
                "Country='" + Country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'';
    }
}
