package com.example.drawingapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class DrawView extends androidx.appcompat.widget.AppCompatImageView {

    Paint paint = new Paint();

    ArrayList<LineModel> lineArrayList = new ArrayList<>();

    float startX;
    float startY;
    float endX;
    float endY;

    private void init() {
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
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
        for (int i = 0; i < lineArrayList.size(); i++) {
            startX = lineArrayList.get(i).getStartX();
            startY = lineArrayList.get(i).getStartY();
            endX = lineArrayList.get(i).getEndX();
            endY = lineArrayList.get(i).getEndY();

            canvas.drawLine(startX, startY, endX, endY, paint);

            Log.e("Lines drawn", "" + i);
        }
    }

    public void DrawLine(ArrayList<LineModel> lineArrayList) {
        this.lineArrayList = lineArrayList;
    }

}