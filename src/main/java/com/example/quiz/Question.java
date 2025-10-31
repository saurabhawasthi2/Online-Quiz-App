package com.example.quiz;

import java.util.Arrays;
import java.util.List;

public class Question {
    private String questionText;
    private List<String> options;
    private int correctAnswerIndex;

    public Question(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = Arrays.asList(options);
        this.correctAnswerIndex = correctAnswerIndex;
    }

    /**
     * Convenience constructor that accepts the correct answer as a String.
     * The match is case-insensitive and trims surrounding whitespace.
     * @throws IllegalArgumentException if the provided correct answer is not found in the options
     */
    public Question(String questionText, String[] options, String correctAnswer) {
        if (correctAnswer == null) {
            throw new IllegalArgumentException("correctAnswer cannot be null");
        }
        this.questionText = questionText;
        this.options = Arrays.asList(options);

        String target = correctAnswer.trim();
        int idx = -1;
        for (int i = 0; i < this.options.size(); i++) {
            if (this.options.get(i).equalsIgnoreCase(target)) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            throw new IllegalArgumentException("Correct answer '" + correctAnswer + "' not found in options");
        }
        this.correctAnswerIndex = idx;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public boolean isCorrectAnswer(int answerIndex) {
        return answerIndex == correctAnswerIndex;
    }
}