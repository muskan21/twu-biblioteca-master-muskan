package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BibliotecaAdminTest {

    @Test
    public void shouldReturnGuestUserWhenLoginCredentialsDoNotMatch() {
        RolesFactory rolesFactory = new RolesFactory();
        User user1 = new User("111-1234", "password1", rolesFactory.assignOperations(Role.CUSTOMER));
        User user2 = new User("012-3212", "password2", rolesFactory.assignOperations(Role.LIBRARIAN));
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory);

        User libraryNumber = bibliotecaAdmin.login("113-1234", "password3");
        User testUser = new User("113-1234", "password3", rolesFactory.assignOperations(Role.GUEST));

        assertEquals(testUser, libraryNumber);
    }

    @Test
    public void shouldReturnGuestUserWhoCanPerformGuestOperationsWhenLoginCredentialsDoNotMatch() {
        RolesFactory rolesFactory = new RolesFactory();
        User user1 = new User("111-1234", "password1", rolesFactory.assignOperations(Role.CUSTOMER));
        User user2 = new User("012-3212", "password2", rolesFactory.assignOperations(Role.LIBRARIAN));
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory);

        User libraryNumber = bibliotecaAdmin.login("113-1234", "password3");
        User testUser = new User("113-1234", "password3", rolesFactory.assignOperations(Role.GUEST));

        assertEquals(testUser.canPerformOperations(), libraryNumber.canPerformOperations());
    }

    @Test
    public void shouldReturnLibrarianUserWhenLoginCredentialsOfLibrarianMatch() {
        RolesFactory rolesFactory = new RolesFactory();
        User user1 = new User("111-1234", "password1", rolesFactory.assignOperations(Role.CUSTOMER));
        User user2 = new User("012-3212", "password2", rolesFactory.assignOperations(Role.LIBRARIAN));
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory);

        User libraryNumber = bibliotecaAdmin.login("012-3212", "password2");
        User testUser = new User("012-3212", "password2", rolesFactory.assignOperations(Role.LIBRARIAN));

        assertEquals(testUser, libraryNumber);
    }

    @Test
    public void shouldReturnLibrarianUserPerformingLibrarianOperationsWhenLoginCredentialsOfLibrarianMatch() {
        RolesFactory rolesFactory = new RolesFactory();
        User user1 = new User("111-1234", "password1", rolesFactory.assignOperations(Role.CUSTOMER));
        User user2 = new User("012-3212", "password2", rolesFactory.assignOperations(Role.LIBRARIAN));
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory);

        User libraryNumber = bibliotecaAdmin.login("012-3212", "password2");
        User testUser = new User("012-3212", "password2", rolesFactory.assignOperations(Role.LIBRARIAN));

        assertEquals(testUser.canPerformOperations(), libraryNumber.canPerformOperations());
    }

    @Test
    public void shouldReturnCustomerUserWhenLoginCredentialsOfCustomerMatch() {
        RolesFactory rolesFactory = new RolesFactory();
        User user1 = new User("111-1234", "password1", rolesFactory.assignOperations(Role.CUSTOMER));
        User user2 = new User("012-3212", "password2", rolesFactory.assignOperations(Role.LIBRARIAN));
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory);

        User libraryNumber = bibliotecaAdmin.login("111-1234", "password1");
        User testUser = new User("111-1234", "password1", rolesFactory.assignOperations(Role.CUSTOMER));

        assertEquals(testUser, libraryNumber);
    }

    @Test
    public void shouldReturnCustomerUserPerformingCustomerOperationsWhenLoginCredentialsOfCustomerMatch() {
        RolesFactory rolesFactory = new RolesFactory();
        User user1 = new User("111-1234", "password1", rolesFactory.assignOperations(Role.CUSTOMER));
        User user2 = new User("012-3212", "password2", rolesFactory.assignOperations(Role.LIBRARIAN));
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory);

        User libraryNumber = bibliotecaAdmin.login("111-1234", "password1");
        User testUser = new User("111-1234", "password1", rolesFactory.assignOperations(Role.CUSTOMER));

        assertEquals(testUser.canPerformOperations(), libraryNumber.canPerformOperations());
    }

    @Test
    public void shouldReturnGuestUserWhenLibraryNumberOfLibrarianMatchesButPasswordDoesNot() {
        RolesFactory rolesFactory = new RolesFactory();
        User user1 = new User("111-1234", "password1", rolesFactory.assignOperations(Role.CUSTOMER));
        User user2 = new User("012-3212", "password2", rolesFactory.assignOperations(Role.LIBRARIAN));
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory);

        User libraryNumber = bibliotecaAdmin.login("012-3212", "password3");
        User testUser = new User("012-3212", "password3", rolesFactory.assignOperations(Role.GUEST));

        assertEquals(testUser, libraryNumber);
    }

    @Test
    public void shouldReturnGuestUserPerformingGuestOperationsWhenLibraryNumberOfLibrarianMatchesButPasswordDoesNot() {
        RolesFactory rolesFactory = new RolesFactory();
        User user1 = new User("111-1234", "password1", rolesFactory.assignOperations(Role.CUSTOMER));
        User user2 = new User("012-3212", "password2", rolesFactory.assignOperations(Role.LIBRARIAN));
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory);

        User libraryNumber = bibliotecaAdmin.login("012-3212", "password3");
        User testUser = new User("012-3212", "password3", rolesFactory.assignOperations(Role.GUEST));

        assertEquals(testUser.canPerformOperations(), libraryNumber.canPerformOperations());
    }
}
