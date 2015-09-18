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
        User user = new User("111-1234", "password1", role, "muskan", "muskan@gmail.com", 9876543);
        assertEquals(user, user);
    }

    @Test
    public void shouldBeEqualWhenComparingAUserToAnotherUserWithSameLibraryNumberAndSameRole() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        Roles role = new Roles(Role.GUEST, operations);
        User user = new User("111-1234", "password1", role, "muskan", "muskan@gmail.com", 9876543);
        User user1 = new User("111-1234", "password2", role, "muskan1", "muskan1@gmail.com", 9878543);
        assertEquals(user, user1);
    }

    @Test
    public void shouldNotBeEqualWhenComparingAUserToAnotherUserWithDifferentLibraryNumberButSameRole() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        Roles role = new Roles(Role.GUEST, operations);
        User user = new User("111-1234", "password1", role, "muskan", "muskan@gmail.com", 9876543);
        User user1 = new User("111-1235", "password2", role, "muskan1", "muskan1@gmail.com", 9875543);
        assertNotEquals(user, user1);
    }

    @Test
    public void shouldNotBeEqualWhenComparingAUserToNull() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        User user = new User("111-1234", "password1", new Roles(Role.GUEST, operations), "muskan", "muskan@gmail.com", 9876543);
        assertNotEquals(user, null);
    }

    @Test
    public void shouldNotBeEqualWhenComparingAUserToNonUserEntity() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        User user = new User("111-1234", "password1", new Roles(Role.GUEST, operations), "muskan", "muskan@gmail.com", 9876543);
        assertNotEquals(user, "I am Not a User");
    }

    @Test
    public void shouldHaveSameHashCodeComparingAUserToItself() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        User user = new User("111-1234", "password1", new Roles(Role.GUEST, operations), "muskan", "muskan@gmail.com", 9876543);
        assertEquals(user.hashCode(), user.hashCode());
    }

    @Test
    public void shouldHaveSameHashCodeComparingAUserToAnotherUserWithSameLibraryNumberAndRole() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        User user = new User("111-1234", "password1", new Roles(Role.GUEST, operations), "muskan", "muskan@gmail.com", 9876543);
        User user1 = new User("111-1234", "password2", new Roles(Role.GUEST, operations), "muskan1", "muskan1@gmail.com", 9876943);
        assertEquals(user.hashCode(), user1.hashCode());
    }

    @Test
    public void shouldReturnTrueIfPasswordsMatch() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        User user = new User("111-1234", "password1", new Roles(Role.GUEST, operations), "muskan", "muskan@gmail.com", 9876543);

        assertTrue(user.authenticatePassword("password1"));
    }

    @Test
    public void shouldReturnFalseIfPasswordsDoNotMatch() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        User user = new User("111-1234", "password1", new Roles(Role.CUSTOMER, operations), "muskan", "muskan@gmail.com", 9876543);

        assertFalse(user.authenticatePassword("password2"));
    }

    @Test
    public void theListOfOperationsThatTheUserCanDoIsSameAsThatOfItsRole() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        User user = new User("111-1234", "password1", new Roles(Role.CUSTOMER, operations), "muskan", "muskan@gmail.com", 9876543);
        Roles role = new Roles(Role.CUSTOMER, operations);

        assertEquals(role.canPerformOperations(), user.canPerformOperations());
    }

    @Test
    public void theListOfOperationsThatTheUserCanDoIsDifferentFromADifferentRole() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        User user = new User("111-1234", "password1", new Roles(Role.CUSTOMER, operations), "muskan", "muskan@gmail.com", 9876543);
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
        User user = new User("111-1234", "password1", new Roles(Role.CUSTOMER, operations), "muskan", "muskan@gmail.com", 9876543);

        String userDetail = user.userDetails();

        String testString = String.format("%-25s %-25s %-25s %-25d","111-1234", "muskan", "muskan@gmail.com", 9876543);
        assertEquals(testString, userDetail);
    }

    @Test
    public void returnFormattedUserDetailsOfTheUser() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        User user = new User("111-1234", "password1", new Roles(Role.CUSTOMER, operations), "muskan", "muskan@gmail.com", 9876543);

        String userDetail = user.formattedUserDetails();

        String testString = String.format("%-25s %-25s %-25s %-25s\n\n%-25s %-25s %-25s %-25d\n", "Library Number", "User name", "Email", "Contact number", "111-1234", "muskan", "muskan@gmail.com", 9876543);
        assertEquals(testString, userDetail);
    }
}
