package com.example.aperez.retrofittest.mvp.presenter;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.aperez.retrofittest.R;
import com.example.aperez.retrofittest.mvp.model.ResponseModel;
import com.example.aperez.retrofittest.mvp.model.event.LatestFailureEvent;
import com.example.aperez.retrofittest.mvp.model.event.LatestSuccessEvent;
import com.example.aperez.retrofittest.mvp.view.ImageFragment;
import com.example.aperez.retrofittest.mvp.view.ResponseView;
import com.example.aperez.retrofittest.mvp.view.event.ImageClickedEvent;
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
    }

    public void getLatestImages() {
        model.getLatestImages();
    }

    @Subscribe
    public void latestImagesEventSuccess(LatestSuccessEvent event) {
        view.setCards(event.getLatestResponse().getImages());
    }

    @Subscribe
    public void latesImagesEventFailure(LatestFailureEvent event) {
        view.showErrorToast();
    }

    @Subscribe
    public void imageClickedEvent(ImageClickedEvent event) {
        FragmentManager fragmentManager = ((AppCompatActivity) view.getActivity()).getSupportFragmentManager();
        ImageFragment imageFragment = ImageFragment.newInstance(event.getId());
        imageFragment.show(fragmentManager, "image_fragment");
    }

}
