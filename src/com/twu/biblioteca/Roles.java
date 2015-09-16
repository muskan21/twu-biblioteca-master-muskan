package com.twu.biblioteca;

import java.util.ArrayList;

public class Roles {
    private Role role;
    private ArrayList<String> operations = new ArrayList<String>();

    public Roles(Role role, ArrayList<String> operations) {
        this.role = role;
        this.operations = operations;
    }

    public ArrayList<String> canPerformOperations() {
        return operations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Roles roles = (Roles) o;

        return role == roles.role && operations.equals(roles.operations);

    }

    @Override
    public int hashCode() {
        return role.hashCode() + operations.hashCode();
    }
}
