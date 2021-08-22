package com.example.drawingapplication.service.client;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClientBuilder {

    private static final String TAG = "RestClientBuilder";
    private static Boolean showLoader = false;
    private static Boolean hideLoader = false;

    private static Request.Builder getHeader(Context context, Request.Builder requestBuilder) {

        requestBuilder.addHeader("Content-Type", "application/json");
        return requestBuilder;

    }

    public static Retrofit createClient() {
        return createClient(null);
    }

    public static Retrofit createClient(Context context) {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Date.class, new DateTypeAdapter())
                .create();

        final OkHttpClient.Builder httpClientBuilder = new OkHttpClient().newBuilder();
        httpClientBuilder.connectTimeout(90, TimeUnit.SECONDS);
        httpClientBuilder.readTimeout(90, TimeUnit.SECONDS);
        httpClientBuilder.writeTimeout(90, TimeUnit.SECONDS);
        httpClientBuilder.addInterceptor(logging);

        return new Retrofit.Builder()
                .baseUrl(UrlConstants.BASE_URL)
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static <T> T createService(Context context, Class serviceClass) {

        showLoader = false;
        hideLoader = false;
        return (T) createClient(context).create(serviceClass);

    }

    public static <T> T createService(Context context, Class serviceClass, boolean showLoader, boolean hideLoader) {

        RestClientBuilder.showLoader = showLoader;
        RestClientBuilder.hideLoader = hideLoader;
        return (T) createClient(context).create(serviceClass);

    }

}
