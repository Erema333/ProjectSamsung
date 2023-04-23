package com.example.projectsamsung;

import static com.example.projectsamsung.GameView.CordX;
import static com.example.projectsamsung.GameView.CordY;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import static com.example.projectsamsung.SpriteLogic.x;
import static com.example.projectsamsung.SpriteLogic.y;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
// Класс который рисует на холсте станции
//====================================================================================
public class SpriteDraw {
    public static class Drawdyse extends View {

        Paint paint;
        Bitmap bitmapSource;
        static Bitmap  dyse;
        Matrix matrix;

        public Drawdyse(Context context) {
            super(context);
            paint = new Paint(Paint.ANTI_ALIAS_FLAG);

            bitmapSource = BitmapFactory.decodeResource(getResources(), R.drawable.dyyyyyyse);

            matrix = new Matrix();
            matrix.postScale(10, 15);
            matrix.postRotate(45);

            dyse = Bitmap.createBitmap(bitmapSource, 0, 0, bitmapSource.getWidth()/2, bitmapSource.getHeight()/2, matrix, true);

        }}
        //=============================================================================================
    private final static float RADIUS = 30; // размер станции
    public int level = 0;// уровень станции
    public  Float SpriteX;
    public  Float SpriteY;


    public SpriteLogic.Shape shape; // фигура станции


    private final Paint paint = new Paint();
    Path path = new Path();

    public SpriteDraw(SpriteLogic.Shape shape) { // конструктор
        this.shape = shape;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.BLACK);

    }


    public void onDraw(Canvas canvas) {  //todo: Рисует станции

        if(SpriteX == null && SpriteY == null){


            SpriteX = (float)(Math.random()*700)+300;
            SpriteY = (float)(Math.random()*1700)+300;
            x = SpriteX;
            y = SpriteY;

        }




        switch (shape) { // выбор рисования станции в зависимости от фигуры
            case Yna:
                canvas.drawRect(SpriteX - RADIUS-15, SpriteY - RADIUS-15, SpriteX + RADIUS-15, SpriteY + RADIUS-15, paint);
                break;
            case Heh:
                canvas.drawCircle(SpriteX, SpriteY, RADIUS, paint);
                break;
            case Masha:

                 if(Drawdyse.dyse != null)   canvas.drawBitmap(Drawdyse.dyse, (int) (x), (int) (y), paint);
                 else {
                     paint.setColor(Color.RED);
                     canvas.drawRect(SpriteX - RADIUS-15, SpriteY - RADIUS-15, SpriteX + RADIUS-15, SpriteY + RADIUS-15, paint);
                     break;
                 }
                 }


        }
    }


