package com.example.aperez.retrofittest.mvp.model.services;

import com.example.aperez.retrofittest.BuildConfig;
import com.example.aperez.retrofittest.mvp.view.Splashbase;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Modifier;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aperez on 26/01/17.
 */

public class Service {

    public static Splashbase getSplashbaseService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.SPLASHBASE_URL)
                .addConverterFactory(GsonConverterFactory.create(
                        new GsonBuilder()
                                .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                                .create()
                ))
                .build();

        Splashbase service = retrofit.create(Splashbase.class);
        return service;
    }
}
