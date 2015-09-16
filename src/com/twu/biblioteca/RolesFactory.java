package com.twu.biblioteca;

import java.util.ArrayList;

public class RolesFactory {
    private Roles roles;

    public Roles assignOperations(Role role) {
        ArrayList<String> operations = new ArrayList<String>();
        if(role == Role.GUEST)
            operations = assignGuestOperations();
        else if(role == Role.CUSTOMER)
            operations = assignCustomerOperations();
        else if(role == Role.LIBRARIAN)
            operations = assignLibrarianOperations();
        roles = new Roles(role, operations);
        return roles;
    }

    private ArrayList<String> assignLibrarianOperations() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        operations.add("2");
        operations.add("3");
        operations.add("4");
        operations.add("5");
        operations.add("6");
        operations.add("7");
        operations.add("0");
        operations.add("Q");
        return operations;
    }

    private ArrayList<String> assignCustomerOperations() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        operations.add("2");
        operations.add("3");
        operations.add("4");
        operations.add("5");
        operations.add("6");
        operations.add("0");
        operations.add("Q");
        return operations;
    }

    private ArrayList<String> assignGuestOperations() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        operations.add("2");
        operations.add("3");
        operations.add("L");
        operations.add("Q");
        return operations;
    }
}
