package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class MainMenuTest {

    @Test
    public void shouldPrintTheOptionsOnConsole() {
        HashMap<String, String> menuOptions = new HashMap<String, String>();
        menuOptions.put("1", "List Books.");
        MainMenu mainMenu = new MainMenu(menuOptions);
        ArrayList<String> availableOptions = new ArrayList<String>();
        availableOptions.add("1");
        availableOptions.add("2");
        availableOptions.add("3");

        String menu = mainMenu.formattedMenu(availableOptions);

        assertEquals("Main Menu : \n1 List Books.\nEnter Your Choice : \n", menu);
    }
}
