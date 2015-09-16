package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void shouldBeEqualWhenComparingAUserToItself() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        Roles role = new Roles(Role.GUEST);
        User user = new User("111-1234", "password1", role);
        assertEquals(user, user);
    }

    @Test
    public void shouldBeEqualWhenComparingAUserToAnotherUserWithSameLibraryNumberAndSameRole() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        Roles role = new Roles(Role.GUEST);
        User user = new User("111-1234", "password1", role);
        User user1 = new User("111-1234", "password2", role);
        assertEquals(user, user1);
    }

    @Test
    public void shouldNotBeEqualWhenComparingAUserToAnotherUserWithDifferentLibraryNumberButSameRole() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        Roles role = new Roles(Role.GUEST);
        User user = new User("111-1234", "password1", role);
        User user1 = new User("111-1235", "password2", role);
        assertNotEquals(user, user1);
    }

    @Test
    public void shouldNotBeEqualWhenComparingAUserToNull() {
        User user = new User("111-1234", "password1", new Roles(Role.GUEST));
        assertNotEquals(user, null);
    }

    @Test
    public void shouldNotBeEqualWhenComparingAUserToNonUserEntity() {
        User user = new User("111-1234", "password1", new Roles(Role.GUEST));
        assertNotEquals(user, "I am Not a User");
    }

    @Test
    public void shouldHaveSameHashCodeComparingAUserToItself() {
        User user = new User("111-1234", "password1", new Roles(Role.GUEST));
        assertEquals(user.hashCode(), user.hashCode());
    }

    @Test
    public void shouldHaveSameHashCodeComparingAUserToAnotherUserWithSameLibraryNumberAndRole() {
        User user = new User("111-1234", "password1", new Roles(Role.GUEST));
        User user1 = new User("111-1234", "password2", new Roles(Role.GUEST));
        assertEquals(user.hashCode(), user1.hashCode());
    }

    @Test
    public void shouldReturnTrueIfPasswordsMatch() {
        User user = new User("111-1234", "password1", new Roles(Role.GUEST));

        assertTrue(user.authenticatePassword("password1"));
    }

    @Test
    public void shouldReturnFalseIfPasswordsDoNotMatch() {
        User user = new User("111-1234", "password1", new Roles(Role.CUSTOMER));

        assertFalse(user.authenticatePassword("password2"));
    }

    @Test
    public void theListOfOperationsThatTheUserCanDoIsSameAsThatOfItsRole() {
        User user = new User("111-1234", "password1", new Roles(Role.CUSTOMER));
        Roles role = new Roles(Role.CUSTOMER);

        assertEquals(role.canPerformOperations(), user.canPerformOperations());
    }

    @Test
    public void theListOfOperationsThatTheUserCanDoIsDifferentFromADifferentRole() {
        User user = new User("111-1234", "password1", new Roles(Role.CUSTOMER));
        Roles role = new Roles(Role.GUEST);

        assertNotEquals(role.canPerformOperations(), user.canPerformOperations());
    }
}
