package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

public class DisplayTest {

    @Test
    public void shouldCallTheWelcomeMessageMethod() {
        Display display = mock(Display.class);
        String testString = "Welcome To Biblioteca Library Management System.\nHappy To Help.";
        display.welcomeMessage(testString);
        Mockito.verify(display, times(1)).welcomeMessage(testString);
    }

    @Test
    public void shouldPrintTheWelcomeMessageOnConsole() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Display display = new Display();
        display.welcomeMessage("Welcome To Biblioteca Library Management System.\nHappy To Help.");
        assertEquals("Welcome To Biblioteca Library Management System.\nHappy To Help.\n", out.toString());
        System.setOut(System.out);
    }
}
