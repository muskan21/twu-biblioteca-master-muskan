package com.twu.biblioteca;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class OutputConsoleTest {

    @Test
    public void shouldPrintTheGivenMessage() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        OutputConsole outputConsole = new OutputConsole(printStream);

        outputConsole.display("Muskan");

        assertEquals("Muskan\n", out.toString());
    }
}
