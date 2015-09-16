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
        User user = new User("123-1234", "password", rolesFactory.assignOperations(Role.GUEST));
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("123-5678", "password1", rolesFactory.assignOperations(Role.CUSTOMER)));
        users.add(new User("123-5679", "password2", rolesFactory.assignOperations(Role.CUSTOMER)));
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users);
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
        User user = new User("123-1234", "password", rolesFactory.assignOperations(Role.GUEST));
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("123-5678", "password1", rolesFactory.assignOperations(Role.CUSTOMER)));
        users.add(new User("123-5679", "password2", rolesFactory.assignOperations(Role.CUSTOMER)));
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users);
        Interpreter interpreter = new Interpreter(bookLibrary, new MovieLibrary(new ArrayList<Movie>()), inputConsole, outputConsole, user, bibliotecaAdmin);
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(menu, inputConsole, interpreter, outputConsole, rolesFactory);

        exit.expectSystemExit();
        when(inputConsole.getInput()).thenReturn("Q");
        bibliotecaApplication.start();

        verify(interpreter, times(1)).interpret("Q");
    }
}
