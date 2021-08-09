package com.example.drawingapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class LineView extends View
{
    private Paint paint = new Paint();

    private PointF pointX, pointY;

    public LineView(Context context) {
        super(context);
    }

    public LineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        paint.setColor(Color.RED);

        paint.setStrokeWidth(20);

        canvas.drawLine(pointX.x, pointX.y, pointY.x, pointY.y,paint);

        super.onDraw(canvas);
    }

    public void setPointX(PointF point)
    {
        pointX = point ;
    }

    public void setPointY(PointF point)
    {
        pointY = point ;
    }

    public void draw()
    {
        invalidate();
        requestLayout();
    }
}