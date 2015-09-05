package com.twu.biblioteca;

import com.twu.biblioteca.Book;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void displayShouldPrintTheGivenBookObject() {
        Book book = new Book("Christmas Carol", "Charles Dickens", 1843);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        book.display();

        assertEquals("Christmas Carol\t\tCharles Dickens\t\t1843\n", out.toString());
        System.setOut(System.out);
    }
}