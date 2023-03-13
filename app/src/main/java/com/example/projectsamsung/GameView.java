package com.example.projectsamsung;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class GameView extends View {
    private ArrayList<StationDraw> stations = new ArrayList<>();

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        addTests();
    }

    private void addTests() {
        for (int i = 0; i < 10; i++) {
            stations.add(new StationDraw(StationLogic.getRandomShape()));
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (StationDraw station : stations) {
            station.onDraw(canvas);
        }
    }
}
