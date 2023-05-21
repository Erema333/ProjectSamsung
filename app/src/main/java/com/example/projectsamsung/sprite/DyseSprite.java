package com.example.projectsamsung.sprite;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

import com.example.projectsamsung.GameView;
import com.example.projectsamsung.R;

public class DyseSprite extends Sprite {
    int iter = 0;

    private final Paint paint = new Paint();
    Matrix matrix = new Matrix();
    Bitmap bitmapSource;
    Bitmap bitmap;
    GameView view;
    int width, height;
    int x, y;
    Bitmap bitmap3;

    public void addIter() {
        iter++;
    }

    public int getIter() {
        return iter;
    }

    public DyseSprite(int x, int y, GameView view, int width, int height) {
        super(x, y);
        this.view = view;
        this.width = width;
        this.height = height;
        x = 500;
        y = 1000;

    }

    @Override
    public boolean onTouchSprite(float touchX, float touchY) {
        if (((x < touchX && x > touchX - 50) || x > touchX && x < touchX + 50)
                && ((y < touchY && y > touchY - 50) || y > touchY && y < touchY + 50)) {

            return true;
        }
        return false;
    }


    @Override
    public void onDraw(Canvas canvas) {
        bitmap3 = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        bitmap3 = BitmapFactory.decodeResource(view.getResources(), R.drawable.dyyyyyyse);
        canvas.drawBitmap(bitmap3, 0, 0, paint);


    }
}
