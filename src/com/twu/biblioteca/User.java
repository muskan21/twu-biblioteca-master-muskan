/*Has all the details related to a specific user and is responsible for providing the formatted user details
and authenticate if a given password is the same as its own.
 */
package com.twu.biblioteca;

import java.util.ArrayList;

public class User {
    private String libraryNumber;
    private String username;
    private String email;
    private int contactNumber;
    private String password;
    private Roles role;

    public User(String libraryNumber, String password, Roles role, String username, String email, int contactNumber) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.role = role;
        this.username = username;
        this.email = email;
        this.contactNumber = contactNumber;
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

    public String userDetails() {
        String userDetail = String.format("%-30s ", libraryNumber);
        return userDetail;
    }

    public String formattedUserDetails() {
        String userDetails = String.format("%-30s %-30s %-30s %-30s\n\n%-30s %-30s %-30s %-30d\n", "Library Number", "User name", "Email", "Contact number", libraryNumber, username, email, contactNumber);
        return userDetails;
    }
}
