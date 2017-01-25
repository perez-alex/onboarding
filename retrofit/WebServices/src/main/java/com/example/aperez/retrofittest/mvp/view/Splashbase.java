package com.example.aperez.retrofittest.mvp.view;

import com.example.aperez.retrofittest.mvp.model.Image;
import com.example.aperez.retrofittest.mvp.model.LatestResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by aperez on 24/01/17.
 */

public interface Splashbase {

    @GET("api/v1/images/latest")
    Call<LatestResponse> getLatest();

    @GET("api/v1/images/{id}")
    Call<Image> getImageDetails(@Path("id") String imageId);
}
