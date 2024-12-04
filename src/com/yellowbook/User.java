package com.yellowbook;

public abstract class User {
    protected String username;
    protected String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public abstract boolean canAddProfile();

    public abstract boolean canUpdateProfile();

    public abstract boolean canDeleteProfile();

    public abstract boolean canSearchProfiles();
}
