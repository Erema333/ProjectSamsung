package com.example.projectsamsung;

import android.content.Context;
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
import com.example.projectsamsung.sprite.Sprite;
import com.example.projectsamsung.sprite.SpriteVanish;

import java.util.ArrayList;


public class GameView extends View {
    private GameViewBinding binding;
    private boolean BOOSFIGHT = false;
    public static GameInfo info = new GameInfo();
    private final ArrayList<Sprite> sprites = new ArrayList<>(); // массив со всеми станциями
    final ArrayList<SpriteVanish> spriteVan = new ArrayList<>();
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
if(BOOSFIGHT == false) {
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
        int random = (int) (Math.random() * 2);
        if(info.getKolSprites() == 10 || info.getKolSprites() == 10){
            BOOSFIGHT = true;
            sprites.clear();
            sprites.add(new BoosSprite(getWidth()/2,getHeight()/2,getWidth(),getHeight()));
        }else{
        switch (random) {
            case 0:
                sprites.add(new CubeSprite(x, y, getWidth()*getHeight()));
                spriteVan.add(new SpriteVanish(sprites.get(sprites.size()-1)));
                break;
            case 1:
                sprites.add(new CircleSprite(x,y,getWidth()*getHeight()));
                spriteVan.add(new SpriteVanish(sprites.get(sprites.size()-1)));
                break;
        }}
        info.addKolSprites(1);
        invalidate();
    }


private void MissSprites(){
    for (SpriteVanish spr: spriteVan) {

         if(spr.getIter() >= 2){
            sprites.remove(spr.getSprite());
            spriteVan.remove(spr);
            invalidate();
        }
    }
}
    private class GenerateSpriteThread extends Thread {

        int Time = 1500;
        int iterT = 0;
        @Override
        public void run() {

            try {
                while (!isInterrupted()) {

                    Thread.sleep(Time);
                    if(BOOSFIGHT == false){
                    if(iterT == 5 && Time >= 300)iterT =0;Time-=10;
                    GameView.this.getHandler().post(GameView.this::addSprite);
                    iterT++;
                    /*for (SpriteVanish spr: spriteVan) {
                        spr.addIter();

                    }
                    MissSprites();*/
                }}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}