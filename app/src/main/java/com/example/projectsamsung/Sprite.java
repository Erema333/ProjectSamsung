package com.example.projectsamsung;

import android.graphics.Canvas;
import android.graphics.Canvas;

    public abstract class Sprite {
        public float x, y;

        public abstract void init(int height, int width);

        public abstract void onDraw(Canvas canvas);

        public void onTouch(float x, float y, int screenHeight, int screenWidth) { }
        public void update(int screenHeight, int screenWidth) { }
    }

