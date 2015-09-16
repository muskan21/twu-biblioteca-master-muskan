package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RolesFactoryTest {

    @Test
    public void shouldReturnTheSetOfCorrectRolesForAGuestUser() {
        RolesFactory rolesFactory = new RolesFactory();
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        operations.add("2");
        operations.add("3");
        operations.add("L");
        operations.add("Q");
        Roles roles = new Roles(Role.GUEST, operations);

        Roles role = rolesFactory.assignOperations(Role.GUEST);

        assertEquals(roles, role);
    }

    @Test
    public void shouldReturnTheSetOfCorrectRolesForACustomer() {
        RolesFactory rolesFactory = new RolesFactory();
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        operations.add("2");
        operations.add("3");
        operations.add("4");
        operations.add("5");
        operations.add("6");
        operations.add("L");
        operations.add("Q");
        Roles roles = new Roles(Role.CUSTOMER, operations);

        Roles role = rolesFactory.assignOperations(Role.CUSTOMER);

        assertEquals(roles, role);
    }

    @Test
    public void shouldReturnTheSetOfCorrectRolesForALibrarian() {
        RolesFactory rolesFactory = new RolesFactory();
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        operations.add("2");
        operations.add("3");
        operations.add("4");
        operations.add("5");
        operations.add("6");
        operations.add("7");
        operations.add("L");
        operations.add("Q");
        Roles roles = new Roles(Role.LIBRARIAN, operations);

        Roles role = rolesFactory.assignOperations(Role.LIBRARIAN);

        assertEquals(roles, role);
    }
}
