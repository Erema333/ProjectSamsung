package com.example.projectsamsung.sprite;

public class SpriteVanish {
    int iter;
    Sprite sprite;

    public SpriteVanish(Sprite sprite) {
        this.sprite = sprite;
    }
    public void addIter(){
        iter++;
    }
    public int getIter(){
        return iter;
    }
    public Sprite getSprite(){
        return sprite;
    }
}
