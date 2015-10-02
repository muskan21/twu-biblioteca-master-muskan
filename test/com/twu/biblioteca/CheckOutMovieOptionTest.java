package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.matches;
import static org.mockito.Mockito.*;

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

    @Test
    public void shouldAcceptUserInputForMovieNameToBeCheckedOut() {
        OutputConsole outputConsole = mock(OutputConsole.class);
        InputConsole inputConsole = mock(InputConsole.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        CheckOutMovieOption checkOutMovieOption = new CheckOutMovieOption(outputConsole, inputConsole, movieLibrary);

        checkOutMovieOption.execute();

        verify(inputConsole, times(1)).getInput();
    }

    @Test
    public void shouldInvokeTheCheckOutMovieMethodWithTheGivenInput() {
        OutputConsole outputConsole = mock(OutputConsole.class);
        InputConsole inputConsole = mock(InputConsole.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        CheckOutMovieOption checkOutMovieOption = new CheckOutMovieOption(outputConsole, inputConsole, movieLibrary);

        when(inputConsole.getInput()).thenReturn("Muskan");
        checkOutMovieOption.execute();

        verify(movieLibrary, times(1)).checkOutMovie("Muskan");
    }

    @Test
    public void shouldReturnCheckoutMessage() {
        OutputConsole outputConsole = mock(OutputConsole.class);
        InputConsole inputConsole = mock(InputConsole.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        CheckOutMovieOption checkOutMovieOption = new CheckOutMovieOption(outputConsole, inputConsole, movieLibrary);

        when(inputConsole.getInput()).thenReturn("Muskan");
        when(movieLibrary.checkOutMovie("Muskan")).thenReturn("CheckOutMessage");
        String checkoutMessage = checkOutMovieOption.execute();

        assertEquals("CheckOutMessage", checkoutMessage);
    }
}
