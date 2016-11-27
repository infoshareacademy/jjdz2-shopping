package com.jars.shopping.Statistics;

/**
 * Created by pwieczorek on 27.11.16.
 */
public class NewStatisticUpdateEvent {

    final private String username;
    final private String question;
    final private String answer;

    public NewStatisticUpdateEvent(String username, String question, String answer) {
        this.username = username;
        this.question = question;
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getUsername() {
        return username;
    }
}
