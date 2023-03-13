package com.example.projectsamsung;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RenderNode;
import android.view.View;

import java.util.ArrayList;

public class StationDraw {
    private final static float RADIUS = 10f;
    public int level = 0;
    public float x;
    public float y;
    public StationLogic.Shape shape;

    private final Paint paint = new Paint();

    public StationDraw(StationLogic.Shape shape) {
        this.shape = shape;
        // стиль Заливка
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.BLACK);
    }

    public void onDraw(Canvas canvas) {
        x = (float) (Math.random() * (canvas.getWidth() - RADIUS) + RADIUS);
        y = (float) (Math.random() * (canvas.getHeight() - RADIUS) + RADIUS);

        switch (shape) {
            case square:
                canvas.drawRect(x - RADIUS, y - RADIUS, x + RADIUS, y + RADIUS, paint);
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
