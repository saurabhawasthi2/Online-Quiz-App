package com.example.quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    /**
     * Conducts the quiz interactively and returns the Result.
     * Improves input handling to avoid crashing on non-integer input.
     */
    public Result conductQuiz() {
        Scanner scanner = new Scanner(System.in);
        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            int answer = -1;
            while (true) {
                System.out.print("Your answer (1-" + options.size() + "): ");
                String line = scanner.nextLine();
                try {
                    answer = Integer.parseInt(line.trim());
                    if (answer >= 1 && answer <= options.size()) {
                        break;
                    } else {
                        System.out.println("Please enter a number between 1 and " + options.size() + ".");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }

            if (question.isCorrectAnswer(answer - 1)) {
                score++;
            }
        }
        // Do not close System.in scanner to avoid closing the underlying stream for callers
        return new Result(score);
    }

    public int getScore() {
        return score;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public int getTotalQuestions() {
        return questions.size();
    }
}