package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BibliotecaAdminTest {

    @Test
    public void shouldReturnGuestUserWhenLoginCredentialsDoNotMatch() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        operations.add("2");
        operations.add("3");
        operations.add("4");
        operations.add("L");
        operations.add("Q");
        User user1 = new User("111-1234", "password1", new Roles(Role.CUSTOMER, operations));
        ArrayList<String> operations1 = new ArrayList<String>();
        operations1.add("1");
        operations1.add("2");
        operations1.add("3");
        operations1.add("4");
        operations1.add("5");
        operations1.add("L");
        operations1.add("Q");
        User user2 = new User("012-3212", "password2", new Roles(Role.LIBRARIAN, operations1));
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users);

        User libraryNumber = bibliotecaAdmin.login("113-1234", "password3");
        ArrayList<String> operations2 = new ArrayList<String>();
        operations2.add("1");
        operations2.add("2");
        operations2.add("3");
        operations2.add("L");
        operations2.add("Q");
        User testUser = new User("113-1234", "password3", new Roles(Role.GUEST, operations2));

        assertEquals(testUser, libraryNumber);
    }

    @Test
    public void shouldReturnGuestUserWhoCanPerformGuestOperationsWhenLoginCredentialsDoNotMatch() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        operations.add("2");
        operations.add("3");
        operations.add("4");
        operations.add("L");
        operations.add("Q");
        User user1 = new User("111-1234", "password1", new Roles(Role.CUSTOMER, operations));
        ArrayList<String> operations1 = new ArrayList<String>();
        operations1.add("1");
        operations1.add("2");
        operations1.add("3");
        operations1.add("4");
        operations1.add("5");
        operations1.add("L");
        operations1.add("Q");
        User user2 = new User("012-3212", "password2", new Roles(Role.LIBRARIAN, operations1));
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users);

        User libraryNumber = bibliotecaAdmin.login("113-1234", "password3");
        ArrayList<String> operations2 = new ArrayList<String>();
        operations2.add("1");
        operations2.add("2");
        operations2.add("3");
        operations2.add("L");
        operations2.add("Q");
        User testUser = new User("113-1234", "password3", new Roles(Role.GUEST, operations2));

        assertEquals(testUser.canPerformOperations(), libraryNumber.canPerformOperations());
    }

    @Test
    public void shouldReturnLibrarianUserWhenLoginCredentialsOfLibrarianMatch() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        operations.add("2");
        operations.add("3");
        operations.add("4");
        operations.add("L");
        operations.add("Q");
        User user1 = new User("111-1234", "password1", new Roles(Role.CUSTOMER, operations));
        ArrayList<String> operations1 = new ArrayList<String>();
        operations1.add("1");
        operations1.add("2");
        operations1.add("3");
        operations1.add("4");
        operations1.add("5");
        operations1.add("L");
        operations1.add("Q");
        User user2 = new User("012-3212", "password2", new Roles(Role.LIBRARIAN, operations1));
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users);

        User libraryNumber = bibliotecaAdmin.login("012-3212", "password2");
        User testUser = new User("012-3212", "password2", new Roles(Role.LIBRARIAN, operations1));

        assertEquals(testUser, libraryNumber);
    }

    @Test
    public void shouldReturnLibrarianUserPerformingLibrarianOperationsWhenLoginCredentialsOfLibrarianMatch() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        operations.add("2");
        operations.add("3");
        operations.add("4");
        operations.add("L");
        operations.add("Q");
        User user1 = new User("111-1234", "password1", new Roles(Role.CUSTOMER, operations));
        ArrayList<String> operations1 = new ArrayList<String>();
        operations1.add("1");
        operations1.add("2");
        operations1.add("3");
        operations1.add("4");
        operations1.add("5");
        operations1.add("L");
        operations1.add("Q");
        User user2 = new User("012-3212", "password2", new Roles(Role.LIBRARIAN, operations1));
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users);

        User libraryNumber = bibliotecaAdmin.login("012-3212", "password2");
        User testUser = new User("012-3212", "password2", new Roles(Role.LIBRARIAN, operations1));

        assertEquals(testUser.canPerformOperations(), libraryNumber.canPerformOperations());
    }

    @Test
    public void shouldReturnCustomerUserWhenLoginCredentialsOfCustomerMatch() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        operations.add("2");
        operations.add("3");
        operations.add("4");
        operations.add("L");
        operations.add("Q");
        User user1 = new User("111-1234", "password1", new Roles(Role.CUSTOMER, operations));
        ArrayList<String> operations1 = new ArrayList<String>();
        operations1.add("1");
        operations1.add("2");
        operations1.add("3");
        operations1.add("4");
        operations1.add("5");
        operations1.add("L");
        operations1.add("Q");
        User user2 = new User("012-3212", "password2", new Roles(Role.LIBRARIAN, operations1));
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users);

        User libraryNumber = bibliotecaAdmin.login("111-1234", "password1");
        User testUser = new User("111-1234", "password1", new Roles(Role.CUSTOMER, operations));

        assertEquals(testUser, libraryNumber);
    }

    @Test
    public void shouldReturnCustomerUserPerformingCustomerOperationsWhenLoginCredentialsOfCustomerMatch() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        operations.add("2");
        operations.add("3");
        operations.add("4");
        operations.add("L");
        operations.add("Q");
        User user1 = new User("111-1234", "password1", new Roles(Role.CUSTOMER, operations));
        ArrayList<String> operations1 = new ArrayList<String>();
        operations1.add("1");
        operations1.add("2");
        operations1.add("3");
        operations1.add("4");
        operations1.add("5");
        operations1.add("L");
        operations1.add("Q");
        User user2 = new User("012-3212", "password2", new Roles(Role.LIBRARIAN, operations1));
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users);

        User libraryNumber = bibliotecaAdmin.login("111-1234", "password1");
        User testUser = new User("111-1234", "password1", new Roles(Role.CUSTOMER, operations));

        assertEquals(testUser.canPerformOperations(), libraryNumber.canPerformOperations());
    }

    @Test
    public void shouldReturnGuestUserWhenLibraryNumberOfLibrarianMatchesButPasswordDoesNot() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        operations.add("2");
        operations.add("3");
        operations.add("4");
        operations.add("L");
        operations.add("Q");
        User user1 = new User("111-1234", "password1", new Roles(Role.CUSTOMER, operations));
        ArrayList<String> operations1 = new ArrayList<String>();
        operations1.add("1");
        operations1.add("2");
        operations1.add("3");
        operations1.add("4");
        operations1.add("5");
        operations1.add("L");
        operations1.add("Q");
        User user2 = new User("012-3212", "password2", new Roles(Role.LIBRARIAN, operations1));
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users);

        User libraryNumber = bibliotecaAdmin.login("012-3212", "password3");
        ArrayList<String> operations2 = new ArrayList<String>();
        operations2.add("1");
        operations2.add("2");
        operations2.add("3");
        operations2.add("L");
        operations2.add("Q");
        User testUser = new User("012-3212", "password3", new Roles(Role.GUEST, operations2));

        assertEquals(testUser, libraryNumber);
    }

    @Test
    public void shouldReturnGuestUserPerformingGuestOperationsWhenLibraryNumberOfLibrarianMatchesButPasswordDoesNot() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        operations.add("2");
        operations.add("3");
        operations.add("4");
        operations.add("L");
        operations.add("Q");
        User user1 = new User("111-1234", "password1", new Roles(Role.CUSTOMER, operations));
        ArrayList<String> operations1 = new ArrayList<String>();
        operations1.add("1");
        operations1.add("2");
        operations1.add("3");
        operations1.add("4");
        operations1.add("5");
        operations1.add("L");
        operations1.add("Q");
        User user2 = new User("012-3212", "password2", new Roles(Role.LIBRARIAN, operations1));
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users);

        User libraryNumber = bibliotecaAdmin.login("012-3212", "password3");
        ArrayList<String> operations2 = new ArrayList<String>();
        operations2.add("1");
        operations2.add("2");
        operations2.add("3");
        operations2.add("L");
        operations2.add("Q");
        User testUser = new User("012-3212", "password3", new Roles(Role.GUEST, operations2));

        assertEquals(testUser.canPerformOperations(), libraryNumber.canPerformOperations());
    }
}
