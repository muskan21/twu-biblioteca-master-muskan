package com.twu.biblioteca;

import java.util.ArrayList;

public class BookList {
    private ArrayList<Book> bookList;

    public BookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public void display() {
        System.out.printf("%-30s %-30s %-30s\n\n", "Book Name", "Book Author", "Year Of Publish");
        for(Book book : bookList) {
            book.display();
        }
    }

    public int size() {
        return bookList.size();
    }
}
