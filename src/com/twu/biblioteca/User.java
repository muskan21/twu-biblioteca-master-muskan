package com.twu.biblioteca;

public class User {
    private String libraryNumber;
    private String password;

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
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
}
