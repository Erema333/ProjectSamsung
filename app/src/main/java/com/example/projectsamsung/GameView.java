package com.example.projectsamsung;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.projectsamsung.sprite.CubeSprite;
import com.example.projectsamsung.sprite.Sprite;

import java.util.ArrayList;


public class GameView extends View {
    private final ArrayList<Sprite> sprites = new ArrayList<>(); // массив со всеми станциями
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

        final ArrayList<Sprite> removeSprites = new ArrayList<>();

        for (Sprite sprite : sprites) {
            if (sprite.onTouchSprite(touchX, touchY)) {
                removeSprites.add(sprite);
            }
        }

        sprites.removeAll(removeSprites);
        if(removeSprites.size() > 0) invalidate();

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
        switch (random) {
            case 0:
                sprites.add(new CubeSprite(x, y, 100f));
                break;
            case 1:
                sprites.add(new CubeSprite(x, y, 50f)); // TODO: заменить на не куб
                break;
        }
        invalidate();
    }


    private class GenerateSpriteThread extends Thread {
        @Override
        public void run() {

            try {
                while (!isInterrupted()) {
                    Thread.sleep(2000);
                    GameView.this.getHandler().post(GameView.this::addSprite);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}