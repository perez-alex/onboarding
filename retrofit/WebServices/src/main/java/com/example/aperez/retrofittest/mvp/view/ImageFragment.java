package com.example.aperez.retrofittest.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aperez.retrofittest.R;
import com.example.aperez.retrofittest.mvp.model.ImageDialogModel;
import com.example.aperez.retrofittest.mvp.presenter.ImageDialogPresenter;
import com.example.aperez.retrofittest.utils.BusProvider;

/**
 * Created by aperez on 25/01/17.
 */

public class ImageFragment extends DialogFragment {

    private final static String ID = "id";

    private ImageDialogPresenter presenter;

    public ImageFragment() {
    }

    public static ImageFragment newInstance(String id) {

        Bundle args = new Bundle();
        args.putString(ID, id);
        ImageFragment fragment = new ImageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String id = getArguments().getString(ID);
        presenter = new ImageDialogPresenter(new ImageDialogModel(BusProvider.getInstance(), id), new ImageDialogView(this, getView()));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.image_dialog, container, false);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        BusProvider.register(presenter);
    }

    @Override
    public void onPause() {
        super.onPause();

        BusProvider.unregister(presenter);
    }
}
