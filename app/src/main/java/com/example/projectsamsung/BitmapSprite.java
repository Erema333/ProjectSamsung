package com.example.projectsamsung;

import static com.example.projectsamsung.SpriteLogic.x;
import static com.example.projectsamsung.SpriteLogic.y;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

public class BitmapSprite extends SpriteDraw {

    private Paint paint;
    Bitmap bitmapSource;
    Bitmap  dyse;
    Matrix matrix;

    public BitmapSprite(Context context, SpriteLogic.Shape shape) {
        super(shape);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        bitmapSource = BitmapFactory.decodeResource(context.getResources(), R.drawable.dyyyyyyse);

        matrix = new Matrix();
        matrix.postScale(10, 15);
        matrix.postRotate(45);

        dyse = Bitmap.createBitmap(bitmapSource, 0, 0, bitmapSource.getWidth()/2, bitmapSource.getHeight()/2, matrix, true);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (SpriteX == null && SpriteY == null) {
            SpriteX = (float) (Math.random() * 700) + 300;
            SpriteY = (float) (Math.random() * 1700) + 300;
            x = SpriteX;
            y = SpriteY;
        }

        canvas.drawBitmap(dyse, (int) (x), (int) (y), paint);
    }
}
