package com.example.quiz;

public class QuizApp {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        // Sample questions (using convenience constructor that accepts the correct answer string)
        quiz.addQuestion(new Question("What is the capital of France?",
                new String[]{"Berlin", "Madrid", "Paris", "Rome"}, "Paris"));
        quiz.addQuestion(new Question("Which planet is known as the Red Planet?",
                new String[]{"Earth", "Mars", "Jupiter", "Saturn"}, "Mars"));
        quiz.addQuestion(new Question("What is the largest ocean on Earth?",
                new String[]{"Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean"}, "Pacific Ocean"));

        // Conduct the quiz
        Result result = quiz.conductQuiz();

        // Display the results
        System.out.println("Your score: " + result.getScore() + "/" + quiz.getTotalQuestions());
    }
}