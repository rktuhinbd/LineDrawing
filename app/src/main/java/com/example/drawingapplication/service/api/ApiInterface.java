package com.example.drawingapplication.service.api;

import com.example.drawingapplication.model.DrawingModel;
import com.example.drawingapplication.service.client.UrlConstants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiInterface {

    @GET(UrlConstants.GET_DRAWING_LINES)
    @Headers("Content-Type: application/json")
    Call<DrawingModel> getDrawingLines();

}
