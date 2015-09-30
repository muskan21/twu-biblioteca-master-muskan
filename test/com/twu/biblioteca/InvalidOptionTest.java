package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InvalidOptionTest {

    @Test
    public void shouldReturnInvalidMessageOnExecution() {
        InvalidOption invalidOption = new InvalidOption("Invalid Message.");
        String returnString = invalidOption.execute();

        String testString = "Invalid Message.";

        assertEquals(testString, returnString);
    }

    @Test
    public void shouldReturnTheGivenInvalidMessageOnExecution() {
        InvalidOption invalidOption = new InvalidOption("Select A Valid Option.");
        String returnString = invalidOption.execute();

        String testString = "Select A Valid Option.";

        assertEquals(testString, returnString);
    }
}
