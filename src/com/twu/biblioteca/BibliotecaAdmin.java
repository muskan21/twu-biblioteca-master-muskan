package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaAdmin {
    private ArrayList<User> users;
    private RolesFactory rolesFactory;

    public BibliotecaAdmin(ArrayList<User> users, RolesFactory rolesFactory) {
        this.users = users;
        this.rolesFactory = rolesFactory;
    }

    public User login(String libraryNumber, String password) {
        User user1 = new User(libraryNumber, password, rolesFactory.assignOperations(Role.GUEST));
        int index = users.indexOf(user1);
        if(index != -1)
            if(users.get(index).authenticatePassword(password))
                return users.get(index);
        return user1;
    }

    public User logout() {
        return new User("123-1234", "password", rolesFactory.assignOperations(Role.GUEST));
    }
}
