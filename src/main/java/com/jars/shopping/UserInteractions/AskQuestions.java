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
            if (selecion > options.size())
                throw new IllegalArgumentException(" Proszę wybrać od 1 do " + options.size());
            else {
                System.out.println("Wybrano odpowiedz " + selecion + " , czyli, " + options.get(selecion - 1).toString());
                System.out.println(options.get(selecion - 1).getCategories().toString());
                answersList.add(options.get(selecion - 1).getCategories());
            }
        }
        printOutResultsOfAnswers();
    }

    private void printOutResultsOfAnswers() {
        System.out.println("************************");
        System.out.println("**** REZULTATY *********");

        for (OfferedCategories o : answersList) {
            System.out.println(o.getEn());
            System.out.println(o.getPl());
        }
    }

}

