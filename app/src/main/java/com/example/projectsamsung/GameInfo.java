package com.example.projectsamsung;

public class GameInfo implements GameInfoListener  {
    private int score = 0;
    private int missingSprite = 0;
    int BoosT;
    boolean BoosMode;
    private int timeInSecond;
    GameInfoListener callback;
private int kolSprites = 0;
    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }
    public int getKolSprites() {
        return kolSprites;
    }

    public void addBossMode(boolean boss) {
        BoosMode = boss;
    }
    public boolean getBossMode() {
        return BoosMode;
    }


    public void addTimeBoss(int score) {
        this.BoosT = BoosT;
    }
    public int getTimeBoss() {
        return BoosT;
    }
    public void addKolSprites(int kolSprites) {
        this.kolSprites += kolSprites;

    }
    public int getMissingSprite() {
        return missingSprite;
    }
    public void registerCallBack(GameInfoListener callback){
        this.callback = callback;
    }
    public void addMissingSprite(int missingSprite) {
        this.missingSprite += missingSprite;
    }


    @Override
    public void callingBack(GameActivity activty) {
        activty.changeActivity();
    }
}
