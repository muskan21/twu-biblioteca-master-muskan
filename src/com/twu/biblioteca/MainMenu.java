package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class MainMenu {
    private HashMap<String, String> menuOptions;

    public MainMenu(HashMap<String, String> menuOptions) {
        this.menuOptions = menuOptions;
    }

    public String formattedMenu(ArrayList<String> availableOptions) {
        String menuDetails = String.format("Main Menu : \n");
        for(int i = 0; i < availableOptions.size(); i++){
            if(menuOptions.containsKey(availableOptions.get(i)))
                menuDetails += (availableOptions.get(i) + " " + menuOptions.get(availableOptions.get(i)) + "\n");
        }
        menuDetails += "Enter Your Choice : \n";
        return menuDetails;
    }
}
