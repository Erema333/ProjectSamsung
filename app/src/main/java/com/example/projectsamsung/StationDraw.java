package com.example.projectsamsung;

import static com.example.projectsamsung.StationLogic.Shape.square;

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
    int l = 0;
    public StationLogic.Shape shape; // фигура станции
ArrayList CordX = new ArrayList();
    ArrayList CordY = new ArrayList();


    private final Paint paint = new Paint();

    public StationDraw(StationLogic.Shape shape) { // конструктор
        this.shape = shape;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.BLACK);
    }



    public void onDraw(Canvas canvas) {  //todo: Рисует станции
        if(x == null){
            x = (float) (Math.random() * (canvas.getWidth() - RADIUS) + RADIUS);
            CordX.add(x);
            Collections.sort(CordX);

           
        }
        if(y == null){
            y = (float) (Math.random() * (canvas.getWidth() - RADIUS) + RADIUS);
            CordY.add(y);
            Collections.sort(CordX);


            }



        switch (shape) { // выбор рисования станции в зависимости от фигуры
            case square:
                canvas.drawRect(x - RADIUS-10, y - RADIUS-10, x + RADIUS-10, y + RADIUS-10, paint);
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
