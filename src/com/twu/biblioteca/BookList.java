package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BookList {
    private ArrayList<Book> availableBookList;
    private ArrayList<Book> checkedOutBookList;

    public BookList(ArrayList<Book> availableBookList) {
        this.availableBookList = availableBookList;
        this.checkedOutBookList = new ArrayList<Book>();
    }

    public void display() {
        System.out.printf("%-15s %-30s %-30s %-30s\n\n","Serial No.", "Book Name", "Book Author", "Year Of Publish");
        for(Book book : availableBookList) {
            book.display();
        }
    }

    public int size() {
        return availableBookList.size();
    }

    public void CheckOutBook() {
        return;
    }

    public int inputCheckedOutBook() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public boolean checkAvailabilityForCheckOut(int bookno) {
        for(Book book : availableBookList) {
            if(book.matchSerialNumber(bookno))
                return true;
        }
        return false;
    }
}
