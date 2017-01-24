package com.example.aperez.retrofittest.mvp.presenter;

import android.widget.Toast;

import com.example.aperez.retrofittest.R;
import com.example.aperez.retrofittest.mvp.model.LatestResponse;
import com.example.aperez.retrofittest.mvp.model.ResponseModel;
import com.example.aperez.retrofittest.mvp.view.ResponseView;
import com.example.aperez.retrofittest.mvp.view.Splashbase;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aperez on 24/01/17.
 */

public class ResponsePresenter {

    private ResponseView view;
    private ResponseModel model;

    public ResponsePresenter(ResponseModel model, ResponseView view){
        this.model = model;
        this.view = view;
    }

    public void getLatestImages(){
        model.getLatestImages(new Callback<LatestResponse>() {
            @Override
            public void onResponse(Call<LatestResponse> call, Response<LatestResponse> response) {
                view.setText(response.body());
            }

            @Override
            public void onFailure(Call<LatestResponse> call, Throwable t) {
                Toast.makeText(view.getActivity(), R.string.response_error,Toast.LENGTH_LONG);
            }
        });
    }
}
