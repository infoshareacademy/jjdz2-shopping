package com.jars.shopping.POJOs.models;

import java.io.File;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Created by nlisova on 18.09.16.
 */
public class Questionary {
    List<Question> qestions;

    public List<Question> getQuestions() {

        return qestions;
    }

    ObjectMapper mapper = new ObjectMapper();
    String jsonInString = "{'name' : 'mkyong'}";

    //JSON from file to Object
    Staff obj = mapper.readValue(new File("c:\\file.json"), Staff.class);

    //JSON from URL to Object
    Staff obj = mapper.readValue(new URL("http://mkyong.com/api/staff.json"), Staff.class);

    //JSON from String to Object
    Staff obj = mapper.readValue(jsonInString, Staff.class);

}