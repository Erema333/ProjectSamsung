package com.example.projectsamsung.sprite;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class BoosSprite extends Sprite {
    int radius;
    float width;
    float height;
    int kolNag = 30;
    private final Paint paint = new Paint();
    public BoosSprite(float x, float y, float width,float height) {
        super(x, y);
        radius = (int) (300);
        this.width = width;
        this.height = height;
        paint.setColor(Color.BLACK);

    }
public void removeNag(){
    System.out.println(kolNag);
        kolNag--;
}
    public int getNag(){

        return kolNag;
    }
    @Override
    public boolean onTouchSprite(float touchX, float touchY) {
        if(((x < touchX&&x > touchX-300)||x > touchX&&x < touchX+300)
                &&((y < touchY&&y > touchY-300)||y > touchY&&y < touchY+300) ){

            return true;
        } return false;}

    @Override
    public void onDraw(Canvas canvas) {

        canvas.drawCircle(width/2,height/2,radius,paint);
    }
}

