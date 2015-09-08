package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotEquals;

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

    @Test
    public void listOfAvailableBooksShouldNotHaveTheCheckedOutBook() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2000));
        Library library = new Library(books);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("Harry Potter".getBytes());
        System.setIn(byteArrayInputStream);

        boolean checkOutFlag = library.CheckOutBook();

        ArrayList<Book> books1 = new ArrayList<Book>();
        books1.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        ArrayList<Book> books2 = new ArrayList<Book>();
        books2.add(new Book("Harry Potter", "J.K. Rowling", 2000));
        Library library1 = new Library(books1, books2);

        assertEquals(library, library1);
    }

    @Test
    public void shouldBeEqualWhenComparingABookListToItself() {
        Book Book = new Book("Christmas Carol", "Charles Dickens", 1843);
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2000));
        books.add(Book);
        Library library = new Library(books);
        assertEquals(library, library);
    }

    @Test
    public void shouldBeEqualWhenComparingABookListToAnotherBookListWithSameBooks() {
        Book Book = new Book("Christmas Carol", "Charles Dickens", 1843);
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(Book);
        Library library = new Library(books);
        Book Book1 = new Book("Christmas Carol", "Charles", 1843);
        ArrayList<Book> books1 = new ArrayList<Book>();
        books1.add(Book1);
        Library library1 = new Library(books1);
        assertEquals(library, library1);
    }

    @Test
    public void shouldBeEqualWhenComparingABookListToAnotherBookListWithSameNameBooksIgnoringTheCase() {
        Book Book = new Book("Christmas Carol", "Charles Dickens", 1843);
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(Book);
        Library library = new Library(books);
        Book Book1 = new Book("christmas carol", "Charles", 1843);
        ArrayList<Book> books1 = new ArrayList<Book>();
        books1.add(Book1);
        Library library1 = new Library(books1);
        assertEquals(library, library1);
    }

    @Test
    public void shouldNotBeEqualWhenComparingABookListToNull() {
        Book Book = new Book("Christmas Carol", "Charles Dickens", 1843);
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(Book);
        Library library = new Library(books);
        assertNotEquals(library, null);
    }

    @Test
    public void shouldNotBeEqualWhenComparingABookListToNonBookListEntity() {
        Book Book = new Book("Christmas Carol", "Charles Dickens", 1843);
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(Book);
        Library library = new Library(books);
        assertNotEquals(library, "I am Not a Book");
    }

    @Test
    public void shouldNotBeEqualWhenComparingABookListToAnotherBookListWithDifferentNameBooks() {
        Book book = new Book("Christmas Carol", "Charles Dickens", 1843);
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(book);
        Library library = new Library(books);
        Book book1 = new Book("Christmas Carol Bleh", "Charles Dickens", 1843);
        ArrayList<Book> books1 = new ArrayList<Book>();
        books1.add(book1);
        Library library1 = new Library(books1);
        assertNotEquals(library, library1);
    }

    @Test
    public void shouldHaveSameHashCodeComparingABookListToItself() {
        Book Book = new Book("Christmas Carol", "Charles Dickens", 1843);
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(Book);
        Library library = new Library(books);
        assertEquals(library.hashCode(), library.hashCode());
    }

    @Test
    public void shouldHaveSameHashCodeComparingABookListToAnotherBookListWithSameNameBooks() {
        Book book = new Book("Christmas Carol", "Charles Dickens", 1843);
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(book);
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2000));
        Library library = new Library(books);
        Book book1 = new Book("Christmas Carol", "Charles Dickens", 1843);
        ArrayList<Book> books1 = new ArrayList<Book>();
        books1.add(book1);
        books1.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        books1.add(new Book("Harry Potter", "J.K. Rowling", 2000));
        Library library1 = new Library(books1);
        assertEquals(library.hashCode(), library1.hashCode());
    }

    @Test
    public void shouldHaveSameHashCodeWhenComparingABookListToAnotherBookListWithSameNameBooksIgnoringTheCase() {
        Book book = new Book("Christmas Carol", "Charles Dickens", 1843);
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(book);
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2000));
        Library library = new Library(books);
        Book book1 = new Book("christmas carol", "Charles", 1843);
        ArrayList<Book> books1 = new ArrayList<Book>();
        books1.add(book1);
        books1.add(new Book("gone Girl", "Gillian Flynn", 2012));
        books1.add(new Book("harry Potter", "J.K. Rowling", 2000));
        Library library1 = new Library(books1);
        assertEquals(library.hashCode(), library1.hashCode());
    }
}