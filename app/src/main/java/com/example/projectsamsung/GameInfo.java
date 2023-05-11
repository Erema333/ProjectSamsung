package com.example.projectsamsung;

public class GameInfo {
    private int score = 0;
    private int missingSprite = 0;
    private int timeInSecond;

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }
    public int getMissingSprite() {
        return missingSprite;
    }
    public void addMissingSprite(int missingSprite) {
        this.missingSprite += missingSprite;
    }
    public int getTimeInSecond() {
        return timeInSecond;
    }

    public void setTimeInSecond(int timeInSecond) {
        this.timeInSecond = timeInSecond;
    }
}
