package com.jars.shopping;

import com.jars.shopping.POJOs.Category;
import com.jars.shopping.POJOs.Question;
import com.jars.shopping.ReadFilesClasses.QuestionOperations;
import com.jars.shopping.ReadFilesClasses.ReadCategories;
import com.jars.shopping.UserInteractions.AskQuestions;

import java.util.ArrayList;

/**
 * Created by marcinpankowski on 11.09.16.
 */
public class App {


    public static void main(String[] args) {

        ReadCategories readCategories = new ReadCategories();
        QuestionOperations questionOperations = new QuestionOperations();
        ArrayList<Question> questions = (ArrayList<Question>) questionOperations.getQuestionList();
        ArrayList<Category> categories = (ArrayList<Category>) readCategories.getCategories();
        //readCategories.printNMatchingCategories(45, "Meble");

        AskQuestions askQuestions = new AskQuestions(questions);
        askQuestions.askQuestions(questions);



    }
}
