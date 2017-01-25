package com.example.aperez.retrofittest.mvp.presenter;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.aperez.retrofittest.mvp.model.Image;
import com.example.aperez.retrofittest.mvp.model.ImageDialogModel;
import com.example.aperez.retrofittest.mvp.model.event.ImageDetailsSuccessEvent;
import com.example.aperez.retrofittest.mvp.view.ImageDialogView;
import com.example.aperez.retrofittest.mvp.view.ImageFragment;
import com.squareup.otto.Subscribe;

/**
 * Created by aperez on 25/01/17.
 */

public class ImageDialogPresenter {

    private ImageDialogModel model;
    private ImageDialogView view;

    public ImageDialogPresenter(ImageDialogModel model, ImageDialogView view){
        this.model = model;
        this.view = view;
    }

    public void getImagesDetail(String id){
        model.getImageDetails(id);
    }

    @Subscribe
    public void imageDetailsSuccessEvent(ImageDetailsSuccessEvent event){
        Image image = event.getImage();
        FragmentManager fragmentManager = ((AppCompatActivity)view.getActivity()).getSupportFragmentManager();
        ImageFragment imageFragment = ImageFragment.newInstance(image.getLargeUrl(),image.getCopyright(),image.getSite());
        imageFragment.show(fragmentManager, "image_fragment");
    }
}
