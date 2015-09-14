package com.twu.biblioteca;

import java.util.ArrayList;

public class MainMenu {
    private ArrayList<String> options;

    public MainMenu(ArrayList<String> options) {
        this.options = options;
    }

    public String formattedMenu() {
        String menuDetails = String.format("Main Menu : \n");
        for (String option: options) {
            menuDetails += option+"\n";
        }
        menuDetails += "Enter Your Choice : \n";
        return menuDetails;
    }
}
