package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class InputConsoleTest {

    @Test
    public void shouldAcceptInputFromTheConsole() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("Muskan".getBytes());
        System.setIn(byteArrayInputStream);

        InputConsole inputConsole = new InputConsole();
        String inputString = inputConsole.getInput();

        assertEquals("Muskan", inputString);
    }
}
