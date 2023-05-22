package com.example.projectsamsung.sprite;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class CubeSprite extends Sprite {
    private float halfWidth;
    private final Paint paint = new Paint();
    int iter;
    float xCenter = x-halfWidth;
    float yCenter = y-halfWidth;
    public void addIter(){
        iter++;
    }
    public int getIter(){
        return iter;
    }
    public CubeSprite(float x, float y, float width) {
        super(x, y);
        halfWidth = width / 25000;
        paint.setColor(Color.BLACK);
    }

    @Override
    public boolean onTouchSprite(float touchX, float touchY) {
        if(((xCenter < touchX&&xCenter > touchX-halfWidth)||xCenter > touchX&&xCenter < touchX+halfWidth)
                &&((yCenter < touchY&&yCenter > touchY-halfWidth)||yCenter > touchY&&yCenter < touchY+halfWidth) ){

                return true;
            } return false;}


    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawRect(
                x - halfWidth,
                y - halfWidth,
                x + halfWidth,
                y + halfWidth,
                paint
        );
    }
}
