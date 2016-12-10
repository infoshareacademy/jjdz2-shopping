package com.jars.shopping.Statistics;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by pwieczorek on 20.11.16.
 */
@Entity
public class Statistic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String username;
    private String question;
    private String answer;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Statistic() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }


}
