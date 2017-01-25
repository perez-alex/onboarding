package com.example.aperez.retrofittest.mvp.presenter;

import android.widget.Toast;

import com.example.aperez.retrofittest.R;
import com.example.aperez.retrofittest.mvp.model.ImageDialogModel;
import com.example.aperez.retrofittest.mvp.model.ResponseModel;
import com.example.aperez.retrofittest.mvp.model.event.LatestSuccessEvent;
import com.example.aperez.retrofittest.mvp.view.ImageDialogView;
import com.example.aperez.retrofittest.mvp.view.ResponseView;
import com.example.aperez.retrofittest.mvp.view.event.ImageClickedEvent;
import com.example.aperez.retrofittest.utils.BusProvider;
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
    public void latesImagesEventFailure(LatestSuccessEvent event) {
        Toast.makeText(view.getActivity(), R.string.response_error, Toast.LENGTH_LONG);

    }

    @Subscribe
    public void imageClickedEvent(ImageClickedEvent event) {
        ImageDialogPresenter presenter = new ImageDialogPresenter(new ImageDialogModel(BusProvider.getInstance()),
                new ImageDialogView(view.getActivity()));
        BusProvider.register(presenter);
        presenter.getImagesDetail(event.getId());
    }

}
