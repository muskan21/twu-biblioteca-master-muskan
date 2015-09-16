package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaAdmin {
    private ArrayList<User> users;

    public BibliotecaAdmin(ArrayList<User> users) {
        this.users = users;
    }

    public User login(String libraryNumber, String password) {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        operations.add("2");
        operations.add("3");
        operations.add("L");
        operations.add("Q");
        User user1 = new User(libraryNumber, password, new Roles(Role.GUEST, operations));
        int index = users.indexOf(user1);
        if(index != -1)
            if(users.get(index).authenticatePassword(password))
                return users.get(index);
        return user1;
    }
}
