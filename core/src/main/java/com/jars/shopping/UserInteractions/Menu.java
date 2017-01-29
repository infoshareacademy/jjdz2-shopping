package com.jars.shopping.UserInteractions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import java.util.Scanner;

public class Menu {

    private static final Logger LOGGER = LoggerFactory.getLogger(Menu.class);
    private static final Marker MENU_MARKER = MarkerFactory.getMarker("MENU");


    public void displayWelcomeScreen() {
        LOGGER.info(MENU_MARKER,"Display welcome Screen");
        System.out.println("\n\n************************************");
        System.out.println("*****  J  A  R  S  ******2016*******");
        System.out.println("************************************\n\n");
    }

    public void displayMainOptionsAndGotoProperMethod() {
        System.out.println(" Proszę wybrać jedną opcję : ");
        System.out.println("**************************************");
        System.out.println(" 1 --> Identyfikowanie kategorii po serii pytań");
        // System.out.println(" 2 --> <NIE AKTYWNE> Identyfikowanie produktu po serii pytań na temat potrzeb");
        if (selector(1) == 1) {
            identifyCategory();
        }
    }

    private int selector(int numberOfOptions) throws IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);
        int selectedValue = scanner.nextInt();
        while (selectedValue > numberOfOptions || selectedValue <= 0) {
            System.out.println("\n\nProsze wybrac od 1 do " + numberOfOptions + "\n\n\n");
            selectedValue = scanner.nextInt();
        }
        return selectedValue;
    }

    private void identifyCategory() {
        AskQuestions askQuestions = new AskQuestions();
        askQuestions.startAsking();
    }
}
