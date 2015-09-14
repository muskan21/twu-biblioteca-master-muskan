package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MainMenuTest {

    @Test
    public void shouldPrintTheOptionsOnConsole() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books.");
        MainMenu mainMenu = new MainMenu(options);

        String menu = mainMenu.formattedMenu();

        assertEquals("Main Menu : \n1. List Books.\nEnter Your Choice : \n", menu);
    }
}
