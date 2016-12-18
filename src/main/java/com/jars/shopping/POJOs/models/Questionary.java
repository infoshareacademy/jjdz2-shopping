package com.jars.shopping.POJOs.models;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ejb.Stateless;

@Stateless
public class Questionary  {


    public List<Question> getQuestions() {

        ObjectMapper mapper = new ObjectMapper();


        try {
            URL resource = getClass().getClassLoader().getResource("Questionsjson.json");

            AllQuestions questions = mapper.readValue(resource, AllQuestions.class);
            return questions.getQuestions();

        } catch(IOException e){
            e.printStackTrace();
        }

       return Collections.emptyList();
    }



    //JSON from file to Object




}