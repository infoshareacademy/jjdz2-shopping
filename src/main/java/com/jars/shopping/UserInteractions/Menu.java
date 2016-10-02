package com.jars.shopping.UserInteractions;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Scanner;

/**
 * Created by keehoo on 02.10.16.
 */
public class Menu {

    AskQuestions askQuestions = new AskQuestions();

    public void displayWelcomeScreen() {
        System.out.println("\n\n************************************");
        System.out.println("*****  J  A  R  S  *****************");
        System.out.println("************************************\n\n");
    }

    public void displayMainOptionsAndReturnSelectedValue() {
        System.out.println("Proszę wybrać opjcę");
        System.out.println(" 1 --> Identyfikowanie kategorii po serii pytań");
        System.out.println(" 2 --> Identyfikowanie produktu po serii pytań na temat potrzeb");
        int selectedValue = selector(2);
        if (selectedValue == 1) {identifyCategory();}
        else if (selectedValue == 2) {identifyProduct();}
    }


    public int selector(int numberOfOptions) throws IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);
        int selectedValue = scanner.nextInt();
        if (selectedValue > numberOfOptions || selectedValue <= 0) {
            throw new IllegalArgumentException("Liczba opcji musi byc pomiedzy 1 a "+numberOfOptions+ " natomiast Ty podałeś "+selectedValue);
        } else return selectedValue;
    }

    private void identifyCategory() {
        System.out.println("Tutaj nastepuje seria pytań po ktorych mozemy dobrac kategorie");

    }

    private void identifyProduct() {
        System.out.println("Tutaj nastepuje seria pytań po ktorych mozemy dobrac produkt");
    }


}
