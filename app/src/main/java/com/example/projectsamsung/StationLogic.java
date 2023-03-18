package com.example.projectsamsung;

import android.app.SearchManager;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.google.android.material.slider.Slider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StationLogic {
    public enum Shape { // список всех фигур
        circle, triangle, square
    }


    public static Shape getRandomShape() {//TODO: метод возращающий рандомную фигуру из списка
        int a = (int) (Math.random() * 2) + 1;
        switch (a) {
            case 1:
                return Shape.circle;
            case 2:
                return Shape.square;
            default:
                return Shape.triangle;
        }
    }


}
