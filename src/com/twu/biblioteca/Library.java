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
            }
        }
        if(checkOutFlag)
            return "Thank You! Enjoy The Book.";
        else
            return "That Book Is Not Available!";
    }
}
