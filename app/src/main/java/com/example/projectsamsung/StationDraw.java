package com.example.projectsamsung;

import static com.example.projectsamsung.GameView.CordX;
import static com.example.projectsamsung.GameView.CordY;

import static com.example.projectsamsung.StationLogic.Shape.square;
import static com.example.projectsamsung.StationLogic.num;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

import java.util.ArrayList;
import java.util.Collections;


// Класс который рисует на холсте станции
public class StationDraw {
    private final static float RADIUS = 30; // размер станции
    public int level = 0;// уровень станции
    public Float x;
    public Float y;
    public StationLogic.Shape shape; // фигура станции


    private final Paint paint = new Paint();

    public StationDraw(StationLogic.Shape shape) { // конструктор
        this.shape = shape;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.BLACK);
    }


    public void onDraw(Canvas canvas) {  //todo: Рисует станции
        if(x == null && y == null){


x = (float) CordX[num];
y = (float) CordY[num];
num++;

        }




        switch (shape) { // выбор рисования станции в зависимости от фигуры
            case square:
                canvas.drawRect(x - RADIUS-15, y - RADIUS-15, x + RADIUS-15, y + RADIUS-15, paint);
                break;
            case circle:
                canvas.drawCircle(x, y, RADIUS, paint);
                break;
            case triangle:
                Path path = new Path();
                path.moveTo(x, y);
                path.lineTo(x - 50, y + 100);
                path.lineTo(x - 100, y);
                path.lineTo(x, y);
                path.close();
                canvas.drawPath(path, paint);
                break;

        }
    }

}
