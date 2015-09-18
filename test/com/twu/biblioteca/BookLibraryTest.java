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

        assertEquals("Book Name                 Book Author               Year Of Publish          \n\nGone Girl                 Gillian Flynn             2012                     \n", booklistDetails);
    }

    @Test
    public void shouldNotPrintTheBooksOnConsoleWhichHaveBeenCheckedOut() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl","Gillian Flynn", 2012));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2000));
        BookLibrary bookLibrary = new BookLibrary(books);
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        operations.add("2");
        User user = new User("123-1234", "password", new Roles(Role.CUSTOMER, operations), "", "", 0);

        bookLibrary.checkOutBook("Harry Potter", user);
        String booklistDetails = bookLibrary.formattedListOfAvailableBooks();

        assertEquals("Book Name                 Book Author               Year Of Publish          \n\nGone Girl                 Gillian Flynn             2012                     \n", booklistDetails);
        System.setOut(System.out);
    }

    @Test
    public void shouldValidateIfCheckedOutBookIsActuallyAvailable() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        BookLibrary bookLibrary = new BookLibrary(books);
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        operations.add("2");
        User user = new User("123-1234", "password", new Roles(Role.CUSTOMER, operations), "", "", 0);

        String available = bookLibrary.checkOutBook("Gone girl", user);

        assertEquals("Thank You! Enjoy The Book.", available);
    }

    @Test
    public void shouldInvalidateIfCheckedOutBookIsNotAvailableForCheckOut() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        BookLibrary bookLibrary = new BookLibrary(books);
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        operations.add("2");
        User user = new User("123-1234", "password", new Roles(Role.CUSTOMER, operations), "", "", 0);

        String available = bookLibrary.checkOutBook("Harry potter", user);

        assertEquals("That Book Is Not Available!", available);
    }

    @Test
    public void listOfAvailableBooksShouldNotHaveTheCheckedOutBook() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2000));
        BookLibrary bookLibrary = new BookLibrary(books);
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        operations.add("2");
        User user = new User("123-1234", "password", new Roles(Role.CUSTOMER, operations), "", "", 0);

        String booklistDetails = bookLibrary.formattedListOfAvailableBooks();

        bookLibrary.checkOutBook("Harry Potter", user);
        String booklistDetail = bookLibrary.formattedListOfAvailableBooks();

        assertNotEquals(booklistDetails, booklistDetail);
    }

    @Test
    public void listOfAvailableBooksRemainsSameIfBookNotCheckedOut() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2000));
        BookLibrary bookLibrary = new BookLibrary(books);
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        operations.add("2");
        User user = new User("123-1234", "password", new Roles(Role.CUSTOMER, operations), "", "", 0);

        String listDetails = bookLibrary.formattedListOfAvailableBooks();

        bookLibrary.checkOutBook("Bleh Book", user);
        String listDetail = bookLibrary.formattedListOfAvailableBooks();

        assertEquals(listDetails, listDetail);
    }

    @Test
    public void hasTheNewListOfAvailableBooksIfValidBookIsReturned() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2000));
        BookLibrary bookLibrary = new BookLibrary(books);
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        operations.add("2");
        User user = new User("123-1234", "password", new Roles(Role.CUSTOMER, operations), "", "", 0);

        bookLibrary.checkOutBook("Gone girl", user);
        String returnString = bookLibrary.returnBook("Gone girl", user);

        assertEquals("Thank You for returning the book.", returnString);
        System.setOut(System.out);
    }

    @Test
    public void doesNotHaveTheNewListOfAvailableBooksIfInvalidBookIsReturned() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2000));
        BookLibrary bookLibrary = new BookLibrary(books);
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        operations.add("2");
        User user = new User("123-1234", "password", new Roles(Role.CUSTOMER, operations), "", "", 0);

        bookLibrary.checkOutBook("Harry Potter", user);
        String returnString = bookLibrary.returnBook("Harry", user);

        assertEquals("That is not a valid book to return", returnString);
        System.setOut(System.out);
    }

    @Test
    public void doesNotHaveTheNewListOfAvailableBooksIfValidBookIsReturnedByInvalidUser() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2000));
        BookLibrary bookLibrary = new BookLibrary(books);
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        operations.add("2");
        User user = new User("123-1234", "password", new Roles(Role.CUSTOMER, operations), "", "", 0);

        bookLibrary.checkOutBook("Harry Potter", user);
        User user1 = new User("123-5678", "password5", new Roles(Role.CUSTOMER, operations), "", "", 0);
        String returnString = bookLibrary.returnBook("Harry Potter", user1);

        assertEquals("That is not a valid book to return", returnString);
        System.setOut(System.out);
    }

    @Test
    public void doesNotReturnTheBookIfAlreadyAvailableBookIsReturned() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2000));
        BookLibrary bookLibrary = new BookLibrary(books);
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        operations.add("2");
        User user = new User("123-1234", "password", new Roles(Role.CUSTOMER, operations), "", "", 0);

        String returnString = bookLibrary.returnBook("Harry potter", user);

        assertEquals("That is not a valid book to return", returnString);
        System.setOut(System.out);
    }

    @Test
    public void shouldReturnTheCorrectUserForTheBookCheckedOut() {
            ArrayList<Book> books = new ArrayList<Book>();
            books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
            books.add(new Book("Harry Potter", "J.K. Rowling", 2000));
            BookLibrary bookLibrary = new BookLibrary(books);
            ArrayList<String> operations = new ArrayList<String>();
            operations.add("1");
            operations.add("2");
            User user = new User("123-1234", "password", new Roles(Role.CUSTOMER, operations), "", "", 0);

            bookLibrary.formattedListOfAvailableBooks();

            bookLibrary.checkOutBook("Harry Potter", user);
            User user1 = bookLibrary.getUserForBook(new Book("Harry Potter", "", 0));

        assertEquals(user, user1);
    }

    @Test
    public void shouldReturnNullForTheBookThatHasNotBeenCheckedOut() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2000));
        BookLibrary bookLibrary = new BookLibrary(books);
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        operations.add("2");
        User user = new User("123-1234", "password", new Roles(Role.CUSTOMER, operations), "", "", 0);

        bookLibrary.formattedListOfAvailableBooks();

        User user1 = bookLibrary.getUserForBook(new Book("Harry Potter", "", 0));

        assertEquals(null, user1);
    }

    @Test
    public void shouldReturnLibraryCheckoutDetails() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2000));
        BookLibrary bookLibrary = new BookLibrary(books);
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        operations.add("2");
        User user = new User("123-1234", "password", new Roles(Role.CUSTOMER, operations), "user1", "user1@gmail.com", 6654378);
        User user1 = new User("111-1234", "password1", new Roles(Role.LIBRARIAN, operations), "user2", "user2@gmail.com", 6364677);
        bookLibrary.checkOutBook("Gone girl", user);
        bookLibrary.checkOutBook("harry potter", user1);

        String bookDetails = bookLibrary.bookLibraryStatus();

        String testString = String.format("%-25s %-25s %-25s %-25s %-25s %-25s %-25s\n\n%-25s %-25s %-25s %-25d%-25s %-25s %-25d\n%-25s %-25s %-25s %-25d%-25s %-25s %-25d\n", "Library Number", "User name", "Email", "Contact Number", "Book Name", "Book Author", "Year Of Publish", "123-1234", "user1", "user1@gmail.com", 6654378, "Gone Girl", "Gillian Flynn", 2012, "111-1234", "user2", "user2@gmail.com", 6364677, "Harry Potter", "J.K. Rowling", 2000);
        assertEquals(testString, bookDetails);
    }
}