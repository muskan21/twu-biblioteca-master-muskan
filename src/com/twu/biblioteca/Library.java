package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<Book> availableBookList;
    private ArrayList<Book> checkedOutBookList;

    public Library(ArrayList<Book> availableBookList) {
        this.availableBookList = availableBookList;
        this.checkedOutBookList = new ArrayList<Book>();
    }

    public void display() {
        System.out.printf("%-30s %-30s %-30s\n\n","Book Name", "Book Author", "Year Of Publish");
        for(Book book : availableBookList) {
            book.display();
        }
    }

    public int size() {
        return availableBookList.size();
    }

    public String checkOutBook() {
        String checkedOutBook = inputCheckedOutBook();
        boolean available = checkAvailabilityForCheckOut(checkedOutBook);
        if(available)
            return "Thank You! Enjoy The Book.";
        else
            return "That Book Is Not Available!";
    }

    public String inputCheckedOutBook() {
        //System.out.println("Enter The Name Of The Book To Check Out : ");
        Scanner scanner = new Scanner(System.in);
        String bookName = "";
        bookName = scanner.nextLine();
        return bookName;
    }

    public boolean checkAvailabilityForCheckOut(String bookName) {
        Book checkOutBook = new Book(bookName);
        for(Book book : availableBookList) {
            if(book.equals(checkOutBook)) {
                availableBookList.remove(book);
                checkedOutBookList.add(book);
                return true;
            }
        }
        return false;
    }
}
