package com.jars.shopping.POJOs.models;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Created by nlisova on 18.09.16.
 */
public class Questionary  {
    List<Question> questions;

    public List<Question> getQuestions() {

        ObjectMapper mapper = new ObjectMapper();
        try {
            Question obj = mapper.readValue(new File("C:\\Users\\Natalka\\IdeaProjects\\shopping\\jjdz2-shopping\\src\\main\\Questionsjson\\Questionsjson.json"), Question.class);
            questions.add(obj);
        }
        catch(IOException e){

        }

        return questions;
    }



    //JSON from file to Object




}