package com.example.aperez.onboarding.mvp.presenter;

import com.example.aperez.onboarding.mvp.model.CalculatorModel;
import com.example.aperez.onboarding.mvp.view.CalculatorView;
import com.squareup.otto.Subscribe;

/**
 * Created by aperez on 23/01/17.
 */

public class CalculatorPresenter {

    private final static String ADD = "+";
    private final static String SUBTRACT = "-";
    private final static String MULTIPLY = "*";
    private final static String DIVIDE = "/";

    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorPresenter(CalculatorModel model, CalculatorView view){
        this.model = model;
        this.view = view;
    }

    @Subscribe
    public void onEqualsPressed(CalculatorView.EqualsButtonPressed event){
        switch (event.getOperator()){
            case ADD:
                model.add(event.getFirstValue(),event.getSecondValue());
                break;
            case SUBTRACT:
                model.substract(event.getFirstValue(),event.getSecondValue());
                break;
            case DIVIDE:
                model.divide(event.getFirstValue(),event.getSecondValue());
                break;
            case MULTIPLY:
                model.multiply(event.getFirstValue(),event.getSecondValue());
                break;
        }
        view.setResult(model.getResult());
    }
}
