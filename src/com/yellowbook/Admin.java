package com.yellowbook;

public class Admin extends User {

    public Admin(String username, String password) {
        super(username, password);
    }

    public void removeProfile(PhoneBook phoneBook, Profile profile) {
        phoneBook.removeProfile(profile);
        System.out.println("Profil borttagen.");
    }

    public void updateProfile(PhoneBook phoneBook, Profile oldProfile, Profile newProfile) {
        phoneBook.updateProfile(oldProfile, newProfile);
        System.out.println("Profil uppdaterad.");
    }
}
