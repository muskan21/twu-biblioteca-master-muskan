package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void displayShouldPrintTheGivenBookObject() {
        Book book = new Book("Christmas Carol", "Charles Dickens", 1843);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        book.display();

        assertEquals("Christmas Carol                Charles Dickens                1843                          \n", out.toString());
        System.setOut(System.out);
    }

    @Test
    public void shouldBeEqualWhenComparingABookToItself() {
        Book Book = new Book("Christmas Carol", "Charles Dickens", 1843);
        assertEquals(Book, Book);
    }

    @Test
    public void shouldBeEqualWhenComparingABookToAnotherBookWithSameName() {
        Book Book = new Book("Christmas Carol", "Charles Dickens", 1843);
        Book Book1 = new Book("Christmas Carol", "Charles", 1843);
        assertEquals(Book, Book1);
    }

    @Test
    public void shouldBeEqualWhenComparingABookToAnotherBookWithSameNameIgnoringTheCase() {
        Book Book = new Book("Christmas Carol", "Charles Dickens", 1843);
        Book Book1 = new Book("christmas carol", "Charles", 1843);
        assertEquals(Book, Book1);
    }

    @Test
    public void shouldNotBeEqualWhenComparingABookToNull() {
        assertNotEquals(new Book("Christmas Carol", "Charles Dickens", 1843), null);
    }

    @Test
    public void shouldNotBeEqualWhenComparingABookToNonBookEntity() {
        assertNotEquals(new Book("Christmas Carol", "Charles Dickens", 1843), "I am Not a Book");
    }

    @Test
    public void shouldNotBeEqualWhenComparingABookToAnotherBookWithDifferentName() {
        Book book = new Book("Christmas Carol", "Charles Dickens", 1843);
        Book book1 = new Book("Christmas Carol Bleh", "Charles Dickens", 1843);
        assertNotEquals(book, book1);
    }

    @Test
    public void shouldHaveSameHashCodeComparingABookToItself() {
        Book Book = new Book("Christmas Carol", "Charles Dickens", 1843);
        assertEquals(Book.hashCode(), Book.hashCode());
    }

    @Test
    public void shouldHaveSameHashCodeComparingABookToAnotherBookWithSameName() {
        Book book = new Book("Christmas Carol", "Charles Dickens", 1843);
        Book book1 = new Book("Christmas Carol", "Charles Dickens", 1843);
        assertEquals(book.hashCode(), book1.hashCode());
    }

    @Test
    public void shouldHaveSameHashCodeWhenComparingABookToAnotherBookWithSameNameIgnoringTheCase() {
        Book Book = new Book("Christmas Carol", "Charles Dickens", 1843);
        Book Book1 = new Book("christmas carol", "Charles", 1843);
        assertEquals(Book.hashCode(), Book1.hashCode());
    }
}