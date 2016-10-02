package com.jars.shopping.POJOs.models;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;


public class Questionary  {


    public List<Question> getQuestions() {

        ObjectMapper mapper = new ObjectMapper();


        try {
            URL resource = getClass().getClassLoader().getResource("Questionsjson.json");
            File src = new File(resource.toURI());

            AllQuestions questions = mapper.readValue(src, AllQuestions.class);
            return questions.getQuestions();

        }
        catch(IOException e){

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

       return Collections.emptyList();
    }



    //JSON from file to Object




}