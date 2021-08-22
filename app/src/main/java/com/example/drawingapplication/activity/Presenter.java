package com.example.drawingapplication.activity;

import android.content.Context;
import android.widget.Toast;

import com.example.drawingapplication.model.DrawingModel;
import com.example.drawingapplication.service.api.ApiInterface;
import com.example.drawingapplication.service.client.ErrorResponse;
import com.example.drawingapplication.service.client.RestCallback;
import com.example.drawingapplication.service.client.RestClientBuilder;

public class Presenter {

    Context context;
    View view;

    public Presenter(Context context, View view) {
        this.context = context;
        this.view = view;
    }

    public void getDrawingLines() {

//        if (!CommonUtils.isConnectedToInternet()) {
//            Toast.makeText(context, "Please make sure you have an active internet connection.", Toast.LENGTH_LONG).show();
//            return;
//        }

        ApiInterface apiInterface = RestClientBuilder.createService(context, ApiInterface.class);
        apiInterface.getDrawingLines().enqueue(new RestCallback<DrawingModel>() {
            @Override
            public void onSuccess(DrawingModel result) {
                view.onGetDrawingList(result);
            }

            @Override
            public void onError(ErrorResponse errorResponse) {
                Toast.makeText(context, "Service error!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
