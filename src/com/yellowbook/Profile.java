package com.yellowbook;

import java.io.Serializable;

public class Profile implements Serializable {
    private static final long serialVersionUID = 1L; // För att säkerställa kompatibilitet vid serialisering
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;

    public Profile(String firstName, String lastName, String address, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public String toString() {
        return String.format("Profile [First Name: %s, Last Name: %s, Address: %s, Phone: %s]",
                this.firstName, this.lastName, this.address, this.phoneNumber);
    }
}
