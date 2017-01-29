package com.jars.shopping.POJOs.models;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class QuestionaryTest {

    @Test
    public void should_load_file(){
        Questionary questionary = new Questionary();
        List<Question> questions = questionary.getQuestions();
        assertNotNull(questions);
    }

}