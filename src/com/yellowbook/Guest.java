package com.yellowbook;

public class Guest extends User {
    public Guest(String username, String password) {
        super(username, password);
    }

    public boolean canAddProfile() {
        return false;
    }

    public boolean canUpdateProfile() {
        return false;
    }

    public boolean canDeleteProfile() {
        return false;
    }

    public boolean canSearchProfiles() {
        return true;
    }
}
