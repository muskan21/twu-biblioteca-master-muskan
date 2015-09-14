package com.twu.biblioteca;


import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BibliotecaAppTest {

    @Test
    public void shouldInvokeTheStartApplicationMethod() {
        BibliotecaApp bibliotecaApp = mock(BibliotecaApp.class);

        bibliotecaApp.start();

        verify(bibliotecaApp, times(1)).start();
    }

    @Test
    public void shouldCallTheWelcomeMessageMethod() {
        BibliotecaApp bibliotecaApp = mock(BibliotecaApp.class);
        String testString = "Welcome To Biblioteca Library Management System.\nHappy To Help.";
        bibliotecaApp.welcomeMessage(testString);
        verify(bibliotecaApp, times(1)).welcomeMessage(testString);
    }

    @Test
    public void shouldPrintTheWelcomeMessageOnConsole() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        OutputConsole outputConsole = new OutputConsole(printStream);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(new MainMenu(), new InputConsole(new Scanner(System.in)), new Interpreter(new Library(new ArrayList<Book>()), new InputConsole(new Scanner(System.in)), outputConsole), outputConsole);
        bibliotecaApp.welcomeMessage("Welcome To Biblioteca Library Management System.\nHappy To Help.");
        assertEquals("Welcome To Biblioteca Library Management System.\nHappy To Help.\n", out.toString());
    }

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldExitTheWhileLoop() {
        OutputConsole outputConsole = new OutputConsole(new PrintStream(System.out));
        InputConsole inputConsole = mock(InputConsole.class);
        MainMenu menu = mock(MainMenu.class);
        Library library = mock(Library.class);
        Interpreter interpreter = new Interpreter(library, inputConsole, outputConsole);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(menu, inputConsole, interpreter, outputConsole);

        exit.expectSystemExit();
        when(inputConsole.getInput()).thenReturn("4");
        bibliotecaApp.start();

        verify(interpreter, times(1)).interpret("4");
    }
}
