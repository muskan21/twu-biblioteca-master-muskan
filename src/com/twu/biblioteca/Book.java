package com.twu.biblioteca;

public class Book {
    private String bookName;
    private String bookAuthor;
    private int yearPublished;
    private int serialNumber;

    public Book(int serialNumber, String bookName, String bookAuthor, int yearPublished) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.yearPublished = yearPublished;
        this.serialNumber = serialNumber;
    }

    public void display() {
        System.out.printf("%-15d %-30s %-30s %-30s\n", serialNumber, bookName, bookAuthor, yearPublished);
    }

    public boolean matchSerialNumber(int serialNumber) {
        if(this.serialNumber == serialNumber)
            return true;
        return false;
    }
}
