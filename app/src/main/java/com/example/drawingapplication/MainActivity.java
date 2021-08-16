package com.example.drawingapplication;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<LineModel> lines;
    private com.example.drawingapplication.DrawView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        int transparentColor = 0xCC000000;

        drawView = findViewById(R.id.view);
        drawView.setBackgroundColor(transparentColor);
        drawView.setBackground(getResources().getDrawable(R.drawable.ic_launcher_background));

        lines = new ArrayList();

        lines.add(new LineModel(0, 0, 200, 200));
        lines.add(new LineModel(200, 0, 0, 200));
        lines.add(new LineModel(0, 200, 200, 400));
        lines.add(new LineModel(200, 200, 0, 400));
        lines.add(new LineModel(0, 400, 200, 600));
        lines.add(new LineModel(200, 400, 0, 600));

        drawView.DrawLine(lines);
    }
}