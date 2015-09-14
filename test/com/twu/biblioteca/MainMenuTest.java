package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

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
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        mainMenu.addOption("List Books.");
        mainMenu.display();

        assertEquals("Main Menu : \n1. List Books.\nEnter Your Choice : \n", out.toString());
        System.setOut(System.out);

    }
}
