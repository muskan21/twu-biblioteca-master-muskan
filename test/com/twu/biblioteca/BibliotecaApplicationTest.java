package com.twu.biblioteca;


import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BibliotecaApplicationTest {

    @Test
    public void shouldInvokeTheStartApplicationMethod() {
        BibliotecaApplication bibliotecaApplication = mock(BibliotecaApplication.class);

        bibliotecaApplication.start();

        verify(bibliotecaApplication, times(1)).start();
    }

    @Test
    public void shouldCallTheWelcomeMessageMethod() {
        BibliotecaApplication bibliotecaApplication = mock(BibliotecaApplication.class);
        String testString = "Welcome To Biblioteca Library Management System.\nHappy To Help.";
        bibliotecaApplication.welcomeMessage(testString);
        verify(bibliotecaApplication, times(1)).welcomeMessage(testString);
    }

    @Test
    public void shouldPrintTheWelcomeMessageOnConsole() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        OutputConsole outputConsole = new OutputConsole(printStream);
        RolesFactory rolesFactory = new RolesFactory();
        User user = new User("123-1234", "password", rolesFactory.assignOperations(Role.GUEST), "", "", 0);
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("123-5678", "password1", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        users.add(new User("123-5679", "password2", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory, outputConsole);
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(new MainMenu(new HashMap<String, String>()), new InputConsole(new Scanner(System.in)), new Interpreter(new BookLibrary(new ArrayList<Book>()), new MovieLibrary(new ArrayList<Movie>()), new InputConsole(new Scanner(System.in)), outputConsole, user, bibliotecaAdmin), outputConsole, rolesFactory);
        bibliotecaApplication.welcomeMessage("Welcome To Biblioteca Library Management System.\nHappy To Help.");
        assertEquals("Welcome To Biblioteca Library Management System.\nHappy To Help.\n", out.toString());
    }

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldExitTheWhileLoop() {
        OutputConsole outputConsole = new OutputConsole(new PrintStream(System.out));
        InputConsole inputConsole = mock(InputConsole.class);
        MainMenu menu = mock(MainMenu.class);
        BookLibrary bookLibrary = mock(BookLibrary.class);
        RolesFactory rolesFactory = new RolesFactory();
        User user = new User("123-1234", "password", rolesFactory.assignOperations(Role.GUEST), "", "", 0);
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("123-5678", "password1", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        users.add(new User("123-5679", "password2", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory, outputConsole);
        Interpreter interpreter = new Interpreter(bookLibrary, new MovieLibrary(new ArrayList<Movie>()), inputConsole, outputConsole, user, bibliotecaAdmin);
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(menu, inputConsole, interpreter, outputConsole, rolesFactory);

        exit.expectSystemExit();
        when(inputConsole.getInput()).thenReturn("Q");
        bibliotecaApplication.start();

        verify(interpreter, times(1)).interpret("Q");
    }

    @Test
    public void shouldSuccessfullyPrintNewUsersMenuOnLogin() {
        OutputConsole outputConsole = new OutputConsole(new PrintStream(System.out));
        InputConsole inputConsole = mock(InputConsole.class);
        HashMap<String, String> menuOptions = new HashMap<String, String>();
        menuOptions.put("1", "List Books.");
        menuOptions.put("2", "List Movies.");
        menuOptions.put("3", "Check Out Movies.");
        menuOptions.put("4", "Check Out Book.");
        menuOptions.put("5", "Return Book.");
        menuOptions.put("6", "Book Details.");
        menuOptions.put("7", "User Details.");
        menuOptions.put("L", "Login.");
        menuOptions.put("0", "Logout.");
        menuOptions.put("Q", "Quit.");
        MainMenu menu = new MainMenu(menuOptions);
        BookLibrary bookLibrary = mock(BookLibrary.class);
        RolesFactory rolesFactory = new RolesFactory();
        User user = new User("123-1234", "password", rolesFactory.assignOperations(Role.GUEST), "", "", 0);
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("123-5678", "password1", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        users.add(new User("123-5679", "password2", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        users.add(new User("123-5677", "password3", rolesFactory.assignOperations(Role.LIBRARIAN), "", "", 0));
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory, outputConsole);
        Interpreter interpreter = new Interpreter(bookLibrary, new MovieLibrary(new ArrayList<Movie>()), inputConsole, outputConsole, user, bibliotecaAdmin);
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(menu, inputConsole, interpreter, outputConsole, rolesFactory);

        exit.expectSystemExit();
        when(inputConsole.getInput()).thenReturn("L", "123-5677", "password3", "Q");
        bibliotecaApplication.start();

        verify(interpreter, times(1)).interpret("L");
        verify(interpreter, times(1)).interpret("Q");
    }
}
