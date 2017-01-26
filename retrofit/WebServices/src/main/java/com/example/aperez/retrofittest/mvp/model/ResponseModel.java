package com.example.aperez.retrofittest.mvp.model;

import com.example.aperez.retrofittest.mvp.model.db.ImagesRepository;
import com.example.aperez.retrofittest.mvp.model.event.LatestFailureEvent;
import com.example.aperez.retrofittest.mvp.model.event.LatestSuccessEvent;
import com.example.aperez.retrofittest.mvp.model.services.Service;
import com.example.aperez.retrofittest.mvp.view.Splashbase;
import com.squareup.otto.Bus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aperez on 24/01/17.
 */

public class ResponseModel {

    private final Bus bus;

    public ResponseModel(Bus bus) {
        this.bus = bus;
    }

    public void getLatestImages(){
        Splashbase service = Service.getSplashbaseService();
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
        return ImagesRepository.getAllImages();
    }

    public void saveImages(List<Image> images) {
        ImagesRepository.saveImages(images);
    }
}
