package com.example.roman.todolistandroidapp.data.network.requests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    public static <S> S createService(Class<S> serviceClass){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit.Builder sBuilder =
                new Retrofit.Builder()
                        .baseUrl("здесь url")
                        .addConverterFactory(GsonConverterFactory.create(gson));
        Retrofit retrofit = sBuilder
                .client(httpClient.build())
                .build();
        return retrofit.create(serviceClass);
    }


}