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
        BibliotecaApp bibliotecaApp = new BibliotecaApp(new ArrayList<String>());
        bibliotecaApp.welcomeMessage("Welcome To Biblioteca Library Management System.\nHappy To Help.");
        assertEquals("Welcome To Biblioteca Library Management System.\nHappy To Help.\n", out.toString());
        System.setOut(System.out);
    }

    @Test
    public void shouldInitiallyHaveAnEmptyListOfBooks() {
        ArrayList<String> books = new ArrayList<String>();

        BibliotecaApp bibliotecaApp = new BibliotecaApp(books);

        assertEquals(0, bibliotecaApp.books.size());
    }

    @Test
    public void initializeBooksShouldAddTheBooksToTheList() {
        ArrayList<String> books = new ArrayList<String>();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(books);

        bibliotecaApp.initializeBooks();

        assertEquals(5, bibliotecaApp.books.size());
    }

    @Test
    public void shouldInvokeTheMethodToPrintTheListOfBooksOnConsole() {
        BibliotecaApp bibliotecaApp = mock(BibliotecaApp.class);

        bibliotecaApp.listOfBooks();

        Mockito.verify(bibliotecaApp, times(1)).listOfBooks();
    }

    @Test
    public void shouldPrintTheListOfBooksOnConsole() {
        ArrayList<String> books = new ArrayList<String>();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(books);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        bibliotecaApp.initializeBooks();
        bibliotecaApp.listOfBooks();

        assertEquals("Gone Girl\nImmortals Of Meluha\nSecrets Of Nagas\nPragmatic Programmer\nLet Us Java\n", out.toString());
        System.setOut(System.out);
    }
}
