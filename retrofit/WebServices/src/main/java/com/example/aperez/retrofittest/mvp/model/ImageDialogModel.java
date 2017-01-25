package com.example.aperez.retrofittest.mvp.model;

import com.example.aperez.retrofittest.mvp.model.event.ImageDetailsFailureEvent;
import com.example.aperez.retrofittest.mvp.model.event.ImageDetailsSuccessEvent;
import com.example.aperez.retrofittest.mvp.view.Splashbase;
import com.squareup.otto.Bus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aperez on 25/01/17.
 */

public class ImageDialogModel {

    private final Bus bus;

    public ImageDialogModel(Bus bus) {
        this.bus = bus;
    }

    public void getImageDetails(String id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.splashbase.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Splashbase service = retrofit.create(Splashbase.class);
        Call<Image> call = service.getImageDetails(id);
        call.enqueue(new Callback<Image>() {
            @Override
            public void onResponse(Call<Image> call, Response<Image> response) {
                bus.post(new ImageDetailsSuccessEvent(response.body()));
            }

            @Override
            public void onFailure(Call<Image> call, Throwable t) {
                bus.post(new ImageDetailsFailureEvent());
            }
        });
    }
}
