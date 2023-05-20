package com.example.projectsamsung.sprite;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import static com.example.projectsamsung.GameView.info;
import com.example.projectsamsung.GameView;

public class BoosSprite extends Sprite {
    int radius;
    float width;
    float height;
     int t;
     GameView view;
    int kolNag = 30;
    private final Paint paint = new Paint();
    class Timer extends Thread{
        @Override
        public void run() {
            t--;
            info.addTimeBoss(t);
            System.out.println(info.getTimeBoss());
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                if(t == 0)view.missBoss();
            }
        }
    }
    public BoosSprite(float x, float y, float width, float height, int t, GameView gameView) {
        super(x, y);
        radius = (int) (300);
        this.width = width;
        this.height = height;
        this.t = t;
        view = gameView;
        paint.setColor(Color.BLACK);
Timer th = new Timer();
th.start();
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

