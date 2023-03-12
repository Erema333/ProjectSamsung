package com.example.projectsamsung;

import android.app.SearchManager;

import java.lang.reflect.Array;
import java.util.ArrayList;
import com.google.android.material.slider.Slider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StationLogic {
    public static ArrayList<Shape> passenger = new ArrayList<Shape>();
private int countP;

    public static enum Shape{
    circle, triangle, square
}



public static void addStation(){
    float a =(float)(Math.random()*((3-1)+1)+1);
    int b = (int) a;
    System.out.println(b);
    switch (b){
        case 1:
            StationDraw.DrawStation(Shape.circle);
            break;
        case 2:
            StationDraw.DrawStation(Shape.square);
            break;
        case 3:
            StationDraw.DrawStation(Shape.triangle);
            break;
    }
}


    }
