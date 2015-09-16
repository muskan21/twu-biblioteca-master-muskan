package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BibliotecaAdminTest {

    @Test
    public void shouldReturnGuestUserWhenLoginCredentialsDoNotMatch() {
        User user1 = new User("111-1234", "password1", new Roles(Role.CUSTOMER));
        User user2 = new User("012-3212", "password2", new Roles(Role.LIBRARIAN));
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users);

        User libraryNumber = bibliotecaAdmin.login("113-1234", "password3");
        User testUser = new User("113-1234", "password3", new Roles(Role.GUEST));

        assertEquals(testUser, libraryNumber);
    }

    @Test
    public void shouldReturnGuestUserWhoCanPerformGuestOperationsWhenLoginCredentialsDoNotMatch() {
        User user1 = new User("111-1234", "password1", new Roles(Role.CUSTOMER));
        User user2 = new User("012-3212", "password2", new Roles(Role.LIBRARIAN));
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users);

        User libraryNumber = bibliotecaAdmin.login("113-1234", "password3");
        User testUser = new User("113-1234", "password3", new Roles(Role.GUEST));

        assertEquals(testUser.canPerformOperations(), libraryNumber.canPerformOperations());
    }

    @Test
    public void shouldReturnLibrarianUserWhenLoginCredentialsOfLibrarianMatch() {
        User user1 = new User("111-1234", "password1", new Roles(Role.CUSTOMER));
        User user2 = new User("012-3212", "password2", new Roles(Role.LIBRARIAN));
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users);

        User libraryNumber = bibliotecaAdmin.login("012-3212", "password2");
        User testUser = new User("012-3212", "password2", new Roles(Role.LIBRARIAN));

        assertEquals(testUser, libraryNumber);
    }

    @Test
    public void shouldReturnLibrarianUserPerformingLibrarianOperationsWhenLoginCredentialsOfLibrarianMatch() {
        User user1 = new User("111-1234", "password1", new Roles(Role.CUSTOMER));
        User user2 = new User("012-3212", "password2", new Roles(Role.LIBRARIAN));
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users);

        User libraryNumber = bibliotecaAdmin.login("012-3212", "password2");
        User testUser = new User("012-3212", "password2", new Roles(Role.LIBRARIAN));

        assertEquals(testUser.canPerformOperations(), libraryNumber.canPerformOperations());
    }

    @Test
    public void shouldReturnCustomerUserWhenLoginCredentialsOfCustomerMatch() {
        User user1 = new User("111-1234", "password1", new Roles(Role.CUSTOMER));
        User user2 = new User("012-3212", "password2", new Roles(Role.LIBRARIAN));
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users);

        User libraryNumber = bibliotecaAdmin.login("111-1234", "password1");
        User testUser = new User("111-1234", "password1", new Roles(Role.CUSTOMER));

        assertEquals(testUser, libraryNumber);
    }

    @Test
    public void shouldReturnCustomerUserPerformingCustomerOperationsWhenLoginCredentialsOfCustomerMatch() {
        User user1 = new User("111-1234", "password1", new Roles(Role.CUSTOMER));
        User user2 = new User("012-3212", "password2", new Roles(Role.LIBRARIAN));
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users);

        User libraryNumber = bibliotecaAdmin.login("111-1234", "password1");
        User testUser = new User("111-1234", "password1", new Roles(Role.CUSTOMER));

        assertEquals(testUser.canPerformOperations(), libraryNumber.canPerformOperations());
    }

    @Test
    public void shouldReturnGuestUserWhenLibraryNumberOfLibrarianMatchesButPasswordDoesNot() {
        User user1 = new User("111-1234", "password1", new Roles(Role.CUSTOMER));
        User user2 = new User("012-3212", "password2", new Roles(Role.LIBRARIAN));
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users);

        User libraryNumber = bibliotecaAdmin.login("012-3212", "password3");
        User testUser = new User("012-3212", "password3", new Roles(Role.GUEST));

        assertEquals(testUser, libraryNumber);
    }

    @Test
    public void shouldReturnGuestUserPerformingGuestOperationsWhenLibraryNumberOfLibrarianMatchesButPasswordDoesNot() {
        User user1 = new User("111-1234", "password1", new Roles(Role.CUSTOMER));
        User user2 = new User("012-3212", "password2", new Roles(Role.LIBRARIAN));
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users);

        User libraryNumber = bibliotecaAdmin.login("012-3212", "password3");
        User testUser = new User("012-3212", "password3", new Roles(Role.GUEST));

        assertEquals(testUser.canPerformOperations(), libraryNumber.canPerformOperations());
    }
}
