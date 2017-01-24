package com.example.aperez.retrofittest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.aperez.retrofittest.mvp.presenter.ResponsePresenter;
import com.example.aperez.retrofittest.mvp.view.ResponseView;
import com.example.aperez.retrofittest.utils.BusProvider;

import butterknife.ButterKnife;

/**
 * Created by aperez on 24/01/17.
 */

public class MainActivity extends AppCompatActivity {

    private ResponsePresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ResponseView view = new ResponseView(this, BusProvider.getInstance());
        ButterKnife.bind(view, this);
        presenter = new ResponsePresenter(view);
        presenter.getLatestImages();
    }

    @Override
    protected void onResume() {
        super.onResume();
        BusProvider.register(presenter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        BusProvider.unregister(presenter);
    }
}
