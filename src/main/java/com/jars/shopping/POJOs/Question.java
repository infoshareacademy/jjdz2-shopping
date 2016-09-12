package com.jars.shopping.POJOs;


public class Question {
    private int questionId;
    private String qContent;

    public Question(int questionId, String qContent) {
        this.questionId = questionId;
        this.qContent = qContent;
    }


    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getqContent() {
        return qContent;
    }

    public void setqContent(String qContent) {
        this.qContent = qContent;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", qContent='" + qContent + '\'' +
                '}';
    }
}
