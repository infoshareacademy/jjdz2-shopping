package com.jars.shopping.POJOs.models;

import com.sun.tools.javac.util.List;

public class Question {

    private int id;
    private String title;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    List<Option> options;

}