package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UserTest {
    @Test
    public void shouldBeEqualWhenComparingAUserToItself() {
        User user = new User("111-1234", "password1");
        assertEquals(user, user);
    }

    @Test
    public void shouldBeEqualWhenComparingAUserToAnotherUserWithSameName() {
        User user = new User("111-1234", "password1");
        User user1 = new User("111-1234", "password2");
        assertEquals(user, user1);
    }

    @Test
    public void shouldNotBeEqualWhenComparingAUserToNull() {
        User user = new User("111-1234", "password1");
        assertNotEquals(user, null);
    }

    @Test
    public void shouldNotBeEqualWhenComparingAUserToNonUserEntity() {
        User user = new User("111-1234", "password1");
        assertNotEquals(user, "I am Not a Book");
    }

    @Test
    public void shouldNotBeEqualWhenComparingAUserToAnotherUserWithDifferentLibraryNumber() {
        User user = new User("111-1234", "password1");
        User user1 = new User("112-1234", "password1");
        assertNotEquals(user, user1);
    }

    @Test
    public void shouldHaveSameHashCodeComparingAUserToItself() {
        User user = new User("111-1234", "password1");
        assertEquals(user.hashCode(), user.hashCode());
    }

    @Test
    public void shouldHaveSameHashCodeComparingAUserToAnotherUserWithSameName() {
        User user = new User("111-1234", "password1");
        User user1 = new User("111-1234", "password2");
        assertEquals(user.hashCode(), user1.hashCode());
    }
}
