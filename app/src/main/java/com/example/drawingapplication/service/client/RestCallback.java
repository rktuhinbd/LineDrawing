package com.example.drawingapplication.service.client;

import android.app.Activity;

import com.example.drawingapplication.utils.CommonUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.SocketTimeoutException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class RestCallback<T> implements Callback<T> {

    private final GsonConverterFactory gsonConverter;
    private final Activity activity;
    private Call<T> originalCall;
    private ErrorMessageResponse errorMessageResponse;

    public RestCallback() {
        this(null);
    }

    public RestCallback(Activity activity) {
        this.activity = activity;
        this.gsonConverter = GsonConverterFactory.create();
    }

    public abstract void onSuccess(T result) throws IOException;
    //public abstract  void onSuccess();

    public abstract void onError(ErrorResponse errorResponse);

    @Override
    public void onResponse(@NotNull Call<T> call, @NotNull Response<T> response) {
        this.originalCall = call;
        try {
            if (response.isSuccessful()) {
                onSuccess(response.body());
            } else {
                onError(createErrorResponse(response));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailure(@NotNull Call<T> call, Throwable t) {
        t.printStackTrace();

        if (t instanceof SocketTimeoutException) {
            onError(new ErrorResponse("", "Something error in your internet connectivity"));
        } else {
            if (!CommonUtils.isConnectedToInternet()) {
                onError(new ErrorResponse("", "Check your internet connectivity"));
            } else {
                onError(new ErrorResponse("", "The request can not be processed!"));
            }
        }
    }


    public ErrorResponse createErrorResponse(Response<T> response) {
        String msg = null;
        switch (response.code()) {

            case 400:
                try {
                    msg = response.errorBody().string();
                } catch (IOException ex) {
                    msg = ex.getMessage();

                }
                break;

            case 401:
                msg = "Session Time out";
                break;

            case 404:
                try {
                    msg = response.errorBody().string();
                } catch (IOException ex) {
                    msg = ex.getMessage();
                }
                break;
            case 502:
                msg = "Service not ready!!!";
                break;
            case 500:
            case 503:
                msg = "Internal server error!!!";
                break;

            default:
                try {
                    errorMessageResponse = (new Gson()).fromJson(response.errorBody().string(), new TypeToken<ErrorMessageResponse>() {
                    }.getType());
                    if (errorMessageResponse != null) {
                        if (errorMessageResponse.getError_description() != null) {
                            msg = errorMessageResponse.getError_description();
                        } else {
                            if (errorMessageResponse.getDecentMessage() != null) {
                                msg = errorMessageResponse.getDecentMessage();
                            }
                        }
                    } else {
                        msg = response.message();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
        }
        return new ErrorResponse(response.code(), String.valueOf(response.code()), msg);
    }

}

