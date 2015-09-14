package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainMenuTest {

    @Test
    public void shouldBeAbleToAddAnOption() {
        MainMenu mainMenu = new MainMenu();

        mainMenu.addOption("List Books.");

        assertEquals(1, mainMenu.getNoOfOptions());
    }

    @Test
    public void shouldPrintTheOptionsOnConsole() {
        MainMenu mainMenu = new MainMenu();

        mainMenu.addOption("List Books.");
        String menu = mainMenu.formattedMenu();

        assertEquals("Main Menu : \n1. List Books.\nEnter Your Choice : \n", menu);
    }
}
