package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaAdmin {
    private ArrayList<User> users;

    public BibliotecaAdmin(ArrayList<User> users) {
        this.users = users;
    }

    public String login(String libraryNumber, String password) {
        int index = users.indexOf(new User(libraryNumber, password));
        if(index != -1)
            if(users.get(index).authenticatePassword(password))
                return libraryNumber;
        return "Guest User";
    }
}
