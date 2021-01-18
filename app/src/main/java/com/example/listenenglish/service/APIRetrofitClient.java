package com.example.listenenglish.service;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.Time;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIRetrofitClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient(String baseURL) {
        //1s = 1000mls

        Log.d("Sang OK", "getClient: "  + baseURL);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                                        .readTimeout(10000, TimeUnit.MILLISECONDS)
                                        .writeTimeout(10000, TimeUnit.MILLISECONDS)
                                        .connectTimeout(10000, TimeUnit.MILLISECONDS)
                                        .retryOnConnectionFailure(true) //khi bị ngắt kết nối thì cố gắng kết nối lại
                                        .protocols(Arrays.asList(Protocol.HTTP_1_1))
                                        .build();

        Gson gson = new GsonBuilder().setLenient().create();

        retrofit = new Retrofit.Builder()
                        .baseUrl(baseURL)
                        .client(okHttpClient)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
        return retrofit;
    }
}
