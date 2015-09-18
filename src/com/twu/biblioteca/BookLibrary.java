/*Has the list of books and the users that have checked out books, and is responsible for checkout and checking in the books from the library,
providing printable formatted details of all the books in the library and giving details to the librarian about who has checked out which book.
 */
package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class BookLibrary {
    public static final int UNKNOWN_YEAR_PUBLISHED = 0;
    public static final String UNKNOWN_BOOK_AUTHOR = "";
    private ArrayList<Book> bookList;
    private HashMap<Book, User> bookStatus;

    public BookLibrary(ArrayList<Book> bookList) {
        this.bookList = bookList;
        bookStatus = new HashMap<Book, User>();
    }

    public String formattedListOfAvailableBooks() {
        String booksList = String.format("%-25s %-25s %-25s\n\n", "Book Name", "Book Author", "Year Of Publish");
        for(Book book : bookList) {
            if(!book.checkOutStatus()) {
                booksList += book.formattedBookDetails();
            }
        }
        return booksList;
    }

    public String checkOutBook(String checkOutBook, User user) {
        boolean checkOutFlag = false;
        Book bookToCheckOut = new Book(checkOutBook, UNKNOWN_BOOK_AUTHOR, UNKNOWN_YEAR_PUBLISHED);
        for(Book book : bookList) {
            if(book.equals(bookToCheckOut) && !(book.checkOutStatus())) {
                book.checkOutBook();
                bookStatus.put(book, user);
                checkOutFlag = true;
                break;
            }
        }
        if(checkOutFlag)
            return "Thank You! Enjoy The Book.";
        else
            return "That Book Is Not Available!";
    }

    public String returnBook(String bookName, User user) {
        Book returnedBook = new Book(bookName, UNKNOWN_BOOK_AUTHOR, UNKNOWN_YEAR_PUBLISHED);
        boolean returnFlag = false;
        for(Book book : bookList) {
            if(book.equals(returnedBook) && book.checkOutStatus()) {
                if(getUserForBook(book) != null && getUserForBook(book).equals(user)) {
                    bookStatus.remove(book);
                    book.returnBook();
                    returnFlag = true;
                    break;
                }
            }
        }
        if(returnFlag)
            return "Thank You for returning the book.";
        else
            return "That is not a valid book to return";
    }

    User getUserForBook(Book book) {
        return bookStatus.get(book);
    }

    public String bookLibraryStatus() {
        String libraryStatus = String.format("%-25s %-25s %-25s %-25s %-25s %-25s %-25s\n\n","Library Number", "User name", "Email", "Contact Number", "Book Name", "Book Author", "Year Of Publish");
        for(Book book : bookList){
            if(getUserForBook(book) != null) {
                libraryStatus += getUserForBook(book).userDetails();
                libraryStatus += book.formattedBookDetails();
            }
        }
        return libraryStatus;
    }
}
