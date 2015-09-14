package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<Book> bookList;

    public Library(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public void display() {
        System.out.printf("%-30s %-30s %-30s\n\n","Book Name", "Book Author", "Year Of Publish");
        for(Book book : bookList) {
            if(!book.checkOutStatus())
                book.display();
        }
    }

    public String checkOutBook(String checkOutBook) {
        boolean checkOutFlag = false;
        Book bookToCheckOut = new Book(checkOutBook);
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
        Book returnedBook = new Book(bookName);
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
