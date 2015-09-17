package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void shouldBeEqualWhenComparingAUserToItself() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        Roles role = new Roles(Role.GUEST, operations);
        User user = new User("111-1234", "password1", role);
        assertEquals(user, user);
    }

    @Test
    public void shouldBeEqualWhenComparingAUserToAnotherUserWithSameLibraryNumberAndSameRole() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        Roles role = new Roles(Role.GUEST, operations);
        User user = new User("111-1234", "password1", role);
        User user1 = new User("111-1234", "password2", role);
        assertEquals(user, user1);
    }

    @Test
    public void shouldNotBeEqualWhenComparingAUserToAnotherUserWithDifferentLibraryNumberButSameRole() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        Roles role = new Roles(Role.GUEST, operations);
        User user = new User("111-1234", "password1", role);
        User user1 = new User("111-1235", "password2", role);
        assertNotEquals(user, user1);
    }

    @Test
    public void shouldNotBeEqualWhenComparingAUserToNull() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        User user = new User("111-1234", "password1", new Roles(Role.GUEST, operations));
        assertNotEquals(user, null);
    }

    @Test
    public void shouldNotBeEqualWhenComparingAUserToNonUserEntity() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        User user = new User("111-1234", "password1", new Roles(Role.GUEST, operations));
        assertNotEquals(user, "I am Not a User");
    }

    @Test
    public void shouldHaveSameHashCodeComparingAUserToItself() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        User user = new User("111-1234", "password1", new Roles(Role.GUEST, operations));
        assertEquals(user.hashCode(), user.hashCode());
    }

    @Test
    public void shouldHaveSameHashCodeComparingAUserToAnotherUserWithSameLibraryNumberAndRole() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        User user = new User("111-1234", "password1", new Roles(Role.GUEST, operations));
        User user1 = new User("111-1234", "password2", new Roles(Role.GUEST, operations));
        assertEquals(user.hashCode(), user1.hashCode());
    }

    @Test
    public void shouldReturnTrueIfPasswordsMatch() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        User user = new User("111-1234", "password1", new Roles(Role.GUEST, operations));

        assertTrue(user.authenticatePassword("password1"));
    }

    @Test
    public void shouldReturnFalseIfPasswordsDoNotMatch() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        User user = new User("111-1234", "password1", new Roles(Role.CUSTOMER, operations));

        assertFalse(user.authenticatePassword("password2"));
    }

    @Test
    public void theListOfOperationsThatTheUserCanDoIsSameAsThatOfItsRole() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        User user = new User("111-1234", "password1", new Roles(Role.CUSTOMER, operations));
        Roles role = new Roles(Role.CUSTOMER, operations);

        assertEquals(role.canPerformOperations(), user.canPerformOperations());
    }

    @Test
    public void theListOfOperationsThatTheUserCanDoIsDifferentFromADifferentRole() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        User user = new User("111-1234", "password1", new Roles(Role.CUSTOMER, operations));
        ArrayList<String> operations1 = new ArrayList<String>();
        operations1.add("1");
        operations1.add("2");
        Roles role = new Roles(Role.GUEST, operations1);

        assertNotEquals(role.canPerformOperations(), user.canPerformOperations());
    }

    @Test
    public void returnTheLibraryNumberOfTheCorrectUserInStringFormat() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        User user = new User("111-1234", "password1", new Roles(Role.CUSTOMER, operations));

        String userDetail = user.userDetails();

        String testString = String.format("%-30s","111-1234");
        assertEquals(testString, userDetail);
    }
}
