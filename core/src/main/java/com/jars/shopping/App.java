package com.jars.shopping;

import com.jars.shopping.ReadFilesClasses.ReadCategories;
import com.jars.shopping.UserInteractions.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import java.util.Scanner;


public class App {
    private final static Logger LOGGER = LoggerFactory.getLogger(App.class);
    private static final Marker APP_MARKER = MarkerFactory.getMarker("MAIN APP");


    public static void main(String[] args) {

       // ReadCategories readCategories = new ReadCategories();
        LOGGER.info(APP_MARKER,"Start Application and display menu");
        Menu menu = new Menu();

        menu.displayWelcomeScreen();

        LOGGER.info(APP_MARKER,"Generate and get data");
        menu.displayMainOptionsAndGotoProperMethod();
    }
}