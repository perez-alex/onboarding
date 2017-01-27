package com.example.aperez.retrofittest;

import com.example.aperez.retrofittest.mvp.model.Image;
import com.example.aperez.retrofittest.mvp.model.ImageDialogModel;
import com.example.aperez.retrofittest.mvp.model.event.ImageDetailsSuccessEvent;
import com.example.aperez.retrofittest.mvp.presenter.ImageDialogPresenter;
import com.example.aperez.retrofittest.mvp.view.ImageDialogView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class ImageDialogPresenterTest {

    private ImageDialogPresenter presenter;
    @Mock
    private ImageDialogView view;
    @Mock
    private ImageDialogModel model;

    @Before
    public void setup() {
        presenter = new ImageDialogPresenter(model, view);
    }

    @Test
    public void isGetDetailCorrect() throws Exception {
        when(model.getId()).thenReturn("8520");
        presenter.getImagesDetail("8520");
        verify(model).getImageDetails("8520");
    }

    @Test
    public void isImageDetailSuccessCorrect() throws Exception {
        ImageDetailsSuccessEvent event = mock(ImageDetailsSuccessEvent.class);
        Image image = mock(Image.class);
        when(event.getImage()).thenReturn(image);
        when(image.getLargeUrl()).thenReturn("aaa");
        when(image.getCopyright()).thenReturn("vvv");
        when(image.getSite()).thenReturn("fff");
        presenter.imageDetailsSuccessEvent(event);
        verify(event).getImage();
        verify(view).setImageDetails("aaa","fff","vvv");
    }
}