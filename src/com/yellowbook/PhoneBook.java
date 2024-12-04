package com.yellowbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private List<Profile> profiles = new ArrayList<>();
    private static final String FILE_PATH = "profiles.dat";

    public PhoneBook() {
        loadProfiles();
    }

    public void addProfile(Profile profile) {
        // Kontrollera om en profil med samma efternamn och adress redan finns
        for (Profile existingProfile : profiles) {
            // Jämför både efternamn och adress utan att ta hänsyn till storleken på bokstäver eller mellanslag
            if (existingProfile.getLastName().trim().equalsIgnoreCase(profile.getLastName().trim()) &&
                    existingProfile.getAddress().trim().equalsIgnoreCase(profile.getAddress().trim())) {
                System.out.println("Profile already exists with the same last name and address.");
                return;  // Om dubbletten finns, avsluta metoden och lägg inte till profilen
            }
        }

        // Lägg till profilen om ingen dubblett finns
        this.profiles.add(profile);
        saveProfiles();
    }

    public void updateProfile(String lastName, Profile newProfile) {
        for (int i = 0; i < this.profiles.size(); i++) {
            if (this.profiles.get(i).getLastName().equalsIgnoreCase(lastName)) {
                this.profiles.set(i, newProfile);
                saveProfiles();
                return;
            }
        }
        System.out.println("Profile not found.");
    }

    public void deleteProfile(String lastName) {
        Profile profileToDelete = null;
        for (Profile profile : this.profiles) {
            if (profile.getLastName().equalsIgnoreCase(lastName)) {
                profileToDelete = profile;
                break;
            }
        }

        if (profileToDelete != null) {
            this.profiles.remove(profileToDelete);
            saveProfiles();
            System.out.println("Profile deleted.");
        } else {
            System.out.println("Profile not found.");
        }
    }

    public Profile getProfileByLastName(String lastName) {
        for (Profile profile : this.profiles) {
            if (profile.getLastName().equalsIgnoreCase(lastName)) {
                return profile;
            }
        }
        return null;
    }

    public Profile getProfileByAddress(String address) {
        for (Profile profile : this.profiles) {
            if (profile.getAddress().equalsIgnoreCase(address)) {
                return profile;
            }
        }
        return null;
    }

    public List<Profile> getProfiles() {
        return this.profiles;
    }

    // Load profiles from file
    private void loadProfiles() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            profiles = (List<Profile>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No profiles found, starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading profiles: " + e.getMessage());
        }
    }

    // Save profiles to file
    private void saveProfiles() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(profiles);
        } catch (IOException e) {
            System.out.println("Error saving profiles: " + e.getMessage());
        }
    }
}

