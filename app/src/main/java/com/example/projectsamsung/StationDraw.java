package com.example.projectsamsung;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RenderNode;
import android.view.View;

public class StationDraw extends View {
    public int level = 0;
    public float x ;
    public float y;
    static boolean  repeat = false;
public static StationLogic.Shape shape;
    private Paint paint = new Paint();
    public StationDraw(Context context) {
        super(context);

    }

    public static void DrawStation(StationLogic.Shape shapes){
shape = shapes;
repeat = true;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        x = (float) (Math.random() * ((1000 - 30) + 1)) + 30;
        y = (float) (Math.random() * ((2000 - 30) + 1)) + 30;
        // стиль Заливка
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.BLACK);

        if(repeat){switch (shape) {
            case square:
                canvas.drawRect((float) 40, (float) 40, (float) 100, (float) 100, paint);
                break;
            case circle:
                canvas.drawCircle(x, y, 40, paint);
                break;
            case triangle:
                Path path = new Path();
                path.moveTo(x, y);
                path.lineTo(x - 50, y + 100);
                path.lineTo(x - 100, y);
                path.lineTo(x, y);
                path.close();
                canvas.drawPath(path, paint);
        }

        }
    }

}
