package com.jars.shopping.UserInteractions;

import com.jars.shopping.POJOs.models.Question;
import com.jars.shopping.POJOs.models.Questionary;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class AskQuestions {

    List<Question> questionList;

    public void startAsking() {

        Questionary questionary = new Questionary();
        questionList = new ArrayList<>();
        //questionList = questionary.getQuestions();

        // FOR TESTING PURPOSES
        // DUMMY DATA !!!

        Question question = new Question();
        question.setTitle("Jak sie masz");
        questionList.add(question);

        // END OF DUMMY DATA

        if (!questionList.isEmpty()) {
            for (Question q :
                    questionList) {
                if (q == null) {
                    System.out.println("Question is null!!!");
                    break;
                }
                System.out.println(q.getTitle());
            }
        } else {
            System.out.println("Lista jest pusta!!!!");
        }
    }
}
