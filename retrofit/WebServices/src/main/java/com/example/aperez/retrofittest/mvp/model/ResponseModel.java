package com.example.aperez.retrofittest.mvp.model;

import com.example.aperez.retrofittest.mvp.view.Splashbase;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aperez on 24/01/17.
 */

public class ResponseModel {

    public void getLatestImages(Callback<LatestResponse> callback){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.splashbase.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Splashbase service = retrofit.create(Splashbase.class);
        Call<LatestResponse> call = service.getLatest();
        call.enqueue(callback);
    }
}
