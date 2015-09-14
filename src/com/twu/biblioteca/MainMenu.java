package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

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

    public void display() {
        System.out.println("Main Menu : ");
        for (String option: options) {
            System.out.println(option);
        }
        System.out.println("Enter Your Choice : ");
    }
}
