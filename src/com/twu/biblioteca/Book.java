package com.twu.biblioteca;

public class Book {
    private String bookName;
    private String bookAuthor;
    private int yearPublished;
    private boolean isCheckedOut;

    public Book(String bookName, String bookAuthor, int yearPublished) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.yearPublished = yearPublished;
        this.isCheckedOut = false;
    }

    public Book(String bookName) {
        this.bookName = bookName;
        this.bookAuthor = "";
        this.yearPublished = 0;
        this.isCheckedOut = false;
    }

    public void display() {
        System.out.printf("%-30s %-30s %-30s\n", bookName, bookAuthor, yearPublished);
    }

    @Override
    public boolean equals(Object bookObject) {
        if (this == bookObject)
            return true;
        if (bookObject == null || getClass() != bookObject.getClass())
            return false;
        Book book = (Book) bookObject;
        return bookName.equalsIgnoreCase(book.bookName);
    }

    @Override
    public int hashCode() {
        return bookName.toLowerCase().hashCode();
    }

    public boolean checkOutStatus() {
        return isCheckedOut;
    }

    public void checkOutBook() {
        isCheckedOut = true;
    }
}
