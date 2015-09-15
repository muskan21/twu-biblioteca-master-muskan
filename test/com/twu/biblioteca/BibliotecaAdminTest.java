package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BibliotecaAdminTest {

    @Test
    public void shouldReturnGuestUserWhenLoginCredentialsDoNotMatch() {
        User user1 = new User("111-1234", "password1");
        User user2 = new User("012-3212", "password2");
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users);

        String libraryNumber = bibliotecaAdmin.login("113-1234", "password3");

        assertEquals("Guest User", libraryNumber);
    }
}
