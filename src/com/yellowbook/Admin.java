package com.yellowbook;

public class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }

    public boolean canAddProfile() {
        return true;
    }

    public boolean canUpdateProfile() {
        return true;
    }

    public boolean canDeleteProfile() {
        return true;
    }

    public boolean canSearchProfiles() {
        return true;
    }
}
