package com.twu.biblioteca;

public class Book {
    private String bookName;
    private String bookAuthor;
    private int yearPublished;

    public Book(String bookName, String bookAuthor, int yearPublished) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.yearPublished = yearPublished;
    }

    public void display() {
        System.out.printf("%-30s %-30s %-30s\n", bookName, bookAuthor, yearPublished);
    }
}
