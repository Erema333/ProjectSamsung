package com.example.projectsamsung.sprite;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class CircleSprite extends Sprite{
    int radius;
    private final Paint paint = new Paint();
    int iter;
    public void addIter(){
        iter++;
    }
    public int getIter(){
        return iter;
    }
    public CircleSprite(float x, float y, float width) {
        super(x, y);
        radius = (int) (width / 25000);
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

        canvas.drawCircle(x,y,radius,paint);
    }
}
