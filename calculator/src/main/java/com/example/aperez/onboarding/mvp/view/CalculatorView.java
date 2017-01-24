package com.example.aperez.onboarding.mvp.view;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import com.example.aperez.onboarding.R;
import com.squareup.otto.Bus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aperez on 23/01/17.
 */

public class CalculatorView extends ActivityView {

    private final Bus bus;

    @BindView(R.id.firstValue)
    EditText firstValue;
    @BindView(R.id.secondValue)
    EditText secondValue;
    @BindView(R.id.operator)
    EditText operator;
    @BindView(R.id.result)
    TextView result;

    public CalculatorView(Activity activity, Bus bus) {
        super(activity);
        this.bus = bus;
        ButterKnife.bind(this, activity);
    }

    @OnClick(R.id.equalsButton)
    public void equalsButtonPressed() {
        bus.post(new EqualsButtonPressed(firstValue.getText().toString(),
                secondValue.getText().toString(),
                operator.getText().toString()));
    }

    public void setResult(Double result) {
        this.result.setText(String.valueOf(result));
    }

    public static class EqualsButtonPressed {
        private String firstValue, secondValue, operator;

        public EqualsButtonPressed(String firstValue, String secondValue, String operator) {
            this.firstValue = firstValue;
            this.secondValue = secondValue;
            this.operator = operator;
        }

        public Double getFirstValue() {
            if ((operator.equals("+") || operator.equals("-")) && firstValue.trim().equals("")) {
                return 0d;
            } else if (firstValue.trim().equals("")) {
                return 1d;
            }
            return Double.valueOf(firstValue);
        }

        public Double getSecondValue() {
            if ((operator.equals("+") || operator.equals("-")) && secondValue.trim().equals("")) {
                return 0d;
            } else if (secondValue.trim().equals("")) {
                return 1d;
            }
            return Double.valueOf(secondValue);
        }

        public String getOperator() {
            return operator;
        }
    }
}
