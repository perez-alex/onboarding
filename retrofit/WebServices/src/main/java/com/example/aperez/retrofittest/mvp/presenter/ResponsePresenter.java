package com.example.aperez.retrofittest.mvp.presenter;

import com.example.aperez.retrofittest.mvp.model.ResponseModel;
import com.example.aperez.retrofittest.mvp.model.event.LatestFailureEvent;
import com.example.aperez.retrofittest.mvp.model.event.LatestSuccessEvent;
import com.example.aperez.retrofittest.mvp.view.ImageFragment;
import com.example.aperez.retrofittest.mvp.view.ResponseView;
import com.example.aperez.retrofittest.mvp.view.event.ImageClickedEvent;
import com.example.aperez.retrofittest.mvp.view.event.RefreshEvent;
import com.squareup.otto.Subscribe;

/**
 * Created by aperez on 24/01/17.
 */

public class ResponsePresenter {

    private ResponseView view;
    private ResponseModel model;

    public ResponsePresenter(ResponseModel model, ResponseView view) {
        this.model = model;
        this.view = view;

        init();
    }

    private void init() {
        getLatestImages();
    }

    public void getLatestImages() {
        view.setCards(model.getSavedImages());
    }

    @Subscribe
    public void latestImagesEventSuccess(LatestSuccessEvent event) {
        model.saveImages(event.getLatestResponse().getImages());
        view.setCards(event.getLatestResponse().getImages());
    }

    @Subscribe
    public void latesImagesEventFailure(LatestFailureEvent event) {
        view.showErrorToast();
    }

    @Subscribe
    public void imageClickedEvent(ImageClickedEvent event) {
        ImageFragment imageFragment = ImageFragment.newInstance(event.getId());
        imageFragment.show(view.getFragmentManager(), "image_fragment");
    }

    @Subscribe
    public void refreshClickedEvent(RefreshEvent event) {
        model.getLatestImages();
    }
}
