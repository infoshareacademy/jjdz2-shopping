package com.jars.shopping;

import com.jars.shopping.ReadFilesClasses.ReadCategories;
import com.jars.shopping.UserInteractions.Menu;

import java.util.Scanner;

/**
 * Created by marcinpankowski on 11.09.16.
 */
public class App {


    public static void main(String[] args) {

        ReadCategories readCategories = new ReadCategories();
        Menu menu = new Menu();

        menu.displayWelcomeScreen();
        menu.displayMainOptionsAndGotoProperMethod();
    }
}
