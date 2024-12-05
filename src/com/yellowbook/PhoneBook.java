package com.yellowbook;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

    private List<Profile> profiles;

    // Konstruktor
    public PhoneBook() {
        this.profiles = new ArrayList<>();
    }

    // Lägg till en profil
    public void addProfile(Profile profile) {
        profiles.add(profile);
    }

    // Ta bort en profil
    public void removeProfile(Profile profile) {
        profiles.remove(profile);
    }

    // Uppdatera en profil
    public void updateProfile(Profile oldProfile, Profile newProfile) {
        int index = profiles.indexOf(oldProfile);
        if (index != -1) {
            profiles.set(index, newProfile);
        }
    }

    // Sök profiler efter förnamn
    public void searchByFirstName(String firstName) {
        boolean found = false;
        for (Profile profile : profiles) {
            if (profile.getFirstName().equalsIgnoreCase(firstName)) {
                System.out.println(profile);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Inga profiler matchar förnamnet: " + firstName);
        }
    }

    // Sök profiler efter efternamn
    public void searchByLastName(String lastName) {
        boolean found = false;
        for (Profile profile : profiles) {
            if (profile.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println(profile);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Inga profiler matchar efternamnet: " + lastName);
        }
    }

    // Sök profiler efter adress
    public void searchByAddress(String street) {
        boolean found = false;
        for (Profile profile : profiles) {
            if (profile.getStreet().contains(street)) {
                System.out.println(profile);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Inga profiler matchar adressen: " + street);
        }
    }

    // Frisök på alla egenskaper
    public void searchByAnyProperty(String searchTerm) {
        boolean found = false;
        for (Profile profile : profiles) {
            if (profile.getFirstName().contains(searchTerm) || profile.getLastName().contains(searchTerm) ||
                    profile.getStreet().contains(searchTerm) || profile.getCity().contains(searchTerm)) {
                System.out.println(profile);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Inga profiler matchar söktermen: " + searchTerm);
        }
    }
    public void displayAllProfiles() {
        if (profiles.isEmpty()) {
            System.out.println("Inga profiler finns.");
        } else {
            System.out.println("Alla profiler:");
            for (Profile profile : profiles) {
                System.out.println(profile);
            }
        }
    }

    // Hämta alla profiler
    public List<Profile> getProfiles() {
        return profiles;
    }
}
