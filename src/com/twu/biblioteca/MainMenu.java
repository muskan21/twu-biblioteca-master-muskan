package com.twu.biblioteca;

import java.util.ArrayList;

public class MainMenu {
    private ArrayList<String> options;
    private int noOfOptions;

    public MainMenu() {
        options = new ArrayList<String>();
        noOfOptions = 0;
    }

    public void addOption(String option) {
        noOfOptions++;
        options.add(noOfOptions+". "+option);
    }

    public int getNoOfOptions() {
        return noOfOptions;
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
