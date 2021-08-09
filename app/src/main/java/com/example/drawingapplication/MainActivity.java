package com.example.drawingapplication;

import android.graphics.PointF;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private LineView mLineView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mLineView = findViewById(R.id.lineView);

        PointF pointA = new PointF(100, 500);
        PointF pointB = new PointF(500, 500);

        mLineView.setPointX(pointA);

        mLineView.setPointY(pointB);

        mLineView.draw();

    }
}