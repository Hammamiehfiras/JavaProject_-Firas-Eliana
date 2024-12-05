package com.yellowbook;

public class Address {
    private String street;
    private String city;
    private String postalCode;
    private String apartment;

    public Address(String street, String city, String postalCode, String apartment) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.apartment = apartment;
    }

    public boolean contains(String searchTerm) {
        return street.contains(searchTerm) || city.contains(searchTerm) || postalCode.contains(searchTerm) || apartment.contains(searchTerm);
    }

    @Override
    public String toString() {
        return street + ", " + city + " " + postalCode + ", Lägenhet: " + apartment;
    }
}
