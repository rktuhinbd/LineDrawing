package com.example.drawingapplication.activity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.drawingapplication.R;
import com.example.drawingapplication.model.DrawingModel;
import com.example.drawingapplication.model.LineModel;
import com.example.drawingapplication.model.LinesData;
import com.example.drawingapplication.model.Plot;
import com.example.drawingapplication.utils.DrawView;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View {

    private Presenter presenter;

    private List<Plot> plots = new ArrayList();
    private List<LineModel> lineModel = new ArrayList();
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
//        lines.add(new LineModel(0, 10, 200, 10));
//        lines.add(new LineModel(100, 200, 300, 200));
//        lines.add(new LineModel(200, 400, 400, 400));
//        lines.add(new LineModel(300, 600, 500, 600));
//        lines.add(new LineModel(400, 800, 600, 800));
//        lines.add(new LineModel(500, 1000, 700, 1000));

//        startX = 339 * scaleX;
//        startY = 228 * scaleY;
//        endX = 340 * scaleX;
//        endY = 228 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 340 * scaleX;
//        startY = 228 * scaleY;
//        endX = 343 * scaleX;
//        endY = 228 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 343 * scaleX;
//        startY = 228 * scaleY;
//        endX = 347 * scaleX;
//        endY = 228 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 347 * scaleX;
//        startY = 228 * scaleY;
//        endX = 352 * scaleX;
//        endY = 228 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 352 * scaleX;
//        startY = 228 * scaleY;
//        endX = 372 * scaleX;
//        endY = 231 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 375 * scaleX;
//        startY = 233 * scaleY;
//        endX = 378 * scaleX;
//        endY = 233 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 382 * scaleX;
//        startY = 235 * scaleY;
//        endX = 384 * scaleX;
//        endY = 237 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 387 * scaleX;
//        startY = 238 * scaleY;
//        endX = 389 * scaleX;
//        endY = 240 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 391 * scaleX;
//        startY = 241 * scaleY;
//        endX = 393 * scaleX;
//        endY = 243 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 395 * scaleX;
//        startY = 245 * scaleY;
//        endX = 397 * scaleX;
//        endY = 249 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 399 * scaleX;
//        startY = 252 * scaleY;
//        endX = 402 * scaleX;
//        endY = 255 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 408 * scaleX;
//        startY = 265 * scaleY;
//        endX = 410 * scaleX;
//        endY = 270 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 411 * scaleX;
//        startY = 277 * scaleY;
//        endX = 411 * scaleX;
//        endY = 279 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 412 * scaleX;
//        startY = 283 * scaleY;
//        endX = 413 * scaleX;
//        endY = 287 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 413 * scaleX;
//        startY = 292 * scaleY;
//        endX = 413 * scaleX;
//        endY = 298 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 413 * scaleX;
//        startY = 302 * scaleY;
//        endX = 413 * scaleX;
//        endY = 308 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 412 * scaleX;
//        startY = 312 * scaleY;
//        endX = 409 * scaleX;
//        endY = 319 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 408 * scaleX;
//        startY = 321 * scaleY;
//        endX = 404 * scaleX;
//        endY = 327 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 402 * scaleX;
//        startY = 330 * scaleY;
//        endX = 400 * scaleX;
//        endY = 332 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 399 * scaleX;
//        startY = 332 * scaleY;
//        endX = 398 * scaleX;
//        endY = 332 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 397 * scaleX;
//        startY = 332 * scaleY;
//        endX = 395 * scaleX;
//        endY = 332 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 391 * scaleX;
//        startY = 332 * scaleY;
//        endX = 386 * scaleX;
//        endY = 332 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 381 * scaleX;
//        startY = 330 * scaleY;
//        endX = 376 * scaleX;
//        endY = 328 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 370 * scaleX;
//        startY = 325 * scaleY;
//        endX = 366 * scaleX;
//        endY = 322 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 363 * scaleX;
//        startY = 320 * scaleY;
//        endX = 361 * scaleX;
//        endY = 318 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 359 * scaleX;
//        startY = 315 * scaleY;
//        endX = 357 * scaleX;
//        endY = 313 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 356 * scaleX;
//        startY = 312 * scaleY;
//        endX = 356 * scaleX;
//        endY = 309 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 355 * scaleX;
//        startY = 305 * scaleY;
//        endX = 355 * scaleX;
//        endY = 302 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 355 * scaleX;
//        startY = 298 * scaleY;
//        endX = 355 * scaleX;
//        endY = 295 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 355 * scaleX;
//        startY = 294 * scaleY;
//        endX = 357 * scaleX;
//        endY = 293 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 359 * scaleX;
//        startY = 292 * scaleY;
//        endX = 360 * scaleX;
//        endY = 291 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 362 * scaleX;
//        startY = 289 * scaleY;
//        endX = 365 * scaleX;
//        endY = 288 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 368 * scaleX;
//        startY = 287 * scaleY;
//        endX = 370 * scaleX;
//        endY = 286 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 372 * scaleX;
//        startY = 286 * scaleY;
//        endX = 374 * scaleX;
//        endY = 287 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 377 * scaleX;
//        startY = 288 * scaleY;
//        endX = 381 * scaleX;
//        endY = 290 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 384 * scaleX;
//        startY = 292 * scaleY;
//        endX = 388 * scaleX;
//        endY = 295 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 390 * scaleX;
//        startY = 296 * scaleY;
//        endX = 392 * scaleX;
//        endY = 299 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 393 * scaleX;
//        startY = 300 * scaleY;
//        endX = 393 * scaleX;
//        endY = 302 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 393 * scaleX;
//        startY = 304 * scaleY;
//        endX = 394 * scaleX;
//        endY = 306 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 394 * scaleX;
//        startY = 309 * scaleY;
//        endX = 394 * scaleX;
//        endY = 310 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 394 * scaleX;
//        startY = 312 * scaleY;
//        endX = 393 * scaleX;
//        endY = 316 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 393 * scaleX;
//        startY = 320 * scaleY;
//        endX = 391 * scaleX;
//        endY = 325 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 390 * scaleX;
//        startY = 328 * scaleY;
//        endX = 389 * scaleX;
//        endY = 329 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 389 * scaleX;
//        startY = 330 * scaleY;
//        endX = 389 * scaleX;
//        endY = 330 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 389 * scaleX;
//        startY = 331 * scaleY;
//        endX = 389 * scaleX;
//        endY = 331 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 388 * scaleX;
//        startY = 331 * scaleY;
//        endX = 387 * scaleX;
//        endY = 331 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 386 * scaleX;
//        startY = 331 * scaleY;
//        endX = 385 * scaleX;
//        endY = 331 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));
//
//        startX = 382 * scaleX;
//        startY = 330 * scaleY;
//        endX = 382 * scaleX;
//        endY = 330 * scaleY;
//        lines.add(new LineModel(startX, startY, endX, endY));


    }

    @Override
    public void onGetDrawingList(DrawingModel lines) {
        Log.e("API Data", new GsonBuilder().setPrettyPrinting().create().toJson(lines));

        plots = lines.getData().get(0).getPlots();

        for (int i = 0; i < plots.size() - 1; i++) {
            startX = plots.get(i).getX() * scaleX;
            startY = plots.get(i).getY() * scaleY;
            endX = plots.get(i + 1).getX() * scaleX;
            endY = plots.get(i + 1).getY() * scaleY;
            lineModel.add(new LineModel(startX, startY, endX, endY));
        }

        drawView.DrawLine(lineModel);

    }
}