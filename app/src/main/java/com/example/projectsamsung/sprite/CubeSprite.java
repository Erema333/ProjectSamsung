package com.example.projectsamsung.sprite;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class CubeSprite extends Sprite {
    private final float halfWidth;
    private final Paint paint = new Paint();

    public CubeSprite(float x, float y, float width) {
        super(x, y);
        halfWidth = width / 2;
        paint.setColor(Color.BLACK);
    }

    @Override
    public boolean onTouchSprite(float touchX, float touchY) {
        if(((x < touchX&&x > touchX-50)||x > touchX&&x < touchX+50)
                &&((y < touchY&&y > touchY-50)||y > touchY&&y < touchY+50) ){

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
