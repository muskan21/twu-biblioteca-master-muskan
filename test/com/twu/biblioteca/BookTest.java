package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void displayShouldPrintTheGivenBookObject() {
        Book book = new Book("Christmas Carol", "Charles Dickens", 1843);

        String bookDetails = book.formattedBookDetails();

        assertEquals("Christmas Carol           Charles Dickens           1843                     \n", bookDetails);
    }

    @Test
    public void shouldBeEqualWhenComparingABookToItself() {
        Book book = new Book("Christmas Carol", "Charles Dickens", 1843);
        assertEquals(book, book);
    }

    @Test
    public void shouldBeEqualWhenComparingABookToAnotherBookWithSameName() {
        Book book = new Book("Christmas Carol", "Charles Dickens", 1843);
        Book book1 = new Book("Christmas Carol", "Charles", 1843);
        assertEquals(book, book1);
    }

    @Test
    public void shouldBeEqualWhenComparingABookToAnotherBookWithSameNameIgnoringTheCase() {
        Book book = new Book("Christmas Carol", "Charles Dickens", 1843);
        Book book1 = new Book("christmas carol", "Charles", 1843);
        assertEquals(book, book1);
    }

    @Test
    public void shouldNotBeEqualWhenComparingABookToNull() {
        Book book = new Book("Christmas Carol", "Charles Dickens", 1843);
        assertNotEquals(book, null);
    }

    @Test
    public void shouldNotBeEqualWhenComparingABookToNonBookEntity() {
        Book book = new Book("Christmas Carol", "Charles Dickens", 1843);
        assertNotEquals(book, "I am Not a Book");
    }

    @Test
    public void shouldNotBeEqualWhenComparingABookToAnotherBookWithDifferentName() {
        Book book = new Book("Christmas Carol", "Charles Dickens", 1843);
        Book book1 = new Book("Christmas Carol Bleh", "Charles Dickens", 1843);
        assertNotEquals(book, book1);
    }

    @Test
    public void shouldHaveSameHashCodeComparingABookToItself() {
        Book book = new Book("Christmas Carol", "Charles Dickens", 1843);
        assertEquals(book.hashCode(), book.hashCode());
    }

    @Test
    public void shouldHaveSameHashCodeComparingABookToAnotherBookWithSameName() {
        Book book = new Book("Christmas Carol", "Charles Dickens", 1843);
        Book book1 = new Book("Christmas Carol", "Charles Dickens", 1843);
        assertEquals(book.hashCode(), book1.hashCode());
    }

    @Test
    public void shouldHaveSameHashCodeWhenComparingABookToAnotherBookWithSameNameIgnoringTheCase() {
        Book book = new Book("Christmas Carol", "Charles Dickens", 1843);
        Book book1 = new Book("christmas carol", "Charles", 1843);
        assertEquals(book.hashCode(), book1.hashCode());
    }

    @Test
    public void shouldReturnFalseInitiallySinceBookIsNotCheckedOut() {
        Book book = new Book("Christmas Carol", "Charles Dickens", 1843);
        assertFalse(book.checkOutStatus());
    }

    @Test
    public void shouldReturnTrueIfBookIsCheckedOut() {
        Book book = new Book("Christmas Carol", "Charles Dickens", 1843);
        book.checkOutBook();
        assertTrue(book.checkOutStatus());
    }

    @Test
    public void shouldReturnFalseIfBookIsReturned() {
        Book book = new Book("Christmas Carol", "Charles Dickens", 1843);
        book.returnBook();
        assertFalse(book.checkOutStatus());
    }
}