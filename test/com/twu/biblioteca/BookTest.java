package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BookTest {

    @Test
    public void displayShouldPrintTheGivenBookObject() {
        Book book = new Book(1, "Christmas Carol", "Charles Dickens", 1843);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        book.display();

        assertEquals("1               Christmas Carol                Charles Dickens                1843                          \n", out.toString());
        System.setOut(System.out);
    }

    @Test
    public void shouldReturnTrueForANumberMatchingTheSerialNumberOfTheBook() {
        Book book = new Book(1, "Christmas Carol", "Charles Dickens", 1843);

        assertTrue(book.matchSerialNumber(1));
    }
}