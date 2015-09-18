//Has the book details and is responsible to set the checkout status of the book and provide printable formatted details of the book.
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

    public String formattedBookDetails() {
        return String.format("%-30s %-30s %-30s\n", bookName, bookAuthor, yearPublished);
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

    public void returnBook() {
        isCheckedOut = false;
    }
}
