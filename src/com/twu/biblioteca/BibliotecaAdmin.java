package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaAdmin {
    private ArrayList<User> users;

    public BibliotecaAdmin(ArrayList<User> users) {
        this.users = users;
    }

    public String login(String libraryNumber, String password) {
        if(users.contains(new User(libraryNumber, password)))
            return libraryNumber;
        return "Guest User";
    }
}
