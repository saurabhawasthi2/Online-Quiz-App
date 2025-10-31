package com.example.quiz;

public class Result {
    private int score;

    public Result(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void displayResult() {
        System.out.println("Your score: " + score);
    }
}