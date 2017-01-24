package com.example.aperez.onboarding;

import com.example.aperez.onboarding.mvp.model.CalculatorModel;
import com.example.aperez.onboarding.mvp.presenter.CalculatorPresenter;
import com.example.aperez.onboarding.mvp.view.CalculatorView;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class PresenterTest {

    private CalculatorPresenter presenter;
    private CalculatorModel model;
    private CalculatorView view;

    @Before
    public void setup() {
        model = new CalculatorModel();
        view = mock(CalculatorView.class);
        presenter = new CalculatorPresenter(model, view);
    }

    @Test
    public void isAdditionCorrect(){
        presenter.onEqualsPressed(new CalculatorView.EqualsButtonPressed("25","12","+"));
        assertEquals(model.getResult(), Double.valueOf(37));
        verify(view).setResult(37d);
        verifyNoMoreInteractions(view);
    }

    @Test
    public void isDivisionCorrect(){
        presenter.onEqualsPressed(new CalculatorView.EqualsButtonPressed("852","56","/"));
        assertEquals(model.getResult(), Double.valueOf(15.214285714285714));
        verify(view).setResult(15.214285714285714d);
        verifyNoMoreInteractions(view);
    }

    @Test
    public void isMultiplicationCorrect(){
        presenter.onEqualsPressed(new CalculatorView.EqualsButtonPressed("-8","12","*"));
        assertEquals(model.getResult(), Double.valueOf(-96));
        verify(view).setResult(-96d);
        verifyNoMoreInteractions(view);
    }

    @Test
    public void isSubtractionCorrect(){
        presenter.onEqualsPressed(new CalculatorView.EqualsButtonPressed("29","7","-"));
        assertEquals(model.getResult(), Double.valueOf(22));
        verify(view).setResult(22d);
        verifyNoMoreInteractions(view);
    }
}