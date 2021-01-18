package com.example.listenenglish.service;

public class APIService {
    private static String baseURL = "https://applistenenglish1.000webhostapp.com/Sever/";

    public static DataService getService(){
        return APIRetrofitClient.getClient(baseURL).create(DataService.class);
    }
}
