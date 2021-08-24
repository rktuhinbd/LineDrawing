package com.example.drawingapplication.activity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.drawingapplication.R;
import com.example.drawingapplication.model.DrawingModel;
import com.example.drawingapplication.model.LineModel;
import com.example.drawingapplication.model.Plot;
import com.example.drawingapplication.utils.DrawView;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View {

    // = = = Declare View Properties = = = //

    private FrameLayout view;
    private DrawView drawView;

    // = = = Declare Data Properties = = = //

    private Presenter presenter;

    private List<Plot> plotList = new ArrayList();
    private List<LineModel> lineList = new ArrayList();

    int scaleX;
    int scaleY;

    int startX;
    int startY;
    int endX;
    int endY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // = = = Init view properties = = = //

        view = findViewById(R.id.view);

        drawView = new DrawView(this);

        presenter = new Presenter(this, this);


        // = = = Getting display measurement = = = //

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;


        // = = = Setting display plots = = = //

        scaleX = width / 800;
        scaleY = height / 600;


        // = = = Api call using presenter to get drawing plots = = = //

        presenter.getDrawingLines();

    }

    @Override
    public void onGetDrawingList(DrawingModel result) {
//        Log.e("API Data", new GsonBuilder().setPrettyPrinting().create().toJson(result));

        plotList = result.getData().get(0).getPlots();

        for (int i = 1; i < plotList.size(); i++) {
            startX = plotList.get(i - 1).getX() * scaleX;
            startY = plotList.get(i - 1).getY() * scaleY;
            endX = plotList.get(i).getX() * scaleX;
            endY = plotList.get(i).getY() * scaleY;
            lineList.add(new LineModel(startX, startY, endX, endY));
        }

        //Log.e("Plot List", new GsonBuilder().setPrettyPrinting().create().toJson(lineList));

        view.addView(drawView);
        drawView.DrawLine(lineList);

    }
}
