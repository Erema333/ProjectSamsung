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
public void CordTestY(){
        int g = 0;
    while (g != -5) {
        g = 0;
        y = (float) (Math.random() * (2000 - 30) + 30);
        Collections.sort(CordY);
        //==========================================
        for (int i = 0; i < CordY.size(); i++) {
            if (CordY.get(i) != null) {
                if ((((float) CordY.get(i)) > y + 70) || ((float) CordY.get(i) < y - 70)) {
                    g++;

                } else break;
            }
        }
        //=======================================
        if (g == CordY.size()) g = -5;
        CordY.add(y);
    }


}
public void CordTestX(){
        int g = 0;
        while (g != -5) {
            g = 0;
            x = (float) (Math.random() * (1000 - 30) + 30);
            Collections.sort(CordX);
            //==========================================
            for (int i = 0; i < CordX.size(); i++) {
                if (CordX.get(i) != null) {
                    if ((((float) CordX.get(i)) > x + 70) || ((float) CordX.get(i) < x - 70)) {
                        g++;

                    } else break;
                }
            }
            //=======================================
            if (g == CordX.size()) g = -5;
            CordX.add(x);
        }


    }

    public void onDraw(Canvas canvas) {  //todo: Рисует станции
        if(x == null){
            CordTestX();

           
        }
        if(y == null){
            CordTestY();


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
