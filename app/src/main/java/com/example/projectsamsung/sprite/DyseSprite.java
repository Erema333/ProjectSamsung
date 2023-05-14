package com.example.projectsamsung.sprite;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;

import com.example.projectsamsung.R;

public class DyseSprite extends Sprite{
int iter = 0;




    protected DyseSprite(float x, float y) {
        super(x, y);
    }

    @Override
    public boolean onTouchSprite(float touchX, float touchY) {
        if(((x < touchX&&x > touchX-50)||x > touchX&&x < touchX+50)
                &&((y < touchY&&y > touchY-50)||y > touchY&&y < touchY+50) ){

            return true;
        } return false;}

    @Override
    public void onDraw(Canvas canvas) {

    }
}
