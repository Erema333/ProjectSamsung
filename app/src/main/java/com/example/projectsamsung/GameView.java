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
    static ArrayList CordX = new ArrayList();
    static ArrayList CordY = new ArrayList();


    public GameView(Context context, @Nullable AttributeSet attrs) {  // TODO: конструктор при вызови кторого добовляется станция
        super(context, attrs);
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
