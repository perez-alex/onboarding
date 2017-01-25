package com.example.aperez.retrofittest.mvp.presenter;

import com.example.aperez.retrofittest.mvp.model.Image;
import com.example.aperez.retrofittest.mvp.model.ImageDialogModel;
import com.example.aperez.retrofittest.mvp.model.event.ImageDetailsSuccessEvent;
import com.example.aperez.retrofittest.mvp.view.ImageDialogView;
import com.squareup.otto.Subscribe;

/**
 * Created by aperez on 25/01/17.
 */

public class ImageDialogPresenter {

    private ImageDialogModel model;
    private ImageDialogView view;

    public ImageDialogPresenter(ImageDialogModel model, ImageDialogView view) {
        this.model = model;
        this.view = view;
    }

    public void getImagesDetail(String id) {
        model.getImageDetails(id);
    }

    @Subscribe
    public void imageDetailsSuccessEvent(ImageDetailsSuccessEvent event) {
        Image image = event.getImage();
        view.setImageDetails(image.getLargeUrl(), image.getSite(), image.getCopyright());
    }
}
