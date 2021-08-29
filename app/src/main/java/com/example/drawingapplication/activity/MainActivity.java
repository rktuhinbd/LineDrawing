package com.example.drawingapplication.activity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.drawingapplication.R;
import com.example.drawingapplication.model.DrawingModel;
import com.example.drawingapplication.model.PlotModel;
import com.example.drawingapplication.model.Plot;
import com.example.drawingapplication.utils.DrawView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View {

    // = = = Declare View Properties = = = //

    private FrameLayout view;
    private DrawView drawView;
    private FloatingActionButton fab;

    // = = = Declare Data Properties = = = //

    private Presenter presenter;

    private List<Plot> plotList = new ArrayList();
    private List<PlotModel> lineList = new ArrayList();

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

        fab = findViewById(R.id.fab);

        drawView = new DrawView(this);

        presenter = new Presenter(this, this);

        view.addView(drawView);

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

        fab.setOnClickListener(v -> {
            Log.e("Data refreshed", "Successful...");
            presenter.getDrawingLines();
        });

    }

    @Override
    public void onGetDrawingList(DrawingModel result) {
//        Log.e("API Data", new GsonBuilder().setPrettyPrinting().create().toJson(result));

        for (int i = 0; i < plotList.size(); i++) {
            plotList = result.getData().get(i).getPlots();

            if (!result.getData().get(i).getIsEraser()) {
                for (int j = 1; j < plotList.size(); j++) {
                    startX = plotList.get(j - 1).getX() * scaleX;
                    startY = plotList.get(j - 1).getY() * scaleY;
                    endX = plotList.get(j).getX() * scaleX;
                    endY = plotList.get(j).getY() * scaleY;
                    lineList.add(new PlotModel(startX, startY, endX, endY));
                }
                view.removeView(drawView);
                view.addView(drawView);
                drawView.DrawLine(false, result.getData().get(i).getColor(), lineList);
            } else {
                for (int j = 1; j < plotList.size(); j++) {
                    startX = plotList.get(j - 1).getX() * scaleX;
                    startY = plotList.get(j - 1).getY() * scaleY;
                    endX = plotList.get(j).getX() * scaleX;
                    endY = plotList.get(j).getY() * scaleY;
                    lineList.add(new PlotModel(startX, startY, endX, endY));
                }
                view.removeView(drawView);
                view.addView(drawView);
                drawView.DrawLine(true, "transparent", lineList);
            }
        }
    }
}
