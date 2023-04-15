package com.example.projectsamsung;

import static com.example.projectsamsung.GameView.CordX;
import static com.example.projectsamsung.GameView.CordY;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import static com.example.projectsamsung.SpriteLogic.x;
import static com.example.projectsamsung.SpriteLogic.y;
// Класс который рисует на холсте станции
public class SpriteDraw {
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
                path.moveTo(SpriteX, SpriteY);
                path.lineTo(SpriteX - 37, SpriteY - 80);
                path.lineTo(SpriteX - 80, SpriteY);
                path.lineTo(SpriteX, SpriteY);
                path.close();
                canvas.drawPath(path, paint);
                break;

        }
    }

}