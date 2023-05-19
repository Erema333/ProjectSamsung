package com.example.projectsamsung;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.projectsamsung.databinding.GameViewBinding;
import com.example.projectsamsung.sprite.BoosSprite;
import com.example.projectsamsung.sprite.CircleSprite;
import com.example.projectsamsung.sprite.CubeSprite;
import com.example.projectsamsung.sprite.DyseSprite;
import com.example.projectsamsung.sprite.Sprite;


import java.util.ArrayList;


public class GameView extends View {
    private boolean BOOSFIGHT = false;
    public static GameInfo info = new GameInfo();
    private final ArrayList<Sprite> sprites = new ArrayList<>(); // массив со всеми спрайтами

    private Thread generateSprite; // TODO: перенести на таймер обратного отсчёта

    // конструктор при вызове которого добавляется станция
    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void onResume() {
        generateSprite = new GenerateSpriteThread();
        generateSprite.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();
if(!BOOSFIGHT) {
    final ArrayList<Sprite> removeSprites = new ArrayList<>();

    for (Sprite sprite : sprites) {
        if (sprite.onTouchSprite(touchX, touchY)) {
            removeSprites.add(sprite);
            info.addScore(1);
        }
    }

    sprites.removeAll(removeSprites);
    if (removeSprites.size() > 0) invalidate();

    return true;
}else {
    BoosSprite boos = (BoosSprite) (sprites.get(0));
    System.out.println(boos.onTouchSprite(touchX, touchY));
    if (boos.onTouchSprite(touchX, touchY)) {
        boos.removeNag();
    }
        if(boos.getNag() <= 0) {
            BOOSFIGHT = false;
            sprites.remove(boos);
            info.addScore(10);
            invalidate();

    }
    }
        return true;
    }


    // переопределение метода onDraw. рисует все станции из массива
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        for (Sprite sprite : sprites) {
            sprite.onDraw(canvas);
        }
    }

    public void onStop() {
        generateSprite.interrupt();
        try {
            generateSprite.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void addSprite() {
        float x = (float) (Math.random() * getWidth());
        float y = (float) (Math.random() * getHeight());
        int random = (int) (Math.random() * 3);
        if(info.getKolSprites() % 15 == 0 && info.getKolSprites() != 0){
            BOOSFIGHT = true;
            sprites.clear();

            sprites.add(new BoosSprite(getWidth()/2,getHeight()/2,getWidth(),getHeight()));
        }else{
            for (Sprite spr: sprites) {
                spr.addIter();
            }
        switch (random) {
            case 0:
                sprites.add(new DyseSprite((int) (Math.random() * getWidth()),(int)(Math.random() * getHeight()),GameView.this, getWidth(), getHeight()));
                //sprites.add(new CubeSprite(x, y, getWidth()*getHeight()));
                break;
            case 1:
                sprites.add(new DyseSprite((int) (Math.random() * getWidth()),(int)(Math.random() * getHeight()),GameView.this, getWidth(), getHeight()));

                break;
            case 2:
                sprites.add(new DyseSprite((int) (Math.random() * getWidth()),(int)(Math.random() * getHeight()),GameView.this, getWidth(), getHeight()));
               // sprites.add(new CircleSprite(x,y,getWidth()*getHeight()));
                break;
        }}
        info.addKolSprites(1);
        invalidate();
    }


private void MissSprites(){
     final ArrayList<Sprite> missingSprites = new ArrayList<>(); // массив со всеми спрайтами

    for (Sprite spr: sprites) {
        spr.addIter();
        if(spr.getIter() >= 5){
            missingSprites.add(spr);
            info.addMissingSprite(1);
            if(info.getMissingSprite() >= 3)getOnGameOver();
        }
    }
    sprites.removeAll(missingSprites);


    }

    private void getOnGameOver() {

    }


    private class GenerateSpriteThread extends Thread {

        int Time = 1500;
        int iterT = 0;
        @Override
        public void run() {

            try {
                while (!isInterrupted()) {

                    Thread.sleep(Time);
                    if (!BOOSFIGHT) {
                        if (iterT == 2 && Time >= 200) {
                            iterT = 0;
                            Time -= 20;
                            System.out.println(Time);
                        }
                        GameView.this.getHandler().post(GameView.this::addSprite);
                        iterT++;

                        MissSprites();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }}}

