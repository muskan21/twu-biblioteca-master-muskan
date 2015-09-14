package com.twu.biblioteca;

import java.util.ArrayList;

public class BookLibrary {
    public static final int UNKNOWN_YEAR_PUBLISHED = 0;
    public static final String UNKNOWN_BOOK_AUTHOR = "";
    private ArrayList<Book> bookList;

    public BookLibrary(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public String formattedListOfAvailableBooks() {
        String booksList = String.format("%-30s %-30s %-30s\n\n", "Book Name", "Book Author", "Year Of Publish");
        for(Book book : bookList) {
            if(!book.checkOutStatus()) {
                booksList += book.formattedBookDetails();
            }
        }
        return booksList;
    }

    public String checkOutBook(String checkOutBook) {
        boolean checkOutFlag = false;
        Book bookToCheckOut = new Book(checkOutBook, UNKNOWN_BOOK_AUTHOR, UNKNOWN_YEAR_PUBLISHED);
        for(Book book : bookList) {
            if(book.equals(bookToCheckOut) && !(book.checkOutStatus())) {
                book.checkOutBook();
                checkOutFlag = true;
                break;
            }
        }
        if(checkOutFlag)
            return "Thank You! Enjoy The Book.";
        else
            return "That Book Is Not Available!";
    }

    public String returnBook(String bookName) {
        Book returnedBook = new Book(bookName, UNKNOWN_BOOK_AUTHOR, UNKNOWN_YEAR_PUBLISHED);
        boolean returnFlag = false;
        for(Book book : bookList) {
            if(book.equals(returnedBook) && book.checkOutStatus()) {
                book.returnBook();
                returnFlag = true;
                break;
            }
        }
        if(returnFlag)
            return "Thank You for returning the book.";
        else
            return "That is not a valid book to return";
    }
}
