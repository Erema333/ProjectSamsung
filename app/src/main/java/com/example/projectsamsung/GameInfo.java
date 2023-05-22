package com.example.projectsamsung;

import com.example.projectsamsung.Activitys.GameActivity;

public class GameInfo implements GameInfoListener  {
    private int score = 0;
    private int missingSprite = 0;
    int BoosT = -1;
    boolean BoosMode = false;
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
        this.BoosT = score;
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
    public  void  invisibleView(GameActivity activity){
        activity.invisible();
    }
    public  void  visibleView(GameActivity activity){
activity.visible();
    }
}
