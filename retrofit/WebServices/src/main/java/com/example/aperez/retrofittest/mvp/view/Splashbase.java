package com.example.aperez.retrofittest.mvp.view;

import com.example.aperez.retrofittest.mvp.model.Image;
import com.example.aperez.retrofittest.mvp.model.LatestResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by aperez on 24/01/17.
 */

public interface Splashbase {

    @GET("api/v1/images/latest")
    Call<LatestResponse> getLatest();
}
