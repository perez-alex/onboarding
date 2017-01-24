package com.example.aperez.retrofittest.mvp.presenter;

import android.widget.Toast;

import com.example.aperez.retrofittest.R;
import com.example.aperez.retrofittest.mvp.model.Image;
import com.example.aperez.retrofittest.mvp.model.LatestResponse;
import com.example.aperez.retrofittest.mvp.view.ResponseView;
import com.example.aperez.retrofittest.mvp.view.Splashbase;
import com.squareup.otto.Subscribe;

import java.util.List;

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

    public ResponsePresenter(ResponseView view){
        this.view = view;
    }

    public void getLatestImages(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.splashbase.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Splashbase service = retrofit.create(Splashbase.class);
        Call<LatestResponse> call = service.getLatest();
        call.enqueue(new Callback<LatestResponse>() {
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
