package com.jars.shopping;


public class Question {
    private int questionId;
    private String qContent;

    public Question(int questionId, String qContent) {
        this.questionId = questionId;
        this.qContent = qContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (questionId != question.questionId) return false;
        return qContent != null ? qContent.equals(question.qContent) : question.qContent == null;

    }

    @Override
    public int hashCode() {
        int result = questionId;
        result = 31 * result + (qContent != null ? qContent.hashCode() : 0);
        return result;
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
}
