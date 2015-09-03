package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

public class DisplayTest {

    @Test
    public void shouldPrintTheWelcomeMessageOnConsole() {
        Display display = mock(Display.class);
        String testString = "Welcome To Biblioteca Library Management System.\nHappy To Help.";
        display.welcomeMessage(testString);
        Mockito.verify(display, times(1)).welcomeMessage(testString);
    }
}
