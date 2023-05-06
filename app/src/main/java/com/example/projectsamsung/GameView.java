package com.example.projectsamsung;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;


public class GameView extends View {
    public static ArrayList<BitmapSprite> sprites = new ArrayList<>(); // массив со всеми станциями
    static int[] CordX = {500, 700, 386, 458, 567, 300, 342, 740, 800, 200, 253, 300, 635, 543, 800};
    static int[] CordY = {1800, 800, 200, 563, 348, 1000, 1254, 638, 1300, 1600, 400, 700, 1500, 1550, 1123};


    public GameView(Context context, @Nullable AttributeSet attrs) {  // TODO: конструктор при вызови кторого добовляется станция
        super(context, attrs);
        sprites.add(new BitmapSprite(getContext()));


    }


    public void removeStation() {

    }




    @Override // TODO: переопределение метода onDraw. рисует все станции из массива
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(-1);
        for (SpriteDraw station : sprites) {
            station.onDraw(canvas);
        }
    }
}