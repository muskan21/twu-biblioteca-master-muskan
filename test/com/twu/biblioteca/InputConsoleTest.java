package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class InputConsoleTest {

    @Test
    public void shouldAcceptInputFromTheConsole() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("Muskan".getBytes());

        InputConsole inputConsole = new InputConsole(new Scanner(byteArrayInputStream));
        String inputString = inputConsole.getInput();

        assertEquals("Muskan", inputString);
    }
}
