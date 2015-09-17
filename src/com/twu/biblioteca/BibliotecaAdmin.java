package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaAdmin {
    private ArrayList<User> users;
    private RolesFactory rolesFactory;
    private OutputConsole outputConsole;

    public BibliotecaAdmin(ArrayList<User> users, RolesFactory rolesFactory, OutputConsole outputConsole) {
        this.users = users;
        this.rolesFactory = rolesFactory;
        this.outputConsole = outputConsole;
    }

    public User login(String libraryNumber, String password) {
        User user1 = new User(libraryNumber, password, rolesFactory.assignOperations(Role.GUEST));
        int index = users.indexOf(user1);
        if(index != -1)
            if(users.get(index).authenticatePassword(password)) {
                outputConsole.display("Login Succesful.");
                return users.get(index);
            }
        outputConsole.display("Login Unsuccessful.");
        return user1;
    }

    public User logout() {
        outputConsole.display("Logout Successful.");
        return new User("123-1234", "password", rolesFactory.assignOperations(Role.GUEST));
    }
}
