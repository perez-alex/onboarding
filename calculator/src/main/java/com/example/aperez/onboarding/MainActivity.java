package com.example.aperez.onboarding;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.aperez.onboarding.mvp.model.CalculatorModel;
import com.example.aperez.onboarding.mvp.presenter.CalculatorPresenter;
import com.example.aperez.onboarding.mvp.view.CalculatorView;
import com.example.aperez.onboarding.utils.BusProvider;

/**
 * Created by aperez on 23/01/17.
 */

public class MainActivity extends AppCompatActivity {

    private CalculatorPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new CalculatorPresenter(new CalculatorModel(), new CalculatorView(this, BusProvider.getInstance()));
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
