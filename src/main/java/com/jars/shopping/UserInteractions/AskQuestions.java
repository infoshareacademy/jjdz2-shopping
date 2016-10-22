package com.jars.shopping.UserInteractions;

import com.jars.shopping.POJOs.models.OfferedCategories;
import com.jars.shopping.POJOs.models.OptionsOfAnswers;
import com.jars.shopping.POJOs.models.Question;
import com.jars.shopping.POJOs.models.Questionary;

import java.util.*;

public class AskQuestions {

    List<Question> questionList;
    List<OptionsOfAnswers> optionsList;
    List<OfferedCategories> answersList;
    Scanner scanner = new Scanner(System.in);

    public void startAsking() {

        Questionary questionary = new Questionary();
        questionList = new ArrayList<>();
        optionsList = new ArrayList<>();
        answersList = new ArrayList<>();
        questionList = questionary.getQuestions();
        for (Question q : questionList) {

            System.out.println(q.getTitle());
            System.out.println("Opcje: ");
            List<OptionsOfAnswers> options = q.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println("Opcja " + (i + 1) + "   ---   " + options.get(i).getLabel());

            }

            int selecion = scanner.nextInt();
            while (selecion > options.size() || selecion < 1) {
                System.out.println("Prosze wybrac od 1 do 3");
                selecion = scanner.nextInt();
            }

                //System.out.println("Wybrano odpowiedz " + selecion + " , czyli, " + options.get(selecion - 1).toString());
                System.out.println(options.get(selecion - 1).getCategories().toString());
                answersList.add(options.get(selecion - 1).getCategories());

        }
        printOutResultsOfAnswers();
    }

    private void printOutResultsOfAnswers() {
        System.out.println("************************");
        System.out.println("**** REZULTATY *********");
        System.out.println("************************");

        List<String> en = new ArrayList<>();
        List<String> pl = new ArrayList<>();

        for (OfferedCategories o : answersList) {
            //System.out.println("Lista kategorii EN");

            for (String s : o.getEn()) {
                en.add(s);
            }

            //System.out.println("Lista kategorii PL:");
            for (String s : o.getPl()) {
                pl.add(s);
            }
        }

        System.out.println("Lista kategorii EN:");
        for (String s : en) System.out.println(" -->"+s);

        System.out.println("Lista kategorii PL");
        for (String s : pl) System.out.println(" -->"+s);


        System.out.println("************************");
        System.out.println("************************");
        System.out.println("************************");
        System.out.println("************************");
        System.out.println("************************");
        System.out.println(" Czy chcesz wygenerowac linki do Allegro i eBay? (Y/N)");
        if (scanner.next().toLowerCase().equals("y")) {
            Results results = new Results();
            results.getAllegroLinks(pl, en);
            results.printAllegroLinks();
            results.printEbayLinks();
            System.exit(0);
        } else System.exit(0);
    }

}

