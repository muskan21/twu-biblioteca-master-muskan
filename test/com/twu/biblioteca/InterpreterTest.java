package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class InterpreterTest {
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldExitIfExitOptionIsChosen() {
        Interpreter interpreter = new Interpreter(new Library(new ArrayList<Book>()), new InputConsole());

        exit.expectSystemExit();

        interpreter.interpret("4");
    }

    @Test
    public void shouldInvokeDisplayMethodCallForTheSelectedOption() {
        Library library = mock(Library.class);
        Interpreter interpreter = new Interpreter(library, new InputConsole());

        interpreter.interpret("1");

        verify(library, times(1)).display();
    }

    @Test
    public void shouldInvokeCheckOutMethodCallForTheSelectedOption() {
        Library library = mock(Library.class);
        InputConsole inputConsole = mock(InputConsole.class);
        Interpreter interpreter = new Interpreter(library, inputConsole);

        when(inputConsole.getInput()).thenReturn("gone girl");

        interpreter.interpret("2");

        verify(library, times(1)).checkOutBook("gone girl");
    }

    @Test
    public void shouldInvokeReturnMethodCallForTheSelectedOption() {
        Library library = mock(Library.class);
        InputConsole inputConsole = mock(InputConsole.class);
        Interpreter interpreter = new Interpreter(library, inputConsole);

        when(inputConsole.getInput()).thenReturn("gone girl");

        interpreter.interpret("3");

        verify(library, times(1)).returnBook("gone girl");
    }

    @Test
    public void shouldPrintTheAppropriateMessageWhenInvalidOptionIsSelected() {
        ArrayList<Book> books = new ArrayList<Book>();
        Library library = new Library(books);
        InputConsole inputConsole = new InputConsole();
        Interpreter interpreter = new Interpreter(library, inputConsole);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        interpreter.interpret("Muskan");

        assertEquals("Select A Valid Option!!\n", out.toString());
    }
}
