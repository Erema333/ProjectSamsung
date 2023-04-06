package com.example.projectsamsung;

import static com.example.projectsamsung.GameActivity.getCordX;
import static com.example.projectsamsung.GameActivity.getCordY;
import static com.example.projectsamsung.GameActivity.updateGame;
import static com.example.projectsamsung.GameView.CordX;
import static com.example.projectsamsung.GameView.CordY;
import static com.example.projectsamsung.GameView.stations;

import android.app.SearchManager;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.google.android.material.slider.Slider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StationLogic {
    public static float x;
    public static float y;
    public enum Shape { // список всех фигур
        circle, triangle, square

    }


    public static Shape getRandomShape() {//TODO: метод возращающий рандомную фигуру из списка
        int a = (int) (Math.random() * 3) + 1;
        switch (a) {
            case 1:
                return Shape.circle;
            case 2:
                return Shape.square;
            case 3:
                return Shape.triangle;
        }
        return Shape.triangle;
    }
    public static boolean onTouchSprite(){
        for (StationDraw mas:GameView.stations) {
            if((mas.SpriteX < getCordX()+10||mas.SpriteX > getCordX()-10||mas.SpriteX == getCordX())&&(mas.SpriteY < getCordY()+10||mas.SpriteY > getCordY()-10||mas.SpriteY == getCordY())){
                stations.remove(mas);
                updateGame();
                return true;
            }
        }
        return false;
    }

   /* public static void CordTest(){
        int g = 0;
        while (g != -5) {
            g = 0;
            y = (float) (Math.random() * (2000 - 30) + 30);

            x = (float) (Math.random() * (1000 - 30) + 30);
            Collections.sort(CordY);
            Collections.sort(CordX);

            //==========================================
            for (int i = 0; i < CordY.size(); i++) {
                if (CordY.get(i) != null) {
                    if ((((float) CordY.get(i)+ 40 > y ) || ((float) CordY.get(i)- 40 < y ))||
                            (((float) CordX.get(i)+ 40 > x ) || ((float) CordX.get(i)- 40 < x ))) {
                        g++;h
                        System.out.println(x + " "+ y);

                    } else break;
                }
            }
            //===========================================
            if (g == CordY.size()) {
                g = -5;

                CordY.add(y);
                CordX.add(x);
            }
        }



    }*/


}
