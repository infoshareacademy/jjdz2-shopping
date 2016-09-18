package com.jars.shopping.UserInteractions;

import com.jars.shopping.POJOs.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by keehoo on 12.09.2016.
 */
public class AskQuestions {

    Scanner scanner = new Scanner(System.in);
    List<Question> questions = new ArrayList<Question>();
    Question q = new Question(1, "How do you do");
    List<String> answersList = new ArrayList<String>();

    public AskQuestions(List<Question> questions) {
        this.questions = questions;
    }


    public void askQuestions(List<Question> questions) {
        addDummyQuestionList();
        int numberOfQuestions = questions.size();
        for (Question q :
                questions) {
            System.out.println(q.getqContent());
            String answer = scanner.next();
            // TODO: Add validations
            System.out.println(answer);
            answersList.add(answer);
        }
    }

    public void addDummyQuestionList() {
        questions.add(q);
    }


}
