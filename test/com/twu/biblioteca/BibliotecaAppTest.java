package com.twu.biblioteca;


import org.junit.Test;
import org.mockito.Mockito;

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
    public void shouldInitiallyHaveAnEmptyListOfBooks() {
        Display display = new Display();
        ArrayList<String> books = new ArrayList<String>();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(display, books);
        assertEquals(0, bibliotecaApp.books.size());
    }
}
