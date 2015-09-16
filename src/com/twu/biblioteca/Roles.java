package com.twu.biblioteca;

import java.util.ArrayList;

public class Roles {
    private Role role;
    private ArrayList<String> operations = new ArrayList<String>();

    public Roles(Role role) {
        this.role = role;
        if(role == Role.GUEST) {
            operations.add("1");
            operations.add("2");
            operations.add("3");
            operations.add("L");
            operations.add("Q");
        }
        else if(role == Role.CUSTOMER) {
            operations.add("1");
            operations.add("2");
            operations.add("3");
            operations.add("4");
            operations.add("5");
            operations.add("6");
            operations.add("L");
            operations.add("Q");
        }
        else if(role == Role.LIBRARIAN) {
            operations.add("1");
            operations.add("2");
            operations.add("3");
            operations.add("4");
            operations.add("5");
            operations.add("6");
            operations.add("7");
            operations.add("L");
            operations.add("Q");
        }
    }

    public ArrayList<String> canPerformOperations() {
        return operations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Roles roles = (Roles) o;

        return role == roles.role;

    }

    @Override
    public int hashCode() {
        return role.hashCode();
    }
}
