package com.example.drawingapplication.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;

import com.example.drawingapplication.model.LineModel;

import java.util.ArrayList;
import java.util.List;

public class DrawView extends androidx.appcompat.widget.AppCompatImageView {

    Paint paint = new Paint();

    List<LineModel> lines = new ArrayList<>();

    float startX;
    float startY;
    float endX;
    float endY;

    private void init() {
        paint.setColor(Color.RED);
        paint.setStrokeWidth(10);
    }

    public DrawView(Context context) {
        super(context);
        init();
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    @Override
    public void onDraw(Canvas canvas) {

        for (int i = 0; i < lines.size(); i++) {
            startX = lines.get(i).getStartX();
            startY = lines.get(i).getStartY();
            endX = lines.get(i).getEndX();
            endY = lines.get(i).getEndY();

            canvas.drawLine(startX, startY, endX, endY, paint);

            Log.e("Lines drawn", "" + i);
        }
    }

    public void DrawLine(List<LineModel> lines) {
        this.lines = lines;
    }

}