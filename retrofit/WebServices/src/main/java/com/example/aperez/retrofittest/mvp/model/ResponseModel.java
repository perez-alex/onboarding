package com.example.aperez.retrofittest.mvp.model;

import com.activeandroid.ActiveAndroid;
import com.example.aperez.retrofittest.BuildConfig;
import com.example.aperez.retrofittest.mvp.model.event.LatestFailureEvent;
import com.example.aperez.retrofittest.mvp.model.event.LatestSuccessEvent;
import com.example.aperez.retrofittest.mvp.view.Splashbase;
import com.google.gson.GsonBuilder;
import com.squareup.otto.Bus;

import java.lang.reflect.Modifier;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aperez on 24/01/17.
 */

public class ResponseModel {

    private final Bus bus;

    public ResponseModel(Bus bus) {
        this.bus = bus;
    }

    public void getLatestImages(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.SPLASHBASE_URL)
                .addConverterFactory(GsonConverterFactory.create(
                        new GsonBuilder()
                        .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                        .create()
                ))
                .build();

        Splashbase service = retrofit.create(Splashbase.class);
        Call<LatestResponse> call = service.getLatest();
        call.enqueue(new Callback<LatestResponse>() {
            @Override
            public void onResponse(Call<LatestResponse> call, Response<LatestResponse> response) {
                bus.post(new LatestSuccessEvent(response.body()));
            }

            @Override
            public void onFailure(Call<LatestResponse> call, Throwable t) {
                bus.post(new LatestFailureEvent());
            }
        });
    }

    public List<Image> getSavedImages() {
        return Image.getAll();
    }

    public void saveImages(List<Image> images) {
        ActiveAndroid.beginTransaction();
        try {
            for (Image image : images) {
                image.save();
            }
            ActiveAndroid.setTransactionSuccessful();
        } finally {
            ActiveAndroid.endTransaction();
        }
    }
}
