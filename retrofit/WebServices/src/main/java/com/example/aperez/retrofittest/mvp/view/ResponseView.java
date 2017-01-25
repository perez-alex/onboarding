package com.example.aperez.retrofittest.mvp.view;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;

import com.example.aperez.retrofittest.R;
import com.example.aperez.retrofittest.mvp.model.Image;
import com.squareup.otto.Bus;

import java.util.List;

import butterknife.BindView;

/**
 * Created by aperez on 24/01/17.
 */

public class ResponseView extends ActivityView {


    private final Bus bus;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    public ResponseView(Activity activity, Bus bus) {
        super(activity);
        this.bus = bus;
    }

    public void setCards(List<Image> images) {
        ImagesAdapter adapter = new ImagesAdapter(bus, getActivity(), images);
        recyclerView.setAdapter(adapter);
    }
}
