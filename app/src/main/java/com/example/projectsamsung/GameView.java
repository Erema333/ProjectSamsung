package com.example.projectsamsung;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class GameView extends View {
    private static ArrayList<StationDraw> stations = new ArrayList<>(); // массив со всеми станциями
    static int[] CordX = {500, 700, 386,600,567,300,342,800,800,200,253,300,800,543,521};
    static int[] CordY = {1800, 800, 200,563,348,1000,1254,400,1300,1600,400,700,1500,1550,1123};



    public GameView(Context context, @Nullable AttributeSet attrs) {  // TODO: конструктор при вызови кторого добовляется станция
        super(context, attrs);
        addStation();
        addStation();


    }

    public static void addStation() { // TODO: метод дабовляющий станции

            stations.add(new StationDraw(StationLogic.getRandomShape()));
        }


    @Override // TODO: переосдресация метода onDraw. рисует все станции из массива
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (StationDraw station : stations) {
            station.onDraw(canvas);
        }
    }
}