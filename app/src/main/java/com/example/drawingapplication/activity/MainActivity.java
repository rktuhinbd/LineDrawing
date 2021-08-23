package com.example.drawingapplication.activity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

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

    private Presenter presenter;

    private List<Plot> plotList = new ArrayList();
    private List<LineModel> lineList = new ArrayList();
    private DrawView drawView;

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

        presenter = new Presenter(this, this);

        drawView = findViewById(R.id.view);
//        int transparentColor = 0xCC000000;
//        drawView.setBackgroundColor(transparentColor);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        scaleX = width / 800;
        scaleY = height / 600;

        presenter.getDrawingLines();

        startX = 236 * scaleX;
        startY = 147 * scaleY;
        endX = 284 * scaleX;
        endY = 147 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 284 * scaleX;
        startY = 147 * scaleY;
        endX = 330 * scaleX;
        endY = 150 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 330 * scaleX;
        startY = 150 * scaleY;
        endX = 345 * scaleX;
        endY = 152 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 345 * scaleX;
        startY = 152 * scaleY;
        endX = 354 * scaleX;
        endY = 155 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 354 * scaleX;
        startY = 155 * scaleY;
        endX = 367 * scaleX;
        endY = 159 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 367 * scaleX;
        startY = 159 * scaleY;
        endX = 370 * scaleX;
        endY = 160 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 370 * scaleX;
        startY = 160 * scaleY;
        endX = 375 * scaleX;
        endY = 162 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 375 * scaleX;
        startY = 162 * scaleY;
        endX = 379 * scaleX;
        endY = 165 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 379 * scaleX;
        startY = 165 * scaleY;
        endX = 388 * scaleX;
        endY = 175 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 388 * scaleX;
        startY = 175 * scaleY;
        endX = 389 * scaleX;
        endY = 178 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 389 * scaleX;
        startY = 178 * scaleY;
        endX = 391 * scaleX;
        endY = 186 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 391 * scaleX;
        startY = 186 * scaleY;
        endX = 391 * scaleX;
        endY = 194 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 391 * scaleX;
        startY = 194 * scaleY;
        endX = 391 * scaleX;
        endY = 211 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 391 * scaleX;
        startY = 211 * scaleY;
        endX = 390 * scaleX;
        endY = 216 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 390 * scaleX;
        startY = 216 * scaleY;
        endX = 389 * scaleX;
        endY = 221 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 389 * scaleX;
        startY = 221 * scaleY;
        endX = 387 * scaleX;
        endY = 226 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 387 * scaleX;
        startY = 226 * scaleY;
        endX = 384 * scaleX;
        endY = 230 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 384 * scaleX;
        startY = 230 * scaleY;
        endX = 382 * scaleX;
        endY = 234 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 382 * scaleX;
        startY = 234 * scaleY;
        endX = 380 * scaleX;
        endY = 237 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 380 * scaleX;
        startY = 237 * scaleY;
        endX = 377 * scaleX;
        endY = 240 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 377 * scaleX;
        startY = 240 * scaleY;
        endX = 374 * scaleX;
        endY = 243 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 374 * scaleX;
        startY = 243 * scaleY;
        endX = 370 * scaleX;
        endY = 245 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 370 * scaleX;
        startY = 245 * scaleY;
        endX = 366 * scaleX;
        endY = 248 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 366 * scaleX;
        startY = 248 * scaleY;
        endX = 361 * scaleX;
        endY = 250 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 361 * scaleX;
        startY = 250 * scaleY;
        endX = 355 * scaleX;
        endY = 252 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 355 * scaleX;
        startY = 252 * scaleY;
        endX = 353 * scaleX;
        endY = 253 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 353 * scaleX;
        startY = 253 * scaleY;
        endX = 348 * scaleX;
        endY = 253 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 348 * scaleX;
        startY = 253 * scaleY;
        endX = 346 * scaleX;
        endY = 253 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 346 * scaleX;
        startY = 253 * scaleY;
        endX = 344 * scaleX;
        endY = 253 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 344 * scaleX;
        startY = 253 * scaleY;
        endX = 342 * scaleX;
        endY = 253 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 342 * scaleX;
        startY = 253 * scaleY;
        endX = 341 * scaleX;
        endY = 253 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 341 * scaleX;
        startY = 253 * scaleY;
        endX = 339 * scaleX;
        endY = 252 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 339 * scaleX;
        startY = 252 * scaleY;
        endX = 339 * scaleX;
        endY = 251 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 339 * scaleX;
        startY = 251 * scaleY;
        endX = 338 * scaleX;
        endY = 250 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 338 * scaleX;
        startY = 250 * scaleY;
        endX = 337 * scaleX;
        endY = 249 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 337 * scaleX;
        startY = 249 * scaleY;
        endX = 336 * scaleX;
        endY = 247 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 336 * scaleX;
        startY = 247 * scaleY;
        endX = 336 * scaleX;
        endY = 244 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 336 * scaleX;
        startY = 244 * scaleY;
        endX = 334 * scaleX;
        endY = 241 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 334 * scaleX;
        startY = 241 * scaleY;
        endX = 334 * scaleX;
        endY = 237 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 334 * scaleX;
        startY = 237 * scaleY;
        endX = 334 * scaleX;
        endY = 236 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 334 * scaleX;
        startY = 236 * scaleY;
        endX = 334 * scaleX;
        endY = 234 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 393 * scaleX;
        startY = 320 * scaleY;
        endX = 391 * scaleX;
        endY = 325 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 390 * scaleX;
        startY = 328 * scaleY;
        endX = 389 * scaleX;
        endY = 329 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 389 * scaleX;
        startY = 330 * scaleY;
        endX = 389 * scaleX;
        endY = 330 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 389 * scaleX;
        startY = 331 * scaleY;
        endX = 389 * scaleX;
        endY = 331 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 388 * scaleX;
        startY = 331 * scaleY;
        endX = 387 * scaleX;
        endY = 331 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 386 * scaleX;
        startY = 331 * scaleY;
        endX = 385 * scaleX;
        endY = 331 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        startX = 382 * scaleX;
        startY = 330 * scaleY;
        endX = 382 * scaleX;
        endY = 330 * scaleY;
        lineList.add(new LineModel(startX, startY, endX, endY));

        drawView.DrawLine(lineList);

    }

    @Override
    public void onGetDrawingList(DrawingModel result) {
        Log.e("API Data", new GsonBuilder().setPrettyPrinting().create().toJson(result));

        plotList = result.getData().get(0).getPlots();

            for (int i = 1; i < plotList.size(); i++){
                startX = plotList.get(i - 1).getX() * scaleX;
                startY = plotList.get(i - 1).getY() * scaleY;
                endX =plotList.get(i).getX() * scaleX;
                endY = plotList.get(i).getY() * scaleY;
                lineList.add(new LineModel(startX, startY, endX, endY));
            }

        Log.e("lineList", new GsonBuilder().setPrettyPrinting().create().toJson(lineList));

        drawView.DrawLine(lineList);

    }
}