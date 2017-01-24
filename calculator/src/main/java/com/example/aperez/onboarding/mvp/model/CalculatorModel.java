package com.example.aperez.onboarding.mvp.model;

/**
 * Created by aperez on 23/01/17.
 */

public class CalculatorModel {

    private Double result;

    public void multiply(Double first, Double second) {
        result = first * second;
    }

    public void divide(Double first, Double second) {
        result = first / second;
    }

    public void add(Double first, Double second) {
        result = first + second;
    }

    public void substract(Double first, Double second) {
        result = first - second;
    }

    public Double getResult() {
        return result;
    }
}
