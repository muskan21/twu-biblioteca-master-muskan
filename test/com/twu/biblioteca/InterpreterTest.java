package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class InterpreterTest {
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldExitIfExitOptionIsChosen() {
        ArrayList<String> operation = new ArrayList<String>();
        operation.add("1");
        User user = new User("muskan", "password", new Roles(Role.GUEST, operation));
        ArrayList<User> users = new ArrayList<User>();
        RolesFactory rolesFactory = new RolesFactory();
        users.add(new User("123-5678", "password1", rolesFactory.assignOperations(Role.CUSTOMER)));
        users.add(new User("123-5679", "password2", rolesFactory.assignOperations(Role.CUSTOMER)));
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users);
        Interpreter interpreter = new Interpreter(new BookLibrary(new ArrayList<Book>()), new MovieLibrary(new ArrayList<Movie>()), new InputConsole(new Scanner(System.in)), new OutputConsole(new PrintStream(System.out)), user, bibliotecaAdmin);

        exit.expectSystemExit();

        interpreter.interpret("Q");
    }

    @Test
    public void shouldInvokeDisplayMethodCallForTheSelectedOption() {
        BookLibrary bookLibrary = mock(BookLibrary.class);
        ArrayList<String> operation = new ArrayList<String>();
        operation.add("1");
        User user = new User("muskan", "password", new Roles(Role.GUEST, operation));
        ArrayList<User> users = new ArrayList<User>();
        RolesFactory rolesFactory = new RolesFactory();
        users.add(new User("123-5678", "password1", rolesFactory.assignOperations(Role.CUSTOMER)));
        users.add(new User("123-5679", "password2", rolesFactory.assignOperations(Role.CUSTOMER)));
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users);
        Interpreter interpreter = new Interpreter(bookLibrary, new MovieLibrary(new ArrayList<Movie>()), new InputConsole(new Scanner(System.in)), new OutputConsole(new PrintStream(System.out)), user, bibliotecaAdmin);

        interpreter.interpret("1");

        verify(bookLibrary, times(1)).formattedListOfAvailableBooks();
    }

    @Test
    public void shouldInvokeMovieDisplayMethodCallForTheSelectedOption() {
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        ArrayList<String> operation = new ArrayList<String>();
        operation.add("1");
        User user = new User("muskan", "password", new Roles(Role.GUEST, operation));
        ArrayList<User> users = new ArrayList<User>();
        RolesFactory rolesFactory = new RolesFactory();
        users.add(new User("123-5678", "password1", rolesFactory.assignOperations(Role.CUSTOMER)));
        users.add(new User("123-5679", "password2", rolesFactory.assignOperations(Role.CUSTOMER)));
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users);
        Interpreter interpreter = new Interpreter(new BookLibrary(new ArrayList<Book>()), movieLibrary, new InputConsole(new Scanner(System.in)), new OutputConsole(new PrintStream(System.out)), user, bibliotecaAdmin);

        interpreter.interpret("2");

        verify(movieLibrary, times(1)).formattedListOfAvailableMovies();
    }

    @Test
    public void shouldInvokeCheckOutMethodCallForTheSelectedOption() {
        BookLibrary bookLibrary = mock(BookLibrary.class);
        InputConsole inputConsole = mock(InputConsole.class);
        ArrayList<String> operation = new ArrayList<String>();
        operation.add("1");
        User user = new User("muskan", "password", new Roles(Role.GUEST, operation));
        ArrayList<User> users = new ArrayList<User>();
        RolesFactory rolesFactory = new RolesFactory();
        users.add(new User("123-5678", "password1", rolesFactory.assignOperations(Role.CUSTOMER)));
        users.add(new User("123-5679", "password2", rolesFactory.assignOperations(Role.CUSTOMER)));
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users);
        Interpreter interpreter = new Interpreter(bookLibrary, new MovieLibrary(new ArrayList<Movie>()), inputConsole, new OutputConsole(new PrintStream(System.out)), user, bibliotecaAdmin);

        when(inputConsole.getInput()).thenReturn("gone girl");

        interpreter.interpret("4");

        verify(bookLibrary, times(1)).checkOutBook("gone girl");
    }

    @Test
    public void shouldInvokeMovieCheckOutMethodCallForTheSelectedOption() {
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputConsole inputConsole = mock(InputConsole.class);
        ArrayList<String> operation = new ArrayList<String>();
        operation.add("1");
        User user = new User("muskan", "password", new Roles(Role.GUEST, operation));
        ArrayList<User> users = new ArrayList<User>();
        RolesFactory rolesFactory = new RolesFactory();
        users.add(new User("123-5678", "password1", rolesFactory.assignOperations(Role.CUSTOMER)));
        users.add(new User("123-5679", "password2", rolesFactory.assignOperations(Role.CUSTOMER)));
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users);
        Interpreter interpreter = new Interpreter(new BookLibrary(new ArrayList<Book>()), movieLibrary, inputConsole, new OutputConsole(new PrintStream(System.out)), user, bibliotecaAdmin);

        when(inputConsole.getInput()).thenReturn("gone girl");

        interpreter.interpret("3");

        verify(movieLibrary, times(1)).checkOutMovie("gone girl");
    }

    @Test
    public void shouldInvokeReturnMethodCallForTheSelectedOption() {
        BookLibrary bookLibrary = mock(BookLibrary.class);
        InputConsole inputConsole = mock(InputConsole.class);
        ArrayList<String> operation = new ArrayList<String>();
        operation.add("1");
        User user = new User("muskan", "password", new Roles(Role.GUEST, operation));
        ArrayList<User> users = new ArrayList<User>();
        RolesFactory rolesFactory = new RolesFactory();
        users.add(new User("123-5678", "password1", rolesFactory.assignOperations(Role.CUSTOMER)));
        users.add(new User("123-5679", "password2", rolesFactory.assignOperations(Role.CUSTOMER)));
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users);
        Interpreter interpreter = new Interpreter(bookLibrary, new MovieLibrary(new ArrayList<Movie>()), inputConsole, new OutputConsole(new PrintStream(System.out)), user, bibliotecaAdmin);

        when(inputConsole.getInput()).thenReturn("gone girl");

        interpreter.interpret("5");

        verify(bookLibrary, times(1)).returnBook("gone girl");
    }

    @Test
    public void shouldPrintTheAppropriateMessageWhenInvalidOptionIsSelected() {
        ArrayList<Book> books = new ArrayList<Book>();
        BookLibrary bookLibrary = new BookLibrary(books);
        InputConsole inputConsole = new InputConsole(new Scanner(System.in));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        OutputConsole out = new OutputConsole(new PrintStream(output));
        ArrayList<String> operation = new ArrayList<String>();
        operation.add("1");
        User user = new User("muskan", "password", new Roles(Role.GUEST, operation));
        ArrayList<User> users = new ArrayList<User>();
        RolesFactory rolesFactory = new RolesFactory();
        users.add(new User("123-5678", "password1", rolesFactory.assignOperations(Role.CUSTOMER)));
        users.add(new User("123-5679", "password2", rolesFactory.assignOperations(Role.CUSTOMER)));
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users);
        Interpreter interpreter = new Interpreter(bookLibrary, new MovieLibrary(new ArrayList<Movie>()), inputConsole, out, user, bibliotecaAdmin);

        interpreter.interpret("Muskan");

        assertEquals("Select A Valid Option!!\n", output.toString());
    }

    @Test
    public void shouldPrintTheAppropriateMessageWhenLogoutOptionIsSelected() {
        ArrayList<Book> books = new ArrayList<Book>();
        BookLibrary bookLibrary = new BookLibrary(books);
        InputConsole inputConsole = new InputConsole(new Scanner(System.in));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        OutputConsole out = new OutputConsole(new PrintStream(output));
        ArrayList<String> operation = new ArrayList<String>();
        operation.add("1");
        User user = new User("muskan", "password", new Roles(Role.GUEST, operation));
        ArrayList<User> users = new ArrayList<User>();
        RolesFactory rolesFactory = new RolesFactory();
        users.add(new User("123-5678", "password1", rolesFactory.assignOperations(Role.CUSTOMER)));
        users.add(new User("123-5679", "password2", rolesFactory.assignOperations(Role.CUSTOMER)));
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users);
        Interpreter interpreter = new Interpreter(bookLibrary, new MovieLibrary(new ArrayList<Movie>()), inputConsole, out, user, bibliotecaAdmin);

        interpreter.interpret("0");

        assertEquals("Logout.\n", output.toString());
    }
}
