package com.twu.biblioteca;

import java.util.ArrayList;

public class User {
    private String libraryNumber;
    private String password;
    private Roles role;

    public User(String libraryNumber, String password, Roles role) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.role = role;
    }

    @Override
    public boolean equals(Object userObject) {
        if (this == userObject) return true;
        if (userObject == null || getClass() != userObject.getClass()) return false;

        User user = (User) userObject;

        return libraryNumber.equals(user.libraryNumber);
    }

    @Override
    public int hashCode() {
        return libraryNumber.hashCode();
    }

    public boolean authenticatePassword(String password) {
        if(password.equals(this.password))
            return true;
        else
            return false;
    }

    public ArrayList<String> canPerformOperations() {
        return role.canPerformOperations();
    }
}
