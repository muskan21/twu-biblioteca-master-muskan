package com.twu.biblioteca;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotEquals;

public class BookLibraryTest {

    @Test
    public void shouldPrintTheListOfBooksOnConsole() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        BookLibrary bookLibrary = new BookLibrary(books);

        String booklistDetails = bookLibrary.formattedListOfAvailableBooks();

        assertEquals("Book Name                      Book Author                    Year Of Publish               \n\nGone Girl                      Gillian Flynn                  2012                          \n", booklistDetails);
    }

    @Test
    public void shouldNotPrintTheBooksOnConsoleWhichHaveBeenCheckedOut() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl","Gillian Flynn", 2012));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2000));
        BookLibrary bookLibrary = new BookLibrary(books);

        bookLibrary.checkOutBook("Harry Potter");
        String booklistDetails = bookLibrary.formattedListOfAvailableBooks();

        assertEquals("Book Name                      Book Author                    Year Of Publish               \n\nGone Girl                      Gillian Flynn                  2012                          \n", booklistDetails);
        System.setOut(System.out);
    }

    @Test
    public void shouldValidateIfCheckedOutBookIsActuallyAvailable() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        BookLibrary bookLibrary = new BookLibrary(books);

        String available = bookLibrary.checkOutBook("Gone girl");

        assertEquals("Thank You! Enjoy The Book.", available);
    }

    @Test
    public void shouldInvalidateIfCheckedOutBookIsNotAvailableForCheckOut() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        BookLibrary bookLibrary = new BookLibrary(books);

        String available = bookLibrary.checkOutBook("Harry potter");

        assertEquals("That Book Is Not Available!", available);
    }

    @Test
    public void listOfAvailableBooksShouldNotHaveTheCheckedOutBook() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2000));
        BookLibrary bookLibrary = new BookLibrary(books);

        String booklistDetails = bookLibrary.formattedListOfAvailableBooks();

        bookLibrary.checkOutBook("Harry Potter");
        String booklistDetail = bookLibrary.formattedListOfAvailableBooks();

        assertNotEquals(booklistDetails, booklistDetail);
    }

    @Test
    public void listOfAvailableBooksRemainsSameIfBookNotCheckedOut() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2000));
        BookLibrary bookLibrary = new BookLibrary(books);

        String listDetails = bookLibrary.formattedListOfAvailableBooks();

        bookLibrary.checkOutBook("Bleh Book");
        String listDetail = bookLibrary.formattedListOfAvailableBooks();

        assertEquals(listDetails, listDetail);
    }

    @Test
    public void hasTheNewListOfAvailableBooksIfValidBookIsReturned() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2000));
        BookLibrary bookLibrary = new BookLibrary(books);

        bookLibrary.checkOutBook("Gone girl");
        String returnString = bookLibrary.returnBook("Gone girl");

        assertEquals("Thank You for returning the book.", returnString);
        System.setOut(System.out);
    }

    @Test
    public void doesNotHaveTheNewListOfAvailableBooksIfInvalidBookIsReturned() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2000));
        BookLibrary bookLibrary = new BookLibrary(books);

        bookLibrary.checkOutBook("Harry Potter");
        String returnString = bookLibrary.returnBook("Harry");

        assertEquals("That is not a valid book to return", returnString);
        System.setOut(System.out);
    }

    @Test
    public void doesNotReturnTheBookIfAlreadyAvailableBookIsReturned() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2000));
        BookLibrary bookLibrary = new BookLibrary(books);

        String returnString = bookLibrary.returnBook("Harry potter");

        assertEquals("That is not a valid book to return", returnString);
        System.setOut(System.out);
    }
}