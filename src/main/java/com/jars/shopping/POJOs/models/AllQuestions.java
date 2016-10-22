package com.jars.shopping.POJOs.models;

import java.util.ArrayList;
import java.util.List;

public class AllQuestions {
    private List<Question> questions= new ArrayList<Question>();

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
