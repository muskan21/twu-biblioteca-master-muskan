package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LibraryTest {

    @Test
    public void initializeBooksShouldAddTheBooksToTheList() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone girl","Gyllian Flynn", 2012));
        Library library = new Library(books);

        assertEquals(1, library.size());
    }

    @Test
    public void shouldPrintTheListOfBooksOnConsole() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl","Gillian Flynn", 2012));
        Library library = new Library(books);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        library.display();

        assertEquals("Book Name                      Book Author                    Year Of Publish               \n\nGone Girl                      Gillian Flynn                  2012                          \n", out.toString());
        System.setOut(System.out);
    }

    @Test
    public void shouldInputBookToBeCheckedOut() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        Library library = new Library(books);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("Gone Girl".getBytes());
        System.setIn(byteArrayInputStream);

        String checkedOutBook = library.inputCheckedOutBook();

        assertEquals("Gone Girl", checkedOutBook);
    }

    @Test
    public void shouldValidateIfCheckedOutBookIsActuallyAvailable() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        Library library = new Library(books);

        boolean available = library.checkAvailabilityForCheckOut("Gone girl");

        assertTrue(available);
    }

    @Test
    public void shouldInvalidateIfCheckedOutBookIsNotAvailableForCheckOut() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        Library library = new Library(books);

        boolean available = library.checkAvailabilityForCheckOut("Harry potter");

        assertFalse(available);
    }
}