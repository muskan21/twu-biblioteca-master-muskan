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
        Interpreter interpreter = new Interpreter(new BookLibrary(new ArrayList<Book>()), new MovieLibrary(new ArrayList<Movie>()), new InputConsole(new Scanner(System.in)), new OutputConsole(new PrintStream(System.out)));

        exit.expectSystemExit();

        interpreter.interpret("Q");
    }

    @Test
    public void shouldInvokeDisplayMethodCallForTheSelectedOption() {
        BookLibrary bookLibrary = mock(BookLibrary.class);
        Interpreter interpreter = new Interpreter(bookLibrary, new MovieLibrary(new ArrayList<Movie>()), new InputConsole(new Scanner(System.in)), new OutputConsole(new PrintStream(System.out)));

        interpreter.interpret("1");

        verify(bookLibrary, times(1)).formattedListOfAvailableBooks();
    }

    @Test
    public void shouldInvokeMovieDisplayMethodCallForTheSelectedOption() {
        MovieLibrary movieLibrary = mock(MovieLibrary.class);

        Interpreter interpreter = new Interpreter(new BookLibrary(new ArrayList<Book>()), movieLibrary, new InputConsole(new Scanner(System.in)), new OutputConsole(new PrintStream(System.out)));

        interpreter.interpret("2");

        verify(movieLibrary, times(1)).formattedListOfAvailableMovies();
    }

    @Test
    public void shouldInvokeCheckOutMethodCallForTheSelectedOption() {
        BookLibrary bookLibrary = mock(BookLibrary.class);
        InputConsole inputConsole = mock(InputConsole.class);
        Interpreter interpreter = new Interpreter(bookLibrary, new MovieLibrary(new ArrayList<Movie>()), inputConsole, new OutputConsole(new PrintStream(System.out)));

        when(inputConsole.getInput()).thenReturn("gone girl");

        interpreter.interpret("4");

        verify(bookLibrary, times(1)).checkOutBook("gone girl");
    }

    @Test
    public void shouldInvokeMovieCheckOutMethodCallForTheSelectedOption() {
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputConsole inputConsole = mock(InputConsole.class);
        Interpreter interpreter = new Interpreter(new BookLibrary(new ArrayList<Book>()), movieLibrary, inputConsole, new OutputConsole(new PrintStream(System.out)));

        when(inputConsole.getInput()).thenReturn("gone girl");

        interpreter.interpret("3");

        verify(movieLibrary, times(1)).checkOutMovie("gone girl");
    }

    @Test
    public void shouldInvokeReturnMethodCallForTheSelectedOption() {
        BookLibrary bookLibrary = mock(BookLibrary.class);
        InputConsole inputConsole = mock(InputConsole.class);
        Interpreter interpreter = new Interpreter(bookLibrary, new MovieLibrary(new ArrayList<Movie>()), inputConsole, new OutputConsole(new PrintStream(System.out)));

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
        Interpreter interpreter = new Interpreter(bookLibrary, new MovieLibrary(new ArrayList<Movie>()), inputConsole, out);

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
        Interpreter interpreter = new Interpreter(bookLibrary, new MovieLibrary(new ArrayList<Movie>()), inputConsole, out);

        interpreter.interpret("0");

        assertEquals("Logout.\n", output.toString());
    }
}
