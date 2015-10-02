package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class CheckOutMovieOptionTest {

    @Test
    public void shouldDisplayCheckoutMovieInputMessage() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputConsole outputConsole = new OutputConsole(new PrintStream(byteArrayOutputStream));
        InputConsole inputConsole = mock(InputConsole.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        CheckOutMovieOption checkOutMovieOption = new CheckOutMovieOption(outputConsole, inputConsole, movieLibrary);

        checkOutMovieOption.execute();

        assertEquals("Enter The Name Of The Movie To Check Out : \n", byteArrayOutputStream.toString());
    }
}
