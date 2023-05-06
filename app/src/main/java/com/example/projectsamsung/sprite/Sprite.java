package com.example.projectsamsung.sprite;

import android.graphics.Canvas;

public abstract class Sprite {

    protected final float x, y;

    protected Sprite(float x, float y) {
        this.x = x;
        this.y = y;

    }

    public abstract boolean onTouchSprite(float touchX, float touchY);

    public abstract void onDraw(Canvas canvas);
}
