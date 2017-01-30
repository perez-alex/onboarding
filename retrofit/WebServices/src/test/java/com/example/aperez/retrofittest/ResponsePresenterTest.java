package com.example.aperez.retrofittest;

import com.example.aperez.retrofittest.mvp.model.Image;
import com.example.aperez.retrofittest.mvp.model.LatestResponse;
import com.example.aperez.retrofittest.mvp.model.ResponseModel;
import com.example.aperez.retrofittest.mvp.model.event.LatestFailureEvent;
import com.example.aperez.retrofittest.mvp.model.event.LatestSuccessEvent;
import com.example.aperez.retrofittest.mvp.presenter.ResponsePresenter;
import com.example.aperez.retrofittest.mvp.view.ImageFragment;
import com.example.aperez.retrofittest.mvp.view.ResponseView;
import com.example.aperez.retrofittest.mvp.view.event.ImageClickedEvent;
import com.example.aperez.retrofittest.mvp.view.event.RefreshEvent;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class ResponsePresenterTest {

    private ResponsePresenter presenter;
    @Mock
    private ResponseView view;
    @Mock
    private ResponseModel model;

    @Before
    public void setup() {
        presenter = new ResponsePresenter(model, view);
    }

    @Test
    public void isGetImagesCorrect() throws Exception {
        ArrayList<Image> result = mock(ArrayList.class);
        when(model.getSavedImages()).thenReturn(result);

        presenter.getStoredImages();
        verify(model).getSavedImages();
        verify(view).setCards(result);
    }

    @Test
    public void isLatestImagesSuccessCorrect() throws Exception {
        LatestResponse response = mock(LatestResponse.class);
        LatestSuccessEvent event = new LatestSuccessEvent(response);
        List<Image> list = mock(List.class);
        when(response.getImages()).thenReturn(list);

        presenter.latestImagesEventSuccess(event);

        verify(model).saveImages(list);
        verify(view).setCards(list);
    }

    @Test
    public void isLastestImagesFailureCorrect() throws Exception {
        LatestFailureEvent event = new LatestFailureEvent();
        presenter.latesImagesEventFailure(event);
        verify(view).showErrorToast();
    }

    @Test
    public void isImageClickedCorrect() throws Exception {
        ImageClickedEvent event = new ImageClickedEvent("1");;
        presenter.imageClickedEvent(event);
        verify(view).showImageDialog("1");
    }

    @Test
    public void isRefreshCorrect() throws Exception {
        RefreshEvent event = new RefreshEvent();
        presenter.refreshClickedEvent(event);
        verify(model).getLatestImages();
    }
}