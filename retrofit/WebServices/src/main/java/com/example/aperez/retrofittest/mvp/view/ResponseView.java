package com.example.aperez.retrofittest.mvp.view;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.aperez.retrofittest.R;
import com.example.aperez.retrofittest.mvp.model.Image;
import com.squareup.otto.Bus;

import java.util.List;

import butterknife.BindView;

/**
 * Created by aperez on 24/01/17.
 */

public class ResponseView extends ActivityView {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    public ResponseView(Activity activity) {
        super(activity);
    }

    public void setCards(List<Image> images) {
        ImagesAdapter adapter = new ImagesAdapter(getActivity(), images);
        recyclerView.setAdapter(adapter);
    }

    public void showErrorToast() {
        Toast.makeText(getActivity(), R.string.response_error, Toast.LENGTH_LONG).show();
    }
}
