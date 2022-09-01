package entity;

import java.util.ArrayList;

public class Question {
    private String question;

    private String answer;

    private ArrayList<String> arrayAnswer = new ArrayList<>();

    public String getQuestion() {
        return question;
    }

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
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

    public ArrayList<String> getArrayAnswer() {
        return arrayAnswer;
    }

    public void setArrayAnswer(ArrayList<String> arrayAnswer) {
        this.arrayAnswer = arrayAnswer;
    }
}
