package com.example.aperez.retrofittest.mvp.presenter;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;

import com.example.aperez.retrofittest.mvp.model.MyContentProvider;
import com.example.aperez.retrofittest.mvp.model.ResponseModel;
import com.example.aperez.retrofittest.mvp.model.db.StoredImage;
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

public class ResponsePresenter implements LoaderManager.LoaderCallbacks<Cursor> {

    private ResponseView view;
    private ResponseModel model;

    public ResponsePresenter(ResponseModel model, ResponseView view) {
        this.model = model;
        this.view = view;

        init();
    }

    private void init() {
//        getStoredImages();
    }

    public void getStoredImages() {
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

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle cursor) {
        return new CursorLoader(view.getActivity(),
                MyContentProvider.createUri(StoredImage.class, null),
                null, null, null, null
        );
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        view.loadResults(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
