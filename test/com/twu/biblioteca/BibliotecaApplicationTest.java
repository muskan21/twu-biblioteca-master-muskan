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
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(new MainMenu(new ArrayList<String>()), new InputConsole(new Scanner(System.in)), new Interpreter(new BookLibrary(new ArrayList<Book>()), new MovieLibrary(new ArrayList<Movie>()), new InputConsole(new Scanner(System.in)), outputConsole), outputConsole);
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
        Interpreter interpreter = new Interpreter(bookLibrary, new MovieLibrary(new ArrayList<Movie>()), inputConsole, outputConsole);
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(menu, inputConsole, interpreter, outputConsole);

        exit.expectSystemExit();
        when(inputConsole.getInput()).thenReturn("6");
        bibliotecaApplication.start();

        verify(interpreter, times(1)).interpret("6");
    }
}
