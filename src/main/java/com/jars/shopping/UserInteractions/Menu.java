package com.jars.shopping.UserInteractions;

import java.util.Scanner;

/**
 * Created by keehoo on 02.10.16.
 */
public class Menu {

    public void displayWelcomeScreen() {
        System.out.println("\n\n************************************");
        System.out.println("*****  J  A  R  S  *****************");
        System.out.println("************************************\n\n");

    }

    private int displayMainOptionsAndReturnSelectedValue() {
        System.out.println(" 1 --> Identyfikowanie kategorii po serii pytań");
        System.out.println(" 2 --> Identyfikowanie produktu po serii pytań na temat potrzeb");
        return selector(2);
    }

    private int selector(int numberOfOptions) {
        Scanner scanner = new Scanner(System.in);
        int selectedValue = scanner.nextInt();
        if (selectedValue > numberOfOptions || selectedValue <= 0) {
            return selector(numberOfOptions);
        } else return selectedValue;
    }

    private void identifyCategory(){

    }


}
