package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class BibliotecaAdminTest {

    @Test
    public void shouldReturnGuestUserWhenLoginCredentialsDoNotMatch() {
        RolesFactory rolesFactory = new RolesFactory();
        User user1 = new User("111-1234", "password1", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0);
        User user2 = new User("012-3212", "password2", rolesFactory.assignOperations(Role.LIBRARIAN), "", "", 0);
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        OutputConsole outputConsole = mock(OutputConsole.class);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory, outputConsole);

        User libraryNumber = bibliotecaAdmin.login("113-1234", "password3");
        User testUser = new User("113-1234", "password3", rolesFactory.assignOperations(Role.GUEST), "", "", 0);

        assertEquals(testUser, libraryNumber);
    }

    @Test
    public void shouldReturnGuestUserWhoCanPerformGuestOperationsWhenLoginCredentialsDoNotMatch() {
        RolesFactory rolesFactory = new RolesFactory();
        User user1 = new User("111-1234", "password1", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0);
        User user2 = new User("012-3212", "password2", rolesFactory.assignOperations(Role.LIBRARIAN), "", "", 0);
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        OutputConsole outputConsole = mock(OutputConsole.class);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory, outputConsole);

        User libraryNumber = bibliotecaAdmin.login("113-1234", "password3");
        User testUser = new User("113-1234", "password3", rolesFactory.assignOperations(Role.GUEST), "", "", 0);

        assertEquals(testUser.canPerformOperations(), libraryNumber.canPerformOperations());
    }

    @Test
    public void shouldPrintAppropriateMessageWhenLoginIsUnsuccessful() {
        RolesFactory rolesFactory = new RolesFactory();
        User user1 = new User("111-1234", "password1", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0);
        User user2 = new User("012-3212", "password2", rolesFactory.assignOperations(Role.LIBRARIAN), "", "", 0);
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputConsole outputConsole = new OutputConsole(new PrintStream(byteArrayOutputStream));
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory, outputConsole);

        bibliotecaAdmin.login("113-1234", "password3");

        assertEquals("Login Unsuccessful.\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldReturnLibrarianUserWhenLoginCredentialsOfLibrarianMatch() {
        RolesFactory rolesFactory = new RolesFactory();
        User user1 = new User("111-1234", "password1", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0);
        User user2 = new User("012-3212", "password2", rolesFactory.assignOperations(Role.LIBRARIAN), "", "", 0);
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        OutputConsole outputConsole = mock(OutputConsole.class);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory, outputConsole);

        User libraryNumber = bibliotecaAdmin.login("012-3212", "password2");
        User testUser = new User("012-3212", "password2", rolesFactory.assignOperations(Role.LIBRARIAN), "", "", 0);

        assertEquals(testUser, libraryNumber);
    }

    @Test
    public void shouldPrintAppropriateMessageWhenLoginIsSuccessful() {
        RolesFactory rolesFactory = new RolesFactory();
        User user1 = new User("111-1234", "password1", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0);
        User user2 = new User("012-3212", "password2", rolesFactory.assignOperations(Role.LIBRARIAN), "", "", 0);
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputConsole outputConsole = new OutputConsole(new PrintStream(byteArrayOutputStream));
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory, outputConsole);

        bibliotecaAdmin.login("012-3212", "password2");

        assertEquals("Login Succesful.\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldReturnLibrarianUserPerformingLibrarianOperationsWhenLoginCredentialsOfLibrarianMatch() {
        RolesFactory rolesFactory = new RolesFactory();
        User user1 = new User("111-1234", "password1", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0);
        User user2 = new User("012-3212", "password2", rolesFactory.assignOperations(Role.LIBRARIAN), "", "", 0);
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        OutputConsole outputConsole = mock(OutputConsole.class);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory, outputConsole);

        User libraryNumber = bibliotecaAdmin.login("012-3212", "password2");
        User testUser = new User("012-3212", "password2", rolesFactory.assignOperations(Role.LIBRARIAN), "", "", 0);

        assertEquals(testUser.canPerformOperations(), libraryNumber.canPerformOperations());
    }

    @Test
    public void shouldReturnCustomerUserWhenLoginCredentialsOfCustomerMatch() {
        RolesFactory rolesFactory = new RolesFactory();
        User user1 = new User("111-1234", "password1", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0);
        User user2 = new User("012-3212", "password2", rolesFactory.assignOperations(Role.LIBRARIAN), "", "", 0);
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        OutputConsole outputConsole = mock(OutputConsole.class);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory, outputConsole);

        User libraryNumber = bibliotecaAdmin.login("111-1234", "password1");
        User testUser = new User("111-1234", "password1", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0);

        assertEquals(testUser, libraryNumber);
    }

    @Test
    public void shouldReturnCustomerUserPerformingCustomerOperationsWhenLoginCredentialsOfCustomerMatch() {
        RolesFactory rolesFactory = new RolesFactory();
        User user1 = new User("111-1234", "password1", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0);
        User user2 = new User("012-3212", "password2", rolesFactory.assignOperations(Role.LIBRARIAN), "", "", 0);
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        OutputConsole outputConsole = mock(OutputConsole.class);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory, outputConsole);

        User libraryNumber = bibliotecaAdmin.login("111-1234", "password1");
        User testUser = new User("111-1234", "password1", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0);

        assertEquals(testUser.canPerformOperations(), libraryNumber.canPerformOperations());
    }

    @Test
    public void shouldReturnGuestUserWhenLibraryNumberOfLibrarianMatchesButPasswordDoesNot() {
        RolesFactory rolesFactory = new RolesFactory();
        User user1 = new User("111-1234", "password1", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0);
        User user2 = new User("012-3212", "password2", rolesFactory.assignOperations(Role.LIBRARIAN), "", "", 0);
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        OutputConsole outputConsole = mock(OutputConsole.class);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory, outputConsole);

        User libraryNumber = bibliotecaAdmin.login("012-3212", "password3");
        User testUser = new User("012-3212", "password3", rolesFactory.assignOperations(Role.GUEST), "", "", 0);

        assertEquals(testUser, libraryNumber);
    }

    @Test
    public void shouldReturnGuestUserPerformingGuestOperationsWhenLibraryNumberOfLibrarianMatchesButPasswordDoesNot() {
        RolesFactory rolesFactory = new RolesFactory();
        User user1 = new User("111-1234", "password1", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0);
        User user2 = new User("012-3212", "password2", rolesFactory.assignOperations(Role.LIBRARIAN), "", "", 0);
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        OutputConsole outputConsole = mock(OutputConsole.class);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory, outputConsole);

        User libraryNumber = bibliotecaAdmin.login("012-3212", "password3");
        User testUser = new User("012-3212", "password3", rolesFactory.assignOperations(Role.GUEST), "", "", 0);

        assertEquals(testUser.canPerformOperations(), libraryNumber.canPerformOperations());
    }

    @Test
    public void shouldReturnGuestUserOnLogout() {
        RolesFactory rolesFactory = new RolesFactory();
        User user1 = new User("111-1234", "password1", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0);
        User user2 = new User("012-3212", "password2", rolesFactory.assignOperations(Role.LIBRARIAN), "", "", 0);
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        OutputConsole outputConsole = mock(OutputConsole.class);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory, outputConsole);

        User libraryNumber = bibliotecaAdmin.logout();
        User testUser = new User("123-1234", "password", rolesFactory.assignOperations(Role.GUEST), "", "", 0);

        assertEquals(testUser.canPerformOperations(), libraryNumber.canPerformOperations());
    }

    @Test
    public void shouldPrintAppropriateLogoutMessageOnLogout() {
        RolesFactory rolesFactory = new RolesFactory();
        User user1 = new User("111-1234", "password1", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0);
        User user2 = new User("012-3212", "password2", rolesFactory.assignOperations(Role.LIBRARIAN), "", "", 0);
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputConsole outputConsole = new OutputConsole(new PrintStream(byteArrayOutputStream));
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory, outputConsole);

        bibliotecaAdmin.logout();

        assertEquals("Logout Successful.\n", byteArrayOutputStream.toString());
    }
}
