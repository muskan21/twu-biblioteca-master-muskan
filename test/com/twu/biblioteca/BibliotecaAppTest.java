package com.twu.biblioteca;


import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

public class BibliotecaAppTest {

    @Test
    public void shouldDisplayWelcomeMessageOnStartingApplication() {
        BibliotecaApp bibliotecaApp = mock(BibliotecaApp.class);

        bibliotecaApp.start();

        Mockito.verify(bibliotecaApp, times(1)).start();
    }

    @Test
    public void shouldCallTheWelcomeMessageMethod() {
        BibliotecaApp bibliotecaApp = mock(BibliotecaApp.class);
        String testString = "Welcome To Biblioteca Library Management System.\nHappy To Help.";
        bibliotecaApp.welcomeMessage(testString);
        Mockito.verify(bibliotecaApp, times(1)).welcomeMessage(testString);
    }

    @Test
    public void shouldPrintTheWelcomeMessageOnConsole() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        BibliotecaApp bibliotecaApp = new BibliotecaApp(new Library(new ArrayList<Book>()), new MainMenu(), new Interpreter(new Library(new ArrayList<Book>()), new InputConsole()));
        bibliotecaApp.welcomeMessage("Welcome To Biblioteca Library Management System.\nHappy To Help.");
        assertEquals("Welcome To Biblioteca Library Management System.\nHappy To Help.\n", out.toString());
        System.setOut(System.out);
    }
}
