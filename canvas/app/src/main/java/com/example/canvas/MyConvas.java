package com.example.canvas;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyConvas extends View {
    Paint paint;
    Path path;


    public MyConvas(Context context, AttributeSet attr) {
        super(context, attr);

        paint = new Paint();
        path = new Path();
        paint.setAntiAlias(true);
        paint.setColor(Color.MAGENTA);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5f);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float xpos = event.getX();
        float ypos = event.getY();

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                path.moveTo(xpos,ypos);
                return true;

            case MotionEvent.ACTION_MOVE:
                path.lineTo(xpos,ypos);
                break;

            case MotionEvent.ACTION_UP:
                break;

            default:
                return false;
        }
        invalidate();
        return true;

    }
}