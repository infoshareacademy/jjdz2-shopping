package com.jars.shopping.ReadFilesClasses;

import com.google.gson.Gson;
import com.jars.shopping.POJOs.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by keehoo on 12.09.2016.
 */
public class QuestionOperations {
    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    private List<Question> questionList = new ArrayList<Question>();
    //http://stackoverflow.com/questions/2591098/how-to-parse-json-in-java
    // TODO: In this this class we should have all the methods that deal with getting questions from JSON and returning them as strings
    // read json & parse json to Question objects & assign objects to list (above) & return filled List questionList

}
